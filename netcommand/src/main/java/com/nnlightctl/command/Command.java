package com.nnlightctl.command;

import com.nnlightctl.net.CommandData;

public interface Command {
    void sendMsg(String msg);
    void sendLightAdjustCommand(int percent);
    void receiveMsg(CommandData in);
    void close();
}
