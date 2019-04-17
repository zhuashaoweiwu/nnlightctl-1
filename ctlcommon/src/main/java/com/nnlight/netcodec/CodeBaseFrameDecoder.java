package com.nnlight.netcodec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.util.ByteProcessor;
import java.util.List;

public class CodeBaseFrameDecoder {
    public static ByteToMessageDecoder getCodeBaseFrameDecoder(byte[] code) {
        ByteBuf delimiter = Unpooled.copiedBuffer(code);

        return new DelimiterBasedFrameDecoder(1024, false, delimiter);
    }

    public static final byte[] DELIMITER = new byte[] {(byte) 0xFE, (byte) 0xFD, (byte) 0xFC, (byte) 0xFB, (byte) 0xFA, (byte) 0xF9};
}
