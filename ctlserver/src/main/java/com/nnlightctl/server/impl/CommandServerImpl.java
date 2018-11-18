package com.nnlightctl.server.impl;

import com.nnlight.common.ReflectCopyUtil;
import com.nnlightctl.command.Command;
import com.nnlightctl.command.CommandFactory;
import com.nnlightctl.command.client.analyze.CommandAnalyzeFactory;
import com.nnlightctl.command.event.MessageEvent;
import com.nnlightctl.mymessage.producer.Produce;
import com.nnlightctl.net.CommandData;
import com.nnlightctl.po.Lighting;
import com.nnlightctl.po.SwitchTask;
import com.nnlightctl.server.CommandServer;
import com.nnlightctl.server.LightServer;
import com.nnlightctl.vo.SceneView;
import io.netty.buffer.ByteBuf;
import io.netty.util.CharsetUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

@Service
public class CommandServerImpl implements CommandServer {

    @Autowired
    private LightServer lightServer;

    private final Command command;

    private String globalMsg;

    @Autowired
    public CommandServerImpl(Produce produce) {
        command = CommandFactory.getNettyClientCommand(new MessageEvent() {
            @Override

            public void receiveMsg(CommandData msg) {
                globalMsg = CommandAnalyzeFactory.getCommandAnalyzer(msg.getControl()).analyze(msg);
            }
        }, produce);
    }

    @Override
    public void sendCommand(String msg) {
        command.sendMsg(msg);
    }

    @Override
    public void sendLightAdjustCommand(int percent) {
        command.sendLightAdjustCommand(percent);
    }

    @Override
    public void sendLightAdjustCommandBatch(List<Long> lightIds, int percent) {
        if (lightIds == null || lightIds.size() < 1) {
            throw new RuntimeException("批量操作的灯具数量为0");
        }

        List<String> realtime_ids = new ArrayList<>(1);
        for (Long lightId : lightIds) {
            Lighting lighting = lightServer.getLighting(lightId);
            realtime_ids.add(lighting.getRealtimeUid());
        }

        command.batchSendLightAdjustCommand(realtime_ids, percent);
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

    @Override
    public void commandReadServiceFixedInfo(List<Long> lightIds){
        if (lightIds == null || lightIds.size() < 1) {
            throw new RuntimeException("批量操作的灯具数量为0");
        }

        List<String> realtime_ids = new ArrayList<>(1);
        for (Long lightId : lightIds) {
            Lighting lighting = lightServer.getLighting(lightId);
            realtime_ids.add(lighting.getRealtimeUid());
        }
        command.commandReadServiceFixedInfo(realtime_ids);
    }
    @Override
    public void configServiceOpenClose(List<Long> lightIds){
        if (lightIds == null || lightIds.size() < 1) {
            throw new RuntimeException("批量操作的灯具数量为0");
        }

        List<String> realtime_ids = new ArrayList<>(1);
        for (Long lightId : lightIds) {
            Lighting lighting = lightServer.getLighting(lightId);
            realtime_ids.add(lighting.getRealtimeUid());
        }
        command.serviceOpenClose(realtime_ids);
    }
    @Override
    public void batchConfigRestart(List<Long> lightIds){
        if (lightIds == null || lightIds.size() < 1) {
            throw new RuntimeException("批量操作的灯具数量为0");
        }

        List<String> realtime_ids = new ArrayList<>(1);
        for (Long lightId : lightIds) {
            Lighting lighting = lightServer.getLighting(lightId);
            realtime_ids.add(lighting.getRealtimeUid());
        }
        command.batchConfigRestart(realtime_ids);
    }
    @Override
    public void batchCommandReadTimeParameter(List<Long> lightIds){
        if (lightIds == null || lightIds.size() < 1) {
            throw new RuntimeException("批量操作的灯具数量为0");
        }

        List<String> realtime_ids = new ArrayList<>(1);
        for (Long lightId : lightIds) {
            Lighting lighting = lightServer.getLighting(lightId);
            realtime_ids.add(lighting.getRealtimeUid());
        }
        command.batchCommandReadTimeParameter(realtime_ids);
    }
    @Override
    public void batchCommandReadSending(List<Long> lightIds){
        if (lightIds == null || lightIds.size() < 1) {
            throw new RuntimeException("批量操作的灯具数量为0");
        }

        List<String> realtime_ids = new ArrayList<>(1);
        for (Long lightId : lightIds) {
            Lighting lighting = lightServer.getLighting(lightId);
            realtime_ids.add(lighting.getRealtimeUid());
        }
        command.batchCommandReadSending(realtime_ids);
    }
    @Override
    public void batchConfigSetTime(List<Long> lightIds){
        if (lightIds == null || lightIds.size() < 1) {
            throw new RuntimeException("批量操作的灯具数量为0");
        }

        List<String> realtime_ids = new ArrayList<>(1);
        for (Long lightId : lightIds) {
            Lighting lighting = lightServer.getLighting(lightId);
            realtime_ids.add(lighting.getRealtimeUid());
        }
        command.batchConfigSetTime(realtime_ids);
    }
    @Override
    public void batchConfigOpenCloseStrategy(List<Long> lightIds){
        if (lightIds == null || lightIds.size() < 1) {
            throw new RuntimeException("批量操作的灯具数量为0");
        }

        List<String> realtime_ids = new ArrayList<>(1);
        for (Long lightId : lightIds) {
            Lighting lighting = lightServer.getLighting(lightId);
            realtime_ids.add(lighting.getRealtimeUid());
        }
        command.batchConfigOpenCloseStrategy(realtime_ids);
    }
    @Override
    public void batchConfigWorkModel(List<Long> lightIds){
        if (lightIds == null || lightIds.size() < 1) {
            throw new RuntimeException("批量操作的灯具数量为0");
        }

        List<String> realtime_ids = new ArrayList<>(1);
        for (Long lightId : lightIds) {
            Lighting lighting = lightServer.getLighting(lightId);
            realtime_ids.add(lighting.getRealtimeUid());
        }
        command.batchConfigWorkModel(realtime_ids);
    }
}
