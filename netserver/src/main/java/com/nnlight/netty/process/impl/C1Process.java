package com.nnlight.netty.process.impl;

import com.nnlight.netty.process.Process;
import com.nnlight.netty.server.EchoServer;
import com.nnlight.netty.server.po.ChannelWrap;
import com.nnlightctl.net.CommandData;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class C1Process implements Process {

    private static final Logger logger = LoggerFactory.getLogger(C1Process.class);

    @Override
    public void process(ChannelHandlerContext netServerContext, CommandData msg) {
        String command = new String(msg.getData());
        StringBuilder result = new StringBuilder();
        if ("zxx".equals(command)) {
            logger.info("更换上层命令客户端指令");

            String uuid = netServerContext.channel().id().asShortText();
            ChannelWrap channelWrap = EchoServer.getGlobalApplicationContext().getClientChannelMap().remove(uuid);
            EchoServer.getGlobalApplicationContext().getCommandMap().put(uuid, channelWrap);
            result.append("Translate Command Client Successful!");
        } else if ("lookall".equals(command)) {
            logger.info("查看下层连接客户端指令");

            result.append(EchoServer.getGlobalApplicationContext().commandLookAll());
        }

        EchoServer.getGlobalApplicationContext().allClientSendCommand(new CommandData(result.toString()));
    }
}
