package com.netty.process;

import com.netty.dto.CommandData;
import io.netty.channel.ChannelHandlerContext;

public interface WeatherProcess {
    void weatherProcess(ChannelHandlerContext channelHandlerContext, CommandData commandData);



}
