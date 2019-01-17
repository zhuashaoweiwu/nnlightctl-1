package com.nnlight.netty.process.impl;

import com.nnlight.netty.process.Process;
import com.nnlight.netty.server.EchoServer;
import com.nnlightctl.net.CommandData;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class F3Process implements Process {

    private Logger log = LoggerFactory.getLogger(F3Process.class);

    @Override
    public void process(ChannelHandlerContext netServerContext, CommandData msg) {
        log.info("接收终端申请固件拆包指令");

        EchoServer.getGlobalApplicationContext().allClientSendCommand(msg);
    }
}
