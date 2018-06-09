package com.nnlight.netcodec;

import com.nnlightctl.net.CommandData;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class CommandDataDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        byte[] data = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(data);

        CommandData commandData = new CommandData();
        //地址域
        System.arraycopy(data, 1, commandData.getAddr(), 0, 6);
        //控制码
        commandData.setControl(data[8]);
        //数据长度域
        byte dataLength = data[9];
        int iLength = dataLength & 0x000000ff;
        commandData.setDataLength(dataLength);
        //数据域
        byte[] dataArea = new byte[iLength];
        try {
            System.arraycopy(data, 10, dataArea, 0, iLength);
        } catch (ArrayIndexOutOfBoundsException e) {
            //源data
            System.err.print("data : [");
            for (byte b : data) {
                System.err.print(b);
                System.err.print(", ");
            }
            System.err.print("]");
            //目的地址长度
            System.err.println("Length : " + iLength);
        }
        commandData.setData(dataArea);
        //检校码
        commandData.setCheck(data[10 + dataLength]);

        if (!commandData.check()) {
            throw new RuntimeException("命令校验失败！");
        }

        list.add(commandData);
    }
}
