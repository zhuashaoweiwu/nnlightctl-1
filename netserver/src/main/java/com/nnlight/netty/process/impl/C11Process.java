package com.nnlight.netty.process.impl;

import com.nnlight.netty.process.Process;
import com.nnlight.netty.server.EchoServer;
import com.nnlightctl.net.CommandData;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class C11Process implements Process {

    private static final Logger log = LoggerFactory.getLogger(C11Process.class);

    @Override
    public void process(ChannelHandlerContext netServerContext, CommandData msg) {
        log.info("客户端发送获取控制柜电表电能数据指令");

        byte[] data = msg.getData();
        byte[] directiveBytes = new byte[data.length - 4];
        System.arraycopy(data, 4, directiveBytes, 0, directiveBytes.length);

        EchoServer.getGlobalApplicationContext().invokeModbusByGateway(msg.getRealtimeUUIDFromData(), directiveBytes);
    }
}
