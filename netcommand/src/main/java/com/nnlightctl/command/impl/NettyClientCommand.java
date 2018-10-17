package com.nnlightctl.command.impl;

import com.nnlight.common.PropertiesUtil;
import com.nnlightctl.command.Command;
import com.nnlightctl.command.client.Context;
import com.nnlightctl.command.client.EchoClient;
import com.nnlightctl.command.event.MessageEvent;
import com.nnlightctl.net.CommandData;
import com.nnlightctl.vo.SceneView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class NettyClientCommand implements Command {

    private static final Logger logger = LoggerFactory.getLogger(NettyClientCommand.class);

    public NettyClientCommand(MessageEvent event) throws IOException {
        this();
        this.messageEvent = event;
    }

    public NettyClientCommand() throws IOException {
        this.context = new Context(this);
        properties = PropertiesUtil.load("config/client.properties");

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            try {
                connect();
            } catch (Exception e) {
                context.run();
                logger.error(e.getMessage());

                //连接异常，启动定时器定时重连
                reConnect();
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
    public void reConnect() {
        final ScheduledExecutorService scheduled = Executors.newScheduledThreadPool(1);
        scheduled.scheduleAtFixedRate(() -> {
            try {
                connect();
                //连接成功停止定时器
                scheduled.shutdownNow();
            } catch (Exception e1) {
                logger.error(e1.getMessage());
            }
        }, 3, 3, TimeUnit.SECONDS);
    }

    @Override
    public void sendMsg(String msg) {
        context.sendMsg(msg);
    }

    @Override
    public void sendLightAdjustCommand(int percent) {
        context.sendLightAdjust(percent);
    }

    @Override
    public void batchSendLightAdjustCommand(List<String> realtime_ids, int percent) {
        context.batchSendLightAdjust(realtime_ids, percent);
    }

    @Override
    public void resetCommand() {
        context.resetTerminal();
    }

    @Override
    public void configTerminalSendMsgPeriod(int period) {
        context.configTerminalSendMsgPeriod(period);
    }

    @Override
    public void commandTerminalEleboxOn(Boolean eleboxOn) {
        context.commandTerminalEleboxOn(eleboxOn);
    }

    @Override
    public void configTerminalSwitchPolicy(List<SceneView.SwitchTask> switchTasks) {
        context.configTerminalSwitchPolicy(switchTasks);
    }

    @Override
    public void commandReadTerminalInfo() {
        context.commandReadTerminalInfo();
    }

    @Override
    public void configTerminalAutoMode(int mode) {
        context.configTerminalAutoModel(mode);
    }

    @Override
    public void receiveMsg(CommandData in) {
        if (messageEvent != null) {
            messageEvent.receiveMsg(in);
        }
    }

    @Override
    public void serviceFixedInfo(List<String> realtime_ids){
        System.out.println(realtime_ids.size()+"***************************");
        context.serviceFixedInfo(realtime_ids);
    }
    @Override
    public void serviceOpenClose(List<String> realtime_ids){
        context.serviceOpenClose(realtime_ids);
    }

    @Override
    public void close() {
        context.close();
    }

    private void connect() throws Exception {
        new EchoClient(properties.getProperty("host", "127.0.0.1"), Integer.parseInt(properties.getProperty("port", "56556")), context).start();
    }

    private Context context;
    private MessageEvent messageEvent;
    private final Properties properties;
}
