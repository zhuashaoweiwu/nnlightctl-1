package com.nnlight.netty.process.impl;

import com.nnlight.netty.process.Process;
import com.nnlight.netty.server.EchoServer;
import com.nnlightctl.net.CommandData;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class E0Process implements Process {

    private static final Logger logger = LoggerFactory.getLogger(E0Process.class);

    @Override
    public void process(ChannelHandlerContext netServerContext, CommandData msg) {
        logger.info("接收E0固定消息");

        EchoServer.getGlobalApplicationContext().allClientSendCommand(msg);
    }
}
