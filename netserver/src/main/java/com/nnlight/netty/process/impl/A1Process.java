package com.nnlight.netty.process.impl;

import com.nnlight.netty.process.Process;
import com.nnlight.netty.server.EchoServer;
import com.nnlightctl.net.CommandData;
import com.nnlightctl.util.ByteConvert;
import com.nnlightctl.util.BytesHexStrTranslate;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalTime;

public class A1Process implements Process {

    private static final Logger logger = LoggerFactory.getLogger(A1Process.class);

    @Override
    public void process(ChannelHandlerContext netServerContext, CommandData msg) {

        logger.info(LocalDate.now() + " " + LocalTime.now() + " 设置模块继电器状态指令D1");

        byte[] modelUUIDBytes = new byte[36];
        System.arraycopy(msg.getData(), 4, modelUUIDBytes, 0, 36);

        byte[] modelLoopBytes = new byte[2];
        System.arraycopy(msg.getData(), 40, modelLoopBytes, 0, 2);

        byte[] modelLoopStateBytes = new byte[2];
        System.arraycopy(msg.getData(), 42, modelLoopStateBytes, 0, 2);

        EchoServer.getGlobalApplicationContext().configModelState(msg.getRealtimeUUIDFromData(),
                new String(modelUUIDBytes), ByteConvert.bytesToShort(modelLoopBytes), ByteConvert.bytesToShort(modelLoopStateBytes));
    }
}
