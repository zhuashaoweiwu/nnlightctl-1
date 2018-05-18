package com.nnlight.netty.handler;

import com.nnlight.netty.server.po.PackageInfo;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class EchoUDPServerHandler extends SimpleChannelInboundHandler<PackageInfo> {
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//        cause.printStackTrace();
        System.err.println("客户端关闭！");
        ctx.close();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, PackageInfo o) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(o.getMsg());

        System.out.println(stringBuilder.toString());

        //回写到客户端
        PackageInfo backPackage = new PackageInfo();
        backPackage.setMsg(o.getMsg());
        backPackage.setInetAddress(o.getInetAddress());
        channelHandlerContext.channel().writeAndFlush(backPackage);
    }
}
