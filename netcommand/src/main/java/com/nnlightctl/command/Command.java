package com.nnlightctl.command;

import io.netty.buffer.ByteBuf;

public interface Command {
    void sendMsg(String msg);
    void receiveMsg(ByteBuf in);
    void close();
}
