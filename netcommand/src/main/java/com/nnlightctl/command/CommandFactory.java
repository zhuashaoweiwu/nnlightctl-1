package com.nnlightctl.command;

import com.nnlightctl.command.event.MessageEvent;
import com.nnlightctl.command.impl.NettyClientCommand;
import com.nnlightctl.net.CommandData;
import io.netty.buffer.ByteBuf;
import io.netty.util.CharsetUtil;

import java.time.LocalDate;
import java.time.LocalTime;

public class CommandFactory {
    public static Command getNettyClientCommand(MessageEvent event) {
        if (nettyClientCommand == null) {
             synchronized (CommandFactory.class) {
                 nettyClientCommand = new NettyClientCommand(event);
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
