package com.nnlight.netty.process.impl;

import com.nnlight.netty.process.Process;
import com.nnlightctl.net.CommandData;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class F0Process implements Process {

    private static final Logger log = LoggerFactory.getLogger(F0Process.class);

    @Override
    public void process(ChannelHandlerContext netServerContext, CommandData msg) {
        log.info("终端F0命令【申请UUID】");

        String uuid = UUID.randomUUID().toString();
        netServerContext.writeAndFlush(CommandData.getReturnTerminalUUID(uuid));
    }
}
