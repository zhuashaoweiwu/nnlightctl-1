package com.nnlight.netty.process;

import com.nnlightctl.net.CommandData;
import io.netty.channel.ChannelHandlerContext;

public interface Process {
    void process(ChannelHandlerContext netServerContext, CommandData msg);
}
