package com.nnlight.netty.process.impl;

import com.nnlight.netty.process.Process;
import com.nnlight.netty.server.EchoServer;
import com.nnlightctl.net.CommandData;
import com.nnlightctl.util.BytesHexStrTranslate;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.LocalTime;

public class A0Process implements Process {
    private static final Logger logger = LoggerFactory.getLogger(A0Process.class);

    @Override
    public void process(ChannelHandlerContext netServerContext, CommandData msg) {
        logger.info(LocalDate.now() + " " + LocalTime.now() + " 发送服务器获取模块信息D0指令");

        String realtimeId = msg.getRealtimeUUIDFromData();

        byte[] modelUUIDBytes = new byte[36];
        System.arraycopy(msg.getData(), 4, modelUUIDBytes, 0, 36);
        String modelUUID = new String(modelUUIDBytes, Charset.forName("UTF-8"));

        EchoServer.getGlobalApplicationContext().commandGetModelState(realtimeId, modelUUID);
    }
}
