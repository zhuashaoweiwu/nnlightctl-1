package com.nnlight.netty.process.impl;

import com.nnlight.netty.process.Process;
import com.nnlight.netty.server.EchoServer;
import com.nnlightctl.net.CommandData;
import com.nnlightctl.util.BytesHexStrTranslate;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalTime;

public class D0Process implements Process {
    private static final Logger logger = LoggerFactory.getLogger(D0Process.class);

    @Override
    public void process(ChannelHandlerContext netServerContext, CommandData msg) {
        logger.info(LocalDate.now() + " " + LocalTime.now() + "获取模块回复的状态信息【" + msg.toHexString() + "】");

        EchoServer.getGlobalApplicationContext().allClientSendCommand(msg);
    }
}
