package com.nnlightctl.command.impl;

import com.nnlight.common.PropertiesUtil;
import com.nnlightctl.command.Command;
import com.nnlightctl.command.client.Context;
import com.nnlightctl.command.client.EchoClient;
import com.nnlightctl.command.event.MessageEvent;
import io.netty.buffer.ByteBuf;
import io.netty.util.CharsetUtil;

import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NettyClientCommand implements Command {

    public NettyClientCommand(MessageEvent event) {
        this();
        this.messageEvent = event;
    }

    public NettyClientCommand() {
        this.context = new Context(this);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            try {
                Properties properties = PropertiesUtil.load("config/client.properties");
                new EchoClient(properties.getProperty("host", "127.0.0.1"), Integer.parseInt(properties.getProperty("port", "56556")), context).start();
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        });

        //阻塞等待连接完成
        try {
            this.context.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void sendMsg(String msg) {
        context.sendMsg(msg);
    }

    @Override
    public void receiveMsg(ByteBuf in) {
        if (messageEvent != null) {
            messageEvent.receiveMsg(in);
        }
    }

    @Override
    public void close() {
        context.close();
    }

    private Context context;
    private MessageEvent messageEvent;
}
