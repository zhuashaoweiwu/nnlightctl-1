package com.nnlight.netty.process.impl;

import com.nnlight.netty.process.Process;
import com.nnlight.netty.server.EchoServer;
import com.nnlightctl.net.CommandData;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class B2Process implements Process {

    private Logger logger = LoggerFactory.getLogger(B2Process.class);

    @Override
    public void process(ChannelHandlerContext netServerContext, CommandData msg) {
        logger.info("命令端往终端发送更改电源方式命令");

        EchoServer.getGlobalApplicationContext().sendTerminalPowerType(msg.getRealtimeUUIDFromData(), msg.getData()[4]);
    }
}
