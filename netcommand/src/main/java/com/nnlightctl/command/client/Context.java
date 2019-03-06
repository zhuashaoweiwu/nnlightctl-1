package com.nnlightctl.command.client;

import com.nnlightctl.command.Command;
import com.nnlightctl.kafka.util.DataTransferUtil;
import com.nnlightctl.mymessage.producer.Produce;
import com.nnlightctl.net.CommandData;
import com.nnlightctl.net.D0Response;
import com.nnlightctl.net.ModBusResponse;
import com.nnlightctl.vo.SceneView;
import io.netty.channel.ChannelHandlerContext;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

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

    public Context(Command command, int countDown) {
        this.countDownLatch = new CountDownLatch(countDown);
        globalContext = this;
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

        if (in.getControl() == (byte)0xd0) {
            FutureResult futureResult = uuidMapFutureResult.get(in.getUUID());
            if (futureResult != null) {
                futureResult.setCommandData(in);
                futureResult.run();
            }
        }

        //modbus回复指令
        if (in.getControl() == (byte)0x12) {
            FutureResult futureResult = uuidMapFutureResult.get(MODBUS_UUID);
            if (futureResult != null) {
                futureResult.setCommandData(in);
                futureResult.run();
            }
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

    public void batchConfigTerminalPowerType(int powerType, List<String> realtimeUUIDs) {
        for (String realtimeUUID : realtimeUUIDs) {
            channelHandlerContext.writeAndFlush(CommandData.getF2CommandData(powerType, realtimeUUID));
        }
    }

    public void batchUpdateFireware(List<String> realtimeUUIDs, String version, int packageNumber, int lastPackageSize) {
        for (String realtimeUUID : realtimeUUIDs) {
            channelHandlerContext.writeAndFlush(CommandData.getC3CommandData(realtimeUUID, version, packageNumber, lastPackageSize));
        }
    }

    public void commandReplyTerminal(byte control, Boolean success) {
        channelHandlerContext.writeAndFlush(CommandData.getB80ReplyCommandData(control, success));
    }

    public void commandReplyTerminal(byte control, Boolean success, String realtimeUUID) {
        channelHandlerContext.writeAndFlush(CommandData.getB80ReplyCommandDataRealtimeUUID(control, success, realtimeUUID));
    }

    public D0Response getModelState(String gatewayRealtimeUUID, String modelUUID) {
        channelHandlerContext.writeAndFlush(CommandData.getA0CommandData(gatewayRealtimeUUID, modelUUID));
        FutureResult futureResult = new FutureResult();
        uuidMapFutureResult.put(modelUUID, futureResult);
        futureResult.await(12000);

        CommandData commandData = futureResult.getCommandData();
        D0Response d0Response = DataTransferUtil.transToD0Response(commandData);
        uuidMapFutureResult.remove(modelUUID);

        return d0Response;
    }

    public void configModelState(String gatewayRealtimeUUID, String modelUUID, short modelLoop, short modelLoopState) {
        channelHandlerContext.writeAndFlush(CommandData.getA1CommandData(gatewayRealtimeUUID, modelUUID, modelLoop, modelLoopState));
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
    public void batchConfigSetTime(){
        channelHandlerContext.writeAndFlush(CommandData.getA5CommandData());
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

    public ModBusResponse invokeModbusEM(String realtimeUUID, byte[] modbusDirectiveBytes) {
        channelHandlerContext.writeAndFlush(CommandData.getC11CommandData(realtimeUUID, modbusDirectiveBytes));
        FutureResult futureResult = new FutureResult();
        uuidMapFutureResult.put(MODBUS_UUID, futureResult);
        futureResult.await(12000);

        CommandData commandData = futureResult.getCommandData();
        return DataTransferUtil.transToModbusResponse(commandData);
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
    private Map<String, FutureResult> uuidMapFutureResult = new ConcurrentHashMap<>(8);
    private static final String MODBUS_UUID = "modbusuuid";

    private static class FutureResult {
        private CountDownLatch futureResultCountDown;
        private CommandData commandData;

        public FutureResult() {
            futureResultCountDown = new CountDownLatch(1);
        }

        public void await() {
            try {
                futureResultCountDown.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void await(int millisecond) {
            try {
                futureResultCountDown.await(millisecond, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void run() {
            futureResultCountDown.countDown();
        }

        public void setCommandData(CommandData commandData) {
            this.commandData = commandData;
        }

        public CommandData getCommandData() {
            return commandData;
        }
    }
}
