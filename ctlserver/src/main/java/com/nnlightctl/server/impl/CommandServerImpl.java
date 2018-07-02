package com.nnlightctl.server.impl;

import com.nnlightctl.command.Command;
import com.nnlightctl.command.CommandFactory;
import com.nnlightctl.command.client.analyze.CommandAnalyzeFactory;
import com.nnlightctl.command.event.MessageEvent;
import com.nnlightctl.net.CommandData;
import com.nnlightctl.server.CommandServer;
import io.netty.buffer.ByteBuf;
import io.netty.util.CharsetUtil;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

@Service
public class CommandServerImpl implements CommandServer {
    private final Command command = CommandFactory.getNettyClientCommand(new MessageEvent() {
        @Override
        public void receiveMsg(CommandData msg) {
            globalMsg = CommandAnalyzeFactory.getCommandAnalyzer(msg.getControl()).analyze(msg);
        }
    });

    private String globalMsg;

    @Override
    public void sendCommand(String msg) {
        command.sendMsg(msg);
    }

    @Override
    public void sendLightAdjustCommand(int percent) {
        command.sendLightAdjustCommand(percent);
    }

    @Override
    public String webRequireMsg() {
        String retString = "";
        if (this.globalMsg != null) {
            retString = new String(this.globalMsg);
            this.globalMsg = null;
        }

        return retString;
    }

    @Override
    public void resetCommand() {
        command.resetCommand();
    }

    @Override
    public void configTerminalSendMsgPeriod(int period) {
        command.configTerminalSendMsgPeriod(period);
    }

    @Override
    public void commandTerminalEleboxOn(Boolean terminalEleboxOn) {
        command.commandTerminalEleboxOn(terminalEleboxOn);
    }

    @Override
    public void commandReadTerminalInfo() {
        command.commandReadTerminalInfo();
    }
}
