package com.nnlightctl.command.client;

import com.nnlightctl.command.Command;
import com.nnlightctl.net.CommandData;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.CharsetUtil;

import java.util.concurrent.CountDownLatch;

public class Context {

    public Context() {
        this.countDownLatch = new CountDownLatch(1);
    }

    public Context(Command command) {
        this();
        this.command = command;
    }

    public void await() throws InterruptedException {
        if (this.countDownLatch != null) {
            this.countDownLatch.await();
        }
    }

    public void run() {
        if (this.countDownLatch != null) {
            this.countDownLatch.countDown();
        }
    }

    public void receiveMsg(CommandData in) {
        if (command != null) {
            command.receiveMsg(in);
        }
    }

    public void sendMsg(String msg) {
        channelHandlerContext.writeAndFlush(new CommandData(msg));
    }

    public void sendLightAdjust(int percent) {
        channelHandlerContext.writeAndFlush(new CommandData(percent, (byte)0xc2));
    }

    public void resetTerminal() {
        channelHandlerContext.writeAndFlush(CommandData.getC4CommandData());
    }

    public void configTerminalSendMsgPeriod(int period) {
        channelHandlerContext.writeAndFlush(CommandData.getC5CommandData(period));
    }

    public ChannelHandlerContext getChannelHandlerContext() {
        return channelHandlerContext;
    }

    public void setChannelHandlerContext(ChannelHandlerContext channelHandlerContext) {
        this.channelHandlerContext = channelHandlerContext;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void close() {
        if (channelHandlerContext != null) {
            channelHandlerContext.close();
        }
    }

    private Command command;
    private ChannelHandlerContext channelHandlerContext;
    private CountDownLatch countDownLatch;
}
