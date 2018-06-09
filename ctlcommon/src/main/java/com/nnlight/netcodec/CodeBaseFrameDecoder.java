package com.nnlight.netcodec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.ByteProcessor;
import java.util.List;

@ChannelHandler.Sharable
public class CodeBaseFrameDecoder extends ByteToMessageDecoder {
    private final int maxLength;
    private final boolean failFast;
    private final boolean stripDelimiter;
    private boolean discarding;
    private int discardedBytes;
    private int offset;

    public CodeBaseFrameDecoder(int maxLength) {
        this(maxLength, true, false);
    }

    public CodeBaseFrameDecoder(int maxLength, boolean stripDelimiter, boolean failFast) {
        this.maxLength = maxLength;
        this.failFast = failFast;
        this.stripDelimiter = stripDelimiter;
    }

    protected final void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        Object decoded = this.decode(ctx, in);
        if (decoded != null) {
            out.add(decoded);
        }

    }

    protected Object decode(ChannelHandlerContext ctx, ByteBuf buffer) throws Exception {
        int eol = this.findEndOfLine(buffer);
        int length;
        if (!this.discarding) {
            if (eol >= 0) {
                length = eol - buffer.readerIndex();
                int delimLength = buffer.getByte(eol) == (byte)0xFE ? 6 : 1;
                if (length > this.maxLength) {
                    buffer.readerIndex(eol + delimLength);
                    this.fail(ctx, length);
                    return null;
                } else {
                    ByteBuf frame;
                    if (this.stripDelimiter) {
                        frame = buffer.readRetainedSlice(length);
                        buffer.skipBytes(delimLength);
                    } else {
                        frame = buffer.readRetainedSlice(length + delimLength);
                    }

                    return frame;
                }
            } else {
                length = buffer.readableBytes();
                if (length > this.maxLength) {
                    this.discardedBytes = length;
                    buffer.readerIndex(buffer.writerIndex());
                    this.discarding = true;
                    this.offset = 0;
                    if (this.failFast) {
                        this.fail(ctx, "over " + this.discardedBytes);
                    }
                }

                return null;
            }
        } else {
            if (eol >= 0) {
                length = this.discardedBytes + eol - buffer.readerIndex();
                length = buffer.getByte(eol) == (byte)0xFE ? 6 : 1;
                buffer.readerIndex(eol + length);
                this.discardedBytes = 0;
                this.discarding = false;
                if (!this.failFast) {
                    this.fail(ctx, length);
                }
            } else {
                this.discardedBytes += buffer.readableBytes();
                buffer.readerIndex(buffer.writerIndex());
            }

            return null;
        }
    }

    private void fail(ChannelHandlerContext ctx, int length) {
        this.fail(ctx, String.valueOf(length));
    }

    private void fail(ChannelHandlerContext ctx, String length) {
        ctx.fireExceptionCaught(new RuntimeException("frame length (" + length + ") exceeds the allowed maximum (" + this.maxLength + ')'));
    }

    private int findEndOfLine(ByteBuf buffer) {
        int totalLength = buffer.readableBytes();
        int i = buffer.forEachByte(buffer.readerIndex() + this.offset, totalLength - this.offset, new ByteProcessor.IndexOfProcessor((byte)0xFE));
        if (i >= 0 && buffer.getByte(i + 1) == 0xFD && buffer.getByte(i + 2) == 0xFC && buffer.getByte(i + 3) == 0xFB
                && buffer.getByte(i + 4) == 0xFA && buffer.getByte(i + 5) == 0xF9) {
            this.offset = 0;
        } else {
            this.offset = totalLength;
        }

        return i;
    }
}
