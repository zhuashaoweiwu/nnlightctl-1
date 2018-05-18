package com.nnlight.netty.codec;

import com.nnlight.netty.server.po.PackageInfo;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.net.InetSocketAddress;
import java.util.List;

public class PackageInfoEncode extends MessageToMessageEncoder<PackageInfo> {
    private final InetSocketAddress remoteAddress;

    public PackageInfoEncode(InetSocketAddress address) {
        this.remoteAddress = address;
    }

    public PackageInfoEncode() {
        remoteAddress = null;
    }

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, PackageInfo packageInfo, List<Object> list) throws Exception {
        ByteBuf buf = channelHandlerContext.alloc().buffer(packageInfo.getMsg().getBytes().length);
        buf.writeBytes(packageInfo.getMsg().getBytes());
        if (this.remoteAddress != null) {
            list.add(new DatagramPacket(buf, remoteAddress));
        } else {
            list.add(new DatagramPacket(buf, packageInfo.getInetAddress()));
        }
    }
}
