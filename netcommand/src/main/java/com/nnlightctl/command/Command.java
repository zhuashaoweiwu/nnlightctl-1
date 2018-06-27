package com.nnlightctl.command;

import com.nnlightctl.net.CommandData;

public interface Command {
    void sendMsg(String msg);
    void sendLightAdjustCommand(int percent);
    void resetCommand();
    void configTerminalSendMsgPeriod(int period);
    void commandTerminalEleboxOn(Boolean eleboxOn);
    void commandReadTerminalInfo();
    void receiveMsg(CommandData in);
    void close();
}
