package com.nnlight.netty.process.impl;

import com.nnlight.netty.process.Process;
import com.nnlight.netty.server.EchoServer;
import com.nnlightctl.net.CommandData;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class B8Process implements Process {

    private static final Logger logger = LoggerFactory.getLogger(B8Process.class);

    @Override
    public void process(ChannelHandlerContext netServerContext, CommandData msg) {
        logger.info("命令层B8指令【回复终端ACK】");

        byte[] data = msg.getData();
        Boolean isSuccess = data[1] == (byte)0x00 ? true : false;

        EchoServer.getGlobalApplicationContext().allSendTerminalACK(data[0], isSuccess);
    }
}
