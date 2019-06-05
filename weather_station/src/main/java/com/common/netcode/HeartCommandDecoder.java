package com.common.netcode;

import com.netty.dto.HeartCommand;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class HeartCommandDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        int number = byteBuf.readableBytes();
        if (number==24){
            byte[] data=new byte[number];
            byteBuf.readBytes(data);
            byte[] mac=new byte[6];
            System.arraycopy(data,11,mac,0,6);
            heartCommand.setData(mac);
            list.add(heartCommand);
        }

    }

    private HeartCommand heartCommand;

    public HeartCommandDecoder(HeartCommand heartCommand){
        this.heartCommand=heartCommand;
    }

}
