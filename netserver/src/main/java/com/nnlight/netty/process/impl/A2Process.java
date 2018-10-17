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

public class A2Process implements Process {
    private static final Logger logger = LoggerFactory.getLogger(A2Process.class);

    @Override
    public void process(ChannelHandlerContext netServerContext, CommandData msg) {

        logger.info(LocalDate.now() + " " + LocalTime.now() + " 发送重启/复位 0xA2[" + msg.getData()[0] + "]");

        byte[] id = new byte[4];
        System.arraycopy(msg.getData(), 0, id, 0, msg.getDataLength());

        String realtimeId = BytesHexStrTranslate.bytesToHexFun(id);
        EchoServer.getGlobalApplicationContext().batchConfigRestart(realtimeId);
    }
}
