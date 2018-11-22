package com.nnlight.netty.process.impl;

import com.nnlight.netty.process.Process;
import com.nnlight.netty.server.EchoServer;
import com.nnlightctl.net.CommandData;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class E1Process implements Process {
    private Logger logger = LoggerFactory.getLogger(E1Process.class);
    @Override
    public void process(ChannelHandlerContext netServerContext, CommandData msg) {
        logger.info("收到E1心跳数据包");

        EchoServer.getGlobalApplicationContext().allClientSendCommand(msg);
    }
}
