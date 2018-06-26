package com.nnlight.netty.process.impl;

import com.nnlight.netty.process.Process;
import com.nnlight.netty.server.EchoServer;
import com.nnlightctl.net.CommandData;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class C4Process implements Process {

    private static final Logger logger = LoggerFactory.getLogger(C4Process.class);

    @Override
    public void process(ChannelHandlerContext netServerContext, CommandData msg) {
        logger.info("发送重启/复位指令");

        EchoServer.getGlobalApplicationContext().allSendCommandReset();
    }
}
