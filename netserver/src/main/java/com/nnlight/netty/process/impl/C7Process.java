package com.nnlight.netty.process.impl;

import com.nnlight.netty.process.Process;
import com.nnlight.netty.server.EchoServer;
import com.nnlightctl.net.CommandData;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class C7Process implements Process {
    private static final Logger logger = LoggerFactory.getLogger(C7Process.class);

    @Override
    public void process(ChannelHandlerContext netServerContext, CommandData msg) {
        logger.info("命令层C7指令【设置任务开关策略】");

        EchoServer.getGlobalApplicationContext().allConfigTerminalSwitchPolicy(msg);
    }
}
