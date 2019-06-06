package com.netty.process.impl;

import com.netty.dto.CommandData;
import com.netty.process.WeatherProcess;
import io.netty.channel.ChannelHandlerContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherProcessImpl implements WeatherProcess {

    @Autowired
    private CommandData commandMessage;
    @Override
    public void weatherProcess(ChannelHandlerContext channelHandlerContext, CommandData commandData) {

        byte addr = commandData.getAddr();
        CommandData command = new CommandData((byte) 0x01);
        channelHandlerContext.writeAndFlush(command);

        /*byte[] mac = commandData.getMac();
        EchoWeatherServer.getGlobalApplicationContext().sendCommand(addr,mac);
*/
    }
}
