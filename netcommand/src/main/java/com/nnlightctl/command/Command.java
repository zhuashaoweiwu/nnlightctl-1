package com.nnlightctl.command;

import com.nnlightctl.net.CommandData;
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
    void commandReadTerminalInfo();
    void receiveMsg(CommandData in);
    void configTerminalAutoMode(int mode);
    //模块命令
    void commandReadServiceFixedInfo(List<String> realtime_ids);
    void serviceOpenClose(List<String> realtime_ids);
    void batchConfigRestart(List<String> realtime_ids);
    void batchCommandReadTimeParameter(List<String> realtime_ids);
    void batchCommandReadSending(List<String> realtime_ids);
    void batchConfigSetTime(List<String> realtime_ids);
    void batchConfigOpenCloseStrategy(List<String> realtime_ids);
    void batchConfigWorkModel(List<String> realtime_ids);
    void close();
    void reConnect();
}
