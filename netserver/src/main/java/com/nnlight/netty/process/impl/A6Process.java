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

public class A6Process implements Process {
    private static final Logger logger = LoggerFactory.getLogger(A6Process.class);

    @Override
    public void process(ChannelHandlerContext netServerContext, CommandData msg) {

        logger.info(LocalDate.now() + " " + LocalTime.now() + " 设置亮/灭灯定时策略 0xA6[" + msg.getData()[0] + "]");

        byte[] id = new byte[4];
        System.arraycopy(msg.getData(), 0, id, 0, msg.getDataLength());

        String realtimeId = BytesHexStrTranslate.bytesToHexFun(id);
        EchoServer.getGlobalApplicationContext().batchConfigOpenCloseStrategy(realtimeId);
    }
}
