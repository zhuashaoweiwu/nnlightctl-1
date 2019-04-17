package com.nnlight.netty.process.impl;

import com.nnlight.netty.process.Process;
import com.nnlightctl.net.CommandData;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalTime;

public class D7Process implements Process {
    private static final Logger logger = LoggerFactory.getLogger(D7Process.class);

    @Override
    public void process(ChannelHandlerContext netServerContext, CommandData msg) {

        logger.info(LocalDate.now() + " " + LocalTime.now() + " 设置终端设备的工作模式（手动or自动） 0xD7[" + msg.getControl() + "]");
        System.out.println();
        /*byte[] id = new byte[4];
        System.arraycopy(msg.getData(), 1, id, 0, 4);
        String realtimeId = BytesHexStrTranslate.bytesToHexFun(id);
        EchoServer.getGlobalApplicationContext().allserviceFixedInfo(realtimeId);*/
    }
}
