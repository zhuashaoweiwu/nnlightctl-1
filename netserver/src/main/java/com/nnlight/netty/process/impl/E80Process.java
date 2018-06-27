package com.nnlight.netty.process.impl;

import com.nnlight.netty.process.Process;
import com.nnlight.netty.server.EchoServer;
import com.nnlightctl.net.CommandData;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class E80Process implements Process {
    private static final Logger logger = LoggerFactory.getLogger(E80Process.class);

    @Override
    public void process(ChannelHandlerContext netServerContext, CommandData msg) {
        logger.info("终端80指令【终端对指令应答】");

        byte originalCommand = msg.getData()[0];

        EchoServer.getGlobalApplicationContext().allClientSendCommand(msg);
    }
}
