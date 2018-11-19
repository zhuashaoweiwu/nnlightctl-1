package com.nnlight.netty.process.impl;

import com.nnlight.netty.process.Process;
import com.nnlightctl.net.CommandData;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class F1Process implements Process {

    private Logger logger = LoggerFactory.getLogger(F1Process.class);

    @Override
    public void process(ChannelHandlerContext netServerContext, CommandData msg) {
        logger.info("终端F1指令【申请校时】");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String[] timeSeprater = dateFormat.format(new Date()).split("-");
        byte[] timeData = new byte[6];
        timeData[0] = (byte)(Integer.parseInt(timeSeprater[0]) - 2000);
        timeData[1] = Byte.parseByte(timeSeprater[1]);
        timeData[2] = Byte.parseByte(timeSeprater[2]);
        timeData[3] = Byte.parseByte(timeSeprater[3]);
        timeData[4] = Byte.parseByte(timeSeprater[4]);
        timeData[5] = Byte.parseByte(timeSeprater[5]);

        netServerContext.writeAndFlush(CommandData.getCheckTimeCommand(timeData));
    }
}
