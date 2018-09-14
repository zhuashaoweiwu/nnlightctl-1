package com.nnlightctl.server.impl;

import com.nnlight.common.ReflectCopyUtil;
import com.nnlightctl.command.Command;
import com.nnlightctl.command.CommandFactory;
import com.nnlightctl.command.client.analyze.CommandAnalyzeFactory;
import com.nnlightctl.command.event.MessageEvent;
import com.nnlightctl.net.CommandData;
import com.nnlightctl.po.SwitchTask;
import com.nnlightctl.server.CommandServer;
import com.nnlightctl.vo.SceneView;
import io.netty.buffer.ByteBuf;
import io.netty.util.CharsetUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    @Override
    public void configTerminalSwitchPolicy(List<SwitchTask> switchTasks) {
        List<SceneView.SwitchTask> switchViewList = new ArrayList<>(8);
        for (SwitchTask switchTask : switchTasks) {
            SceneView.SwitchTask switchTaskView = new SceneView.SwitchTask();
            ReflectCopyUtil.beanSameFieldCopy(switchTask, switchTaskView);
            switchViewList.add(switchTaskView);
        }
        command.configTerminalSwitchPolicy(switchViewList);
    }

    @Override
    public void configTerminalAutoModel(int model) {
        command.configTerminalAutoMode(model);
    }
}
