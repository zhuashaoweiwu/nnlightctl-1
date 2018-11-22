package com.nnlight.netty.process.impl;

import com.nnlight.common.DateTimeUtil;
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

        netServerContext.writeAndFlush(CommandData.getCheckTimeCommand(DateTimeUtil.nowBytes()));
    }
}
