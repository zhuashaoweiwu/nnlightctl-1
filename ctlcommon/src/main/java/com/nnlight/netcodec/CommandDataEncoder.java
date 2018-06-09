package com.nnlight.netcodec;

import com.nnlightctl.net.CommandData;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class CommandDataEncoder extends MessageToByteEncoder<CommandData> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, CommandData commandData, ByteBuf byteBuf) throws Exception {

        byte[] data = new byte[14 + commandData.getDataLength()];
        int k = 0;
        //帧起始符
        data[k++] = commandData.getStart0();
        //地址域
        System.arraycopy(commandData.getAddr(), 0, data, k, commandData.getAddr().length);
        k += commandData.getAddr().length;
        //帧起始符
        data[k++] = commandData.getStart1();
        //控制码
        data[k++] = commandData.getControl();
        //数据域长度
        data[k++] = commandData.getDataLength();
        //数据域
        System.arraycopy(commandData.getData(), 0, data, k, commandData.getDataLength());
        k += commandData.getDataLength();
        //校验码
        data[k++] = commandData.getCheck();
        //帧结束符
        data[k++] = commandData.getEnd0();
        //帧识别码
        System.arraycopy(commandData.getEnd1(), 0, data, k, commandData.getEnd1().length);

        byteBuf.writeBytes(data);
    }
}