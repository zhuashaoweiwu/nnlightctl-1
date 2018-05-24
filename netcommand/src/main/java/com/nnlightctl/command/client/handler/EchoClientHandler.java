package com.nnlightctl.command.client.handler;

import com.nnlightctl.command.client.Context;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

@ChannelHandler.Sharable
public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

    public EchoClientHandler() {}

    public EchoClientHandler(Context context) {
        this.context = context;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        context.setChannelHandlerContext(ctx);
        context.run();
        //切换客户端类型为命令客户端
        ctx.writeAndFlush(Unpooled.wrappedBuffer("zxx\r\n".getBytes()));
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, ByteBuf in) {
        context.receiveMsg(in);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

    private Context context;
}
