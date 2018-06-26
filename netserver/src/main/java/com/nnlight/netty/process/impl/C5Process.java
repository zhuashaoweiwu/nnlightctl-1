package com.nnlight.netty.process.impl;

import com.nnlight.common.ByteConvert;
import com.nnlight.netty.process.Process;
import com.nnlight.netty.server.EchoServer;
import com.nnlightctl.net.CommandData;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class C5Process implements Process {

    private static final Logger logger = LoggerFactory.getLogger(C5Process.class);

    @Override
    public void process(ChannelHandlerContext netServerContext, CommandData msg) {
        logger.info("命令客户端C5指令【设置终端定时发送消息周期】");

        EchoServer.getGlobalApplicationContext().allSendCommandConfigTerminalSendMsgPeriod(ByteConvert.bytesToInt(msg.getData()));
    }
}
