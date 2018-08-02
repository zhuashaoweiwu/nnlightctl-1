package com.nnlightctl.command;

import com.nnlightctl.net.CommandData;
import com.nnlightctl.vo.SceneView;

import java.util.List;

public interface Command {
    void sendMsg(String msg);
    void sendLightAdjustCommand(int percent);
    void resetCommand();
    void configTerminalSendMsgPeriod(int period);
    void commandTerminalEleboxOn(Boolean eleboxOn);
    void configTerminalSwitchPolicy(List<SceneView.SwitchTask> switchTasks);
    void commandReadTerminalInfo();
    void receiveMsg(CommandData in);
    void close();
    void reConnect();
}
