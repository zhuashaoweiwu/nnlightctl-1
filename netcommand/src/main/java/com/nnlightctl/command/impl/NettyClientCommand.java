package com.nnlightctl.command.impl;

import com.nnlight.common.PropertiesUtil;
import com.nnlightctl.command.Command;
import com.nnlightctl.command.client.Context;
import com.nnlightctl.command.client.EchoClient;
import com.nnlightctl.command.event.MessageEvent;
import com.nnlightctl.mymessage.producer.Produce;
import com.nnlightctl.net.CommandData;
import com.nnlightctl.net.D0Response;
import com.nnlightctl.vo.SceneView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.*;

public class NettyClientCommand implements Command {

    private static final Logger logger = LoggerFactory.getLogger(NettyClientCommand.class);

    public NettyClientCommand(MessageEvent event, Produce produce) throws IOException {
        this();
        this.messageEvent = event;
        this.produce = produce;
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
    public void configTerminalSwitchPolicy(List<SceneView.SwitchTask> switchTasks, String terminalRealtimeUUID) {
        context.configTerminalSwitchPolicyBatch(switchTasks, terminalRealtimeUUID);
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
    public void batchConfigTerminalAutoMode(int model, String realtimeUUID) {
        context.configTerminalAutoModel(model, realtimeUUID);
    }

    @Override
    public void batchConfigTerminalPowerType(int powerType, List<String> realtimeUUIDs) {
        context.batchConfigTerminalPowerType(powerType, realtimeUUIDs);
    }

    @Override
    public void batchUpdateFireware(List<String> realtimeUUIDs, String version, int packageNumber, int lastPackageSize) {
        context.batchUpdateFireware(realtimeUUIDs, version, packageNumber, lastPackageSize);
    }

    @Override
    public void receiveMsg(CommandData in) {
        if (messageEvent != null) {
            messageEvent.receiveMsg(in);
        }
    }

    @Override
    public void produce(CommandData in) {
        if (produce != null) {
            //只处理E0、E1指令
            if (in.getControl() == (byte)0xe0 || in.getControl() == (byte)0xe1) {
                produce.produce(in);
                //返回80回复
                context.commandReplyTerminal(in.getControl(), true, in.getRealtimeUUID());
            }
        }
    }

    @Override
    public D0Response getModelState(String gatewayRealtimeUUID, String modelUUID) {
        Future<D0Response> future = Executors.newSingleThreadExecutor().submit(() -> {
            return context.getModelState(gatewayRealtimeUUID, modelUUID);
        });

        try {
            return future.get();
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        } catch (ExecutionException e) {
            logger.error(e.getMessage());
        }

        return null;
    }

    @Override
    public void configModelState(String gatewayRealtimeUUID, String modelUUID, short modelLoop, short modelLoopState) {
        context.configModelState(gatewayRealtimeUUID, modelUUID, modelLoop, modelLoopState);
    }

    @Override
    public void commandReadServiceFixedInfo(List<String> realtime_ids){
        context.commandReadServiceFixedInfo(realtime_ids);
    }
    @Override
    public void serviceOpenClose(List<String> realtime_ids){
        context.serviceOpenClose(realtime_ids);
    }
    @Override
    public void batchConfigRestart(List<String> realtime_ids){
        context.batchConfigRestart(realtime_ids);
    }
    @Override
    public void batchCommandReadTimeParameter(List<String> realtime_ids){
        context.batchCommandReadTimeParameter(realtime_ids);
    }
    @Override
    public void batchCommandReadSending(List<String> realtime_ids){
        context.batchCommandReadSending(realtime_ids);
    }
    @Override
    public void batchConfigSetTime(){
        context.batchConfigSetTime();
    }
    @Override
    public void batchConfigOpenCloseStrategy(List<String> realtime_ids){
        context.batchConfigOpenCloseStrategy(realtime_ids);
    }
    @Override
    public void batchConfigWorkModel(List<String> realtime_ids){
        context.batchConfigWorkModel(realtime_ids);
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
    private Produce produce;
    private final Properties properties;
}
