package com.nnlightctl.server;

import com.nnlightctl.po.SwitchTask;

import java.util.List;

public interface CommandServer {
    void sendCommand(String msg);
    void sendLightAdjustCommand(int percent);
    void sendLightAdjustCommandBatch(List<Long> lightIds, int percent);
    String webRequireMsg();
    void resetCommand();
    void configTerminalSendMsgPeriod(int period);
    void commandTerminalEleboxOn(Boolean terminalEleboxOn);
    void commandReadTerminalInfo();
    void configTerminalSwitchPolicy(List<SwitchTask> switchTasks);
    void configTerminalAutoModel(int model);
}
