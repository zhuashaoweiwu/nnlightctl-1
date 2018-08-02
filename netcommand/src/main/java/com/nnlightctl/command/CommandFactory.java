package com.nnlightctl.command;

import com.nnlightctl.command.event.MessageEvent;
import com.nnlightctl.command.impl.NettyClientCommand;
import com.nnlightctl.net.CommandData;
import io.netty.buffer.ByteBuf;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class CommandFactory {

    private static final Logger logger = LoggerFactory.getLogger(CommandFactory.class);

    public static Command getNettyClientCommand(MessageEvent event) {
        if (nettyClientCommand == null) {
             synchronized (CommandFactory.class) {
                 try {
                     nettyClientCommand = new NettyClientCommand(event);
                 } catch (IOException e) {
                     logger.error(e.getMessage());
                     nettyClientCommand = null;
                 }
             }
        }

        return nettyClientCommand;
    }

    private static Command nettyClientCommand = null;

    public static void main(String[] args) {
        Command command = CommandFactory.getNettyClientCommand(new MessageEvent() {
            @Override
            public void receiveMsg(CommandData msg) {
                System.out.println(LocalDate.now() + " " + LocalTime.now() + " receive message : " + new String(msg.getData()));
            }
        });


        command.sendMsg("Hello, Netty Server, I'm Client!");
        command.close();
    }
}
