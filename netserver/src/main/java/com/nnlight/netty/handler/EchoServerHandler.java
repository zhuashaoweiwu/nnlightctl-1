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
        StringBuilder result = new StringBuilder();
        String command = in.toString(CharsetUtil.UTF_8);
        if ("zxx".equals(command)) {
            String uuid = ctx.channel().id().asLongText();
            ChannelWrap channelWrap = applicationContext.getClientChannelMap().remove(uuid);
            applicationContext.getCommandMap().put(uuid, channelWrap);
            result.append("成功转换客户端为命令客户端");
        } else if ("lookall".equals(command)) {
            result.append(applicationContext.commandLookAll());
        } else if (command != null && command.startsWith("send")) {
            String[] params = command.split(" ");
            String uuid = params[1];
            String sendMessage = params[2];
            if (uuid == null || sendMessage == null) {
                throw new RuntimeException("send 命令参数不完整！");
            }
            applicationContext.commandSend(uuid, sendMessage);
            result.append("send success！");
        } else {
            result.append(command);
        }

        ctx.write(Unpooled.wrappedBuffer((result.toString() + "\r\n").getBytes()));
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
