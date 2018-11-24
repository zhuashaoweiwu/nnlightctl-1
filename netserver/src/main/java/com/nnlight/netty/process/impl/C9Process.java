package com.nnlight.netty.process.impl;

import com.nnlight.netty.process.Process;
import com.nnlight.netty.server.EchoServer;
import com.nnlightctl.net.CommandData;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class C9Process implements Process {

    private static final Logger log = LoggerFactory.getLogger(C9Process.class);

    @Override
    public void process(ChannelHandlerContext netServerContext, CommandData msg) {
        log.info("命令客户端C9指令【设置终端的工作模式（自动或者手动）】");

        EchoServer.getGlobalApplicationContext().sendCommandTerminalAutoModel(msg.getRealtimeUUIDFromData(), msg.getData()[4]);
    }
}
