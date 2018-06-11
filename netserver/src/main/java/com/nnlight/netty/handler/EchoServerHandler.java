package com.nnlight.netty.handler;

import com.nnlight.netty.server.EchoServer;
import com.nnlight.netty.server.po.ChannelWrap;
import com.nnlightctl.net.CommandData;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalTime;

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
        CommandData commandData = (CommandData)msg;

        if ((commandData.getControl() & 0xf0) == 0xc0) {
            //控制客户端处理
            commandClientProcess(ctx, commandData);
        } else {
            //物联网客户端处理
            netClientProcess(ctx, commandData);
        }
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
//            applicationContext.allSendCommandLightAdjust(0);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        ChannelWrap wrap = applicationContext.getClientChannelMap().get(ctx.channel().id().asLongText());

        logger.error(LocalDate.now() + " " + LocalTime.now() + " " + wrap.getChannel().remoteAddress().toString() + " 客户端关闭！");
        applicationContext.getClientChannelMap().remove(ctx.channel().id().asLongText());
        ctx.close();
    }

    private void commandClientProcess(ChannelHandlerContext ctx, CommandData msg) {
        switch (msg.getControl()) {
            //字符型命令
            case (byte)0xc1:
                String command = new String(msg.getData());
                StringBuilder result = new StringBuilder();
                if ("zxx".equals(command)) {
                    String uuid = ctx.channel().id().asLongText();
                    ChannelWrap channelWrap = applicationContext.getClientChannelMap().remove(uuid);
                    applicationContext.getCommandMap().put(uuid, channelWrap);
                    result.append("Translate Command Client Successful!");
                } else if ("lookall".equals(command)) {
                    result.append(applicationContext.commandLookAll());
                }

                ctx.writeAndFlush(new CommandData(result.toString()));
                break;

                //灯具灯光调节命令
            case (byte)0xc2:
                logger.info(LocalDate.now() + " " + LocalTime.now() + " 发送灯具调光指令,调光参数[" + msg.getData()[0] + "]");
                applicationContext.allSendCommandLightAdjust(msg.getData()[0]);
                break;
        }

    }

    private void netClientProcess(ChannelHandlerContext ctx, CommandData msg) {
        logger.info(LocalDate.now() + " " + LocalTime.now() + " 接收灯具调光指令返回");
        applicationContext.allClientSendCommand(msg);
    }
}
