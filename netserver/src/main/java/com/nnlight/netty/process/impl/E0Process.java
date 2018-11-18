package com.nnlight.netty.process.impl;

import com.nnlight.common.DateTimeUtil;
import com.nnlight.netty.process.Process;
import com.nnlight.netty.server.EchoServer;
import com.nnlightctl.net.CommandData;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

public class E0Process implements Process {

    private static final Logger logger = LoggerFactory.getLogger(E0Process.class);

    @Override
    public void process(ChannelHandlerContext netServerContext, CommandData msg) {
        logger.info(DateTimeUtil.nowStr() + " 接收 " + msg.getUUID() + " E0固定消息[" + msg.toHexString() + "]");

        EchoServer.getGlobalApplicationContext().allClientSendCommand(msg);

        //发送E0消息到Kafka
//        EchoServer.getGlobalApplicationContext().sendE02Kafka(msg);
    }
}
