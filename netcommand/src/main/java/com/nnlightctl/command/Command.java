package com.nnlightctl.command;

import com.nnlightctl.net.CommandData;
import com.nnlightctl.net.D0Response;
import com.nnlightctl.vo.SceneView;

import java.util.List;

public interface Command {
    void sendMsg(String msg);
    void sendLightAdjustCommand(int percent);
    void batchSendLightAdjustCommand(List<String> realtime_ids, int percent);
    void resetCommand();
    void configTerminalSendMsgPeriod(int period);
    void commandTerminalEleboxOn(Boolean eleboxOn);
    void configTerminalSwitchPolicy(List<SceneView.SwitchTask> switchTasks);
    void configTerminalSwitchPolicy(List<SceneView.SwitchTask> switchTasks, String terminalRealtimeUUID);
    void commandReadTerminalInfo();
    void receiveMsg(CommandData in);
    void produce(CommandData in);
    void configTerminalAutoMode(int mode);
    void batchConfigTerminalAutoMode(int model, String realtimeUUID);
    void batchConfigTerminalPowerType(int powerType, List<String> realtimeUUIDs);
    //模块命令
    D0Response getModelState(String gatewayRealtimeUUID, String modelUUID);
    void configModelState(String gatewayRealtimeUUID, String modelUUID, short modelLoop, short modelLoopState);
    void commandReadServiceFixedInfo(List<String> realtime_ids);
    void serviceOpenClose(List<String> realtime_ids);
    void batchConfigRestart(List<String> realtime_ids);
    void batchCommandReadTimeParameter(List<String> realtime_ids);
    void batchCommandReadSending(List<String> realtime_ids);
    void batchConfigSetTime();
    void batchConfigOpenCloseStrategy(List<String> realtime_ids);
    void batchConfigWorkModel(List<String> realtime_ids);

    void close();
    void reConnect();
}
