package com.nnlightctl.command.event;

import com.nnlightctl.net.CommandData;

public interface MessageEvent {
    void receiveMsg(CommandData msg);
}
