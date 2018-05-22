package com.nnlight.netty.handler;

import com.nnlight.netty.server.EchoServer;
import com.nnlight.netty.server.po.ChannelWrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@ChannelHandler.Sharable
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(EchoServerHandler.class);

    private EchoServer applicationContext;

    public EchoServerHandler(EchoServer applicationContext) {
        this.applicationContext = applicationContext;
    }

    public EchoServerHandler() {

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf in = (ByteBuf)msg;
        logger.info(LocalDate.now() + " " + LocalTime.now() + " Server received:" + in.toString(CharsetUtil.UTF_8));
        ctx.write(in);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        logger.info("Server Send Msg...");
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER);
//                .addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        if (applicationContext != null) {
            ChannelWrap wrap = new ChannelWrap();
            Channel channel = ctx.channel();
            String name = channel.id().asLongText();
            wrap.setUuid(name);
            wrap.setName(name);
            wrap.setChannel(channel);
            wrap.setContext(ctx);
            applicationContext.getClientChannelMap().put(name, wrap);

            logger.info(LocalDate.now() + " " + LocalTime.now() + " TCP Serve receive Client UUID : " + name);
            String welcome = "welcome, " + name + " \n\r";
            ByteBuf response = Unpooled.wrappedBuffer(welcome.getBytes());
            ctx.writeAndFlush(response);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        ChannelWrap wrap = applicationContext.getClientChannelMap().get(ctx.channel().id().asLongText());

        logger.error(LocalDate.now() + " " + LocalTime.now() + " " + wrap.getChannel().remoteAddress().toString() + " 客户端关闭！");
        applicationContext.getClientChannelMap().remove(ctx.channel().id().asLongText());
        ctx.close();
    }
}
