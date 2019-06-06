package com.nnlightctl.command.client.handler;

import com.nnlightctl.command.client.Context;
import com.nnlightctl.net.CommandData;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ChannelHandler.Sharable
public class EchoClientHandler extends SimpleChannelInboundHandler<CommandData> {

    private static final Logger logger = LoggerFactory.getLogger(EchoClientHandler.class);

    public EchoClientHandler() {}

    public EchoClientHandler(Context context) {
        this.context = context;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        context.setChannelHandlerContext(ctx);
        //context.run();

        //切换客户端类型为命令客户端
        ctx.writeAndFlush(new CommandData("zxx"));
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, CommandData in) {
        context.receiveMsg(in);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        logger.error(cause.getMessage());
        ctx.close();

        //context.reConnect();
    }

    private Context context;
}
