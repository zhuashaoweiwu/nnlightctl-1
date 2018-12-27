package com.nnlight.netcodec;

import com.nnlightctl.util.ByteConvert;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageCodec;
import io.netty.util.ByteProcessor;

import java.util.List;

public class ModbusBytesToMessageCodec extends ByteToMessageCodec<ByteBuf> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, ByteBuf byteBuf2) throws Exception {
        //1.获取控制码并判断是否modbus指令控制码
        if (byteBuf.readableBytes() > 8 && byteBuf.getByte(8) == (byte)0x11) {
            //2.如果是modbus指令则发送data域中的字节
            byte dataLength = byteBuf.getByte(9);
            int dataIntLength = dataLength & 0x000000ff;
            byte[] data = new byte[dataIntLength];
            byteBuf.getBytes(10, data, 0, dataIntLength);
            byteBuf2.writeBytes(data);
        } else {
            byteBuf2.writeBytes(byteBuf);
        }
    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        if (byteBuf == null || byteBuf.readableBytes() < 1) {
            return;
        }
        //通过帧结束符0xFEFDFCFBFAF9判断是否标准帧格式
        if (findEndOfLine(byteBuf) >= 0) {
            //标准帧格式
            list.add(byteBuf.retainedDuplicate());
        } else {
            //非标准帧格式
            int totalLength = byteBuf.readableBytes();
            byte[] data = new byte[totalLength];
            byteBuf.getBytes(0, data);

            //构造commandData格式标准格式帧
            long sum = 0L;

            byte[] commandData = new byte[18 + totalLength];
            int k = 0;

            commandData[k++] = (byte)0x68;
            sum += (byte)0x68;

            for (int i = 1; i < 7; ++i) {
                commandData[k++] = (byte)0x00;
            }

            commandData[k++] = (byte)0x68;
            sum += (byte)0x68;

            commandData[k++] = (byte)0x12;
            sum += (byte)0x12;

            commandData[k++] = (byte)totalLength;
            sum += (byte)totalLength;

            System.arraycopy(data, 0, commandData, k, totalLength);
            k += totalLength;

            //验证码
            for (int i = 0; i < totalLength; ++i) {
                sum += data[i];
            }
            commandData[k++] = (byte)sum;

            commandData[k++] = (byte)0x16;

            byte[] endOfLine = new byte[] {(byte)0xFE, (byte)0xFD, (byte)0xFC, (byte)0xFB, (byte)0xFA, (byte)0xF9};
            System.arraycopy(endOfLine, 0, commandData, k, endOfLine.length);
            k += endOfLine.length;

            ByteBuf byteBuf1 = Unpooled.copiedBuffer(commandData);
            list.add(byteBuf1);
        }

        byteBuf.skipBytes(byteBuf.readableBytes());
    }

    //判断是否存在0xFEFDFCFBFAF9结束帧
    private int findEndOfLine(ByteBuf byteBuf) {
        int totalLength = byteBuf.readableBytes();
        byte startEndOfLine = (byte)0xFE;
        ByteProcessor byteProcessor = new ByteProcessor.IndexOfProcessor(startEndOfLine);
        int lastIndex = -1;
        int index = byteBuf.forEachByte(byteBuf.readerIndex(), totalLength, byteProcessor);
        while (index >= 0) {
            lastIndex = index;
            index = byteBuf.forEachByte(index + 1, totalLength - index - 1, byteProcessor);
        }
        boolean flag = true;
        if (lastIndex >= 0) {
            for (int k = 1; k < 6; ++k) {
                if (byteBuf.getByte(lastIndex + k) != (startEndOfLine - k)) {
                    flag = false;
                    break;
                }
            }
        }

        if (flag) {
            return lastIndex;
        }

        return -1;
    }
}
