package com.nnlightctl.command.client;

import com.nnlightctl.command.Command;
import com.nnlightctl.mymessage.producer.Produce;
import com.nnlightctl.net.CommandData;
import com.nnlightctl.vo.SceneView;
import io.netty.channel.ChannelHandlerContext;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Context {

    private static Context globalContext;

    public static Context getGlobalContext() {
        if (globalContext == null) {
            throw new RuntimeException("Context 未初始化");
        }

        return globalContext;
    }

    public Context() {
        this.countDownLatch = new CountDownLatch(1);

        globalContext = this;
    }

    public Context(Command command) {
        this();
        this.command = command;
    }

    public void await() throws InterruptedException {
        if (this.countDownLatch != null) {
            this.countDownLatch.await();
        }
    }

    public void run() {
        if (this.countDownLatch != null) {
            this.countDownLatch.countDown();
        }
    }

    public void receiveMsg(CommandData in) {
        if (command != null) {
            command.receiveMsg(in);
            command.produce(in);
        }
    }

    public void sendMsg(String msg) {
        channelHandlerContext.writeAndFlush(new CommandData(msg));
    }

    public void sendLightAdjust(int percent) {
        channelHandlerContext.writeAndFlush(new CommandData(percent, (byte)0xc2));
    }

    public void batchSendLightAdjust(List<String> realtime_ids, int percent) {
        for (String realtime_id : realtime_ids) {
            channelHandlerContext.writeAndFlush(new CommandData(realtime_id, percent, (byte)0xc2));
        }
    }

    public void resetTerminal() {
        channelHandlerContext.writeAndFlush(CommandData.getC4CommandData());
    }

    public void configTerminalSendMsgPeriod(int period) {
        channelHandlerContext.writeAndFlush(CommandData.getC5CommandData(period));
    }

    public void commandTerminalEleboxOn(Boolean eleboxOn) {
        channelHandlerContext.writeAndFlush(CommandData.getC6CommandData(eleboxOn));
    }

    public void configTerminalSwitchPolicy(List<SceneView.SwitchTask> switchTasks) {
        channelHandlerContext.writeAndFlush(CommandData.getC7CommandData(switchTasks));
    }

    public void configTerminalSwitchPolicyBatch(List<SceneView.SwitchTask> switchTasks, String realtimeUUID) {
        channelHandlerContext.writeAndFlush(CommandData.getC7CommandData(switchTasks, realtimeUUID));
    }

    public void commandReadTerminalInfo() {
        channelHandlerContext.writeAndFlush(CommandData.getC8CommandData());
    }

    public void configTerminalAutoModel(int model) {
        channelHandlerContext.writeAndFlush(CommandData.getC9CommandData(model));
    }

    public void configTerminalAutoModel(int model, String realtimeUUID) {
        channelHandlerContext.writeAndFlush(CommandData.getC9CommandData(model, realtimeUUID));
    }

    public void commandReplyTerminal(byte control, Boolean success) {
        channelHandlerContext.writeAndFlush(CommandData.getB80ReplyCommandData(control, success));
    }

    public void commandReplyTerminal(byte control, Boolean success, String realtimeUUID) {
        channelHandlerContext.writeAndFlush(CommandData.getB80ReplyCommandDataRealtimeUUID(control, success, realtimeUUID));
    }

    public ChannelHandlerContext getChannelHandlerContext() {
        return channelHandlerContext;
    }

    public void setChannelHandlerContext(ChannelHandlerContext channelHandlerContext) {
        this.channelHandlerContext = channelHandlerContext;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void commandReadServiceFixedInfo(List<String> realtime_ids){
        for (String realtime_id : realtime_ids) {
            channelHandlerContext.writeAndFlush(new CommandData(realtime_id, (byte)0xa0) );
        }
    }
    public void serviceOpenClose(List<String> realtime_ids){
        for (String realtime_id : realtime_ids) {
            channelHandlerContext.writeAndFlush(new CommandData(realtime_id, (byte)0xa1) );
        }
    }
    public void batchConfigRestart(List<String> realtime_ids){
        for (String realtime_id : realtime_ids) {
            channelHandlerContext.writeAndFlush(new CommandData(realtime_id, (byte)0xa2) );
        }
    }

    public void batchCommandReadTimeParameter(List<String> realtime_ids){
        for (String realtime_id : realtime_ids) {
            channelHandlerContext.writeAndFlush(new CommandData(realtime_id, (byte)0xa3) );
        }
    }
    public void batchCommandReadSending(List<String> realtime_ids){
        for (String realtime_id : realtime_ids) {
            channelHandlerContext.writeAndFlush(new CommandData(realtime_id, (byte)0xa4) );
        }
    }
    public void batchConfigSetTime(List<String> realtime_ids){
        for (String realtime_id : realtime_ids) {
            channelHandlerContext.writeAndFlush(new CommandData(realtime_id, (byte)0xa5) );
        }
    }
    public void batchConfigOpenCloseStrategy(List<String> realtime_ids){
        for (String realtime_id : realtime_ids) {
            channelHandlerContext.writeAndFlush(new CommandData(realtime_id, (byte)0xa6) );
        }
    }
    public void batchConfigWorkModel(List<String> realtime_ids){
        for (String realtime_id : realtime_ids) {
            channelHandlerContext.writeAndFlush(new CommandData(realtime_id, (byte)0xa7) );
        }
    }

    public void close() {
        if (channelHandlerContext != null) {
            channelHandlerContext.close();
        }
    }

    public void reConnect() {
        if (command != null) {
            command.reConnect();
        }
    }

    private Command command;
    private ChannelHandlerContext channelHandlerContext;
    private CountDownLatch countDownLatch;
}
