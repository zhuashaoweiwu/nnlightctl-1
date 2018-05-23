package com.nnlightctl.command.event;

import io.netty.buffer.ByteBuf;

public interface MessageEvent {
    void receiveMsg(ByteBuf msg);
}
