package com.nnlight.netty.process.impl;

import com.nnlight.netty.process.Process;
import com.nnlight.netty.server.EchoServer;
import com.nnlightctl.net.CommandData;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class C8Process implements Process {
    private static final Logger logger = LoggerFactory.getLogger(C8Process.class);

    @Override
    public void process(ChannelHandlerContext netServerContext, CommandData msg) {
        logger.info("命令层C8指令【读取终端信息】");

        EchoServer.getGlobalApplicationContext().allSendCommandReadTerminalInfo();
    }
}
