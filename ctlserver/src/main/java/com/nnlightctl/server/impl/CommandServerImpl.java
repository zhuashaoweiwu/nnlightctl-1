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
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }
    });

    private String  globalMsg;
    private CountDownLatch countDownLatch;

    @Override
    public String sendCommand(String msg) {
        countDownLatch = new CountDownLatch(1);
        command.sendMsg(msg);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDownLatch = null;
        String ret = new String(globalMsg);
        globalMsg = null;
        return ret;
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

    }
}
