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

public class C2Process implements Process {

    private static final Logger logger = LoggerFactory.getLogger(C2Process.class);

    @Override
    public void process(ChannelHandlerContext netServerContext, CommandData msg) {
        logger.info(LocalDate.now() + " " + LocalTime.now() + " 发送灯具调光指令,调光参数[" + msg.getData()[0] + "]");
        byte[] channelIdBytes = new byte[4];
        System.arraycopy(msg.getData(), 1, channelIdBytes, 0, 4);
        String shortChannelId = BytesHexStrTranslate.bytesToHexFun(channelIdBytes);
        if (shortChannelId.equalsIgnoreCase("00000000")) {
            EchoServer.getGlobalApplicationContext().allSendCommandLightAdjust(msg.getData()[0]);
        } else {
            EchoServer.getGlobalApplicationContext().sendCommandLightAdjust(shortChannelId, msg.getData()[0]);
        }
    }
}
