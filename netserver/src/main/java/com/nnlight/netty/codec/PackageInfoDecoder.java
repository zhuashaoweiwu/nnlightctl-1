package com.nnlight.netty.codec;

import com.nnlight.netty.server.po.PackageInfo;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

public class PackageInfoDecoder extends MessageToMessageDecoder<DatagramPacket> {
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket, List<Object> list) throws Exception {
        ByteBuf byteBuf = datagramPacket.content();
        PackageInfo packageInfo = new PackageInfo();
        byte[] bytes = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(bytes);
        packageInfo.setMsg(new String(bytes));
        packageInfo.setInetAddress(datagramPacket.sender());
        list.add(packageInfo);
    }
}
