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
        byte deviceType = msg.getAddr()[5];
        if (deviceType == (byte)0x03) { //NB透传
            logger.info("收到E1心跳数据包，来源NB透传，UUID:" + msg.getUUID());
        }

        if (deviceType == (byte)0x04) { //路由透传
            logger.info("收到E1心跳数据包，来源路由透传，network:" + msg.getNetworkAddr());
        }


        EchoServer.getGlobalApplicationContext().allClientSendCommand(msg);
    }
}
