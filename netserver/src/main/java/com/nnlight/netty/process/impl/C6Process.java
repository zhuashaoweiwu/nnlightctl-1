package com.nnlight.netty.process.impl;

import com.nnlight.netty.process.Process;
import com.nnlight.netty.server.EchoServer;
import com.nnlightctl.net.CommandData;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class C6Process implements Process {
    private static final Logger logger = LoggerFactory.getLogger(C6Process.class);

    @Override
    public void process(ChannelHandlerContext netServerContext, CommandData msg) {
        logger.info("命令客户端C6指令【控制柜断电/通电指令】");

        Boolean eleboxOn = msg.getData()[0] == (byte)0x01 ? Boolean.TRUE : Boolean.FALSE;
        EchoServer.getGlobalApplicationContext().allSendCommandTerminalEleboxOn(eleboxOn);
    }
}
