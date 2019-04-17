package com.nnlight.netty.process.impl;

import com.nnlight.common.DateTimeUtil;
import com.nnlight.netty.process.Process;
import com.nnlight.netty.server.EchoServer;
import com.nnlightctl.net.CommandData;
import com.nnlightctl.util.BytesHexStrTranslate;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalTime;

public class A5Process implements Process {
    private static final Logger logger = LoggerFactory.getLogger(A5Process.class);

    @Override
    public void process(ChannelHandlerContext netServerContext, CommandData msg) {

        logger.info(LocalDate.now() + " " + LocalTime.now() + " 服务器对设备广播对时 ");


        EchoServer.getGlobalApplicationContext().batchConfigSetTime(DateTimeUtil.nowBytes());
    }
}
