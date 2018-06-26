package com.nnlight.netty.process.impl;

import com.nnlight.netty.process.Process;
import com.nnlight.netty.server.EchoServer;
import com.nnlightctl.net.CommandData;
import io.netty.channel.ChannelHandlerContext;

public class CommonProcess implements Process {
    @Override
    public void process(ChannelHandlerContext netServerContext, CommandData msg) {
        EchoServer.getGlobalApplicationContext().allClientSendCommand(msg);
    }
}
