package com.nnlightctl.server.impl;

import com.nnlight.common.ReflectCopyUtil;
import com.nnlightctl.command.Command;
import com.nnlightctl.command.CommandFactory;
import com.nnlightctl.command.client.analyze.CommandAnalyzeFactory;
import com.nnlightctl.command.event.MessageEvent;
import com.nnlightctl.dao.EleboxModelLoopMapper;
import com.nnlightctl.mymessage.producer.Produce;
import com.nnlightctl.net.CommandData;
import com.nnlightctl.net.D0Response;
import com.nnlightctl.po.Lighting;
import com.nnlightctl.po.SwitchTask;
import com.nnlightctl.server.CommandServer;
import com.nnlightctl.server.EleboxModelServer;
import com.nnlightctl.server.LightServer;
import com.nnlightctl.server.SceneServer;
import com.nnlightctl.vo.SceneView;
import io.netty.buffer.ByteBuf;
import io.netty.util.CharsetUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

@Service
public class CommandServerImpl implements CommandServer {

    @Autowired
    private LightServer lightServer;

    @Autowired
    private EleboxModelServer eleboxModelServer;

    @Autowired
    private EleboxModelLoopMapper eleboxModelLoopMapper;

    @Autowired
    private SceneServer sceneServer;

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
    public void sendLightAdjustCommandBatchUUID(List<String> lightUUIDs, int percent) {
        if (lightUUIDs == null || lightUUIDs.size() < 1) {
            throw new RuntimeException("批量操作的灯具UUID数量为0");
        }

        List<String> realtime_ids = new ArrayList<>(1);
        for (String uuid : lightUUIDs) {
            Lighting lighting = lightServer.getLightingByUUID(uuid);
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
    public void configTerminalSwitchPolicyBatch(List<SwitchTask> switchTasks, List<String> terminalUUIDs) {
        List<SceneView.SwitchTask> switchViewList = new ArrayList<>(8);
        for (SwitchTask switchTask : switchTasks) {
            SceneView.SwitchTask switchTaskView = new SceneView.SwitchTask();
            ReflectCopyUtil.beanSameFieldCopy(switchTask, switchTaskView);
            switchViewList.add(switchTaskView);
        }

        for (String terminalUUID : terminalUUIDs) {
            command.configTerminalSwitchPolicy(switchViewList, lightServer.getLightingByUUID(terminalUUID).getRealtimeUid());
        }
    }

    @Override
    public void configTerminalAutoModel(int model) {
        command.configTerminalAutoMode(model);
    }

    @Override
    public void batchConfigTerminalAutoModel(int model, List<String> uuidList) {
        for (String uuid : uuidList) {
            command.batchConfigTerminalAutoMode(model, lightServer.getLightingByUUID(uuid).getRealtimeUid());
        }
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
    public D0Response getModelState(String modelUUID) {
        if (StringUtils.isEmpty(modelUUID)) {
            throw new RuntimeException("请求模块信息的模块UUID不可为空");
        }

        String gatewayRealtimeUUID = eleboxModelServer.getEleboxRealtimeUUIDByModelUUID(modelUUID);

        return command.getModelState(gatewayRealtimeUUID, modelUUID);
    }

    @Override
    public D0Response getModelState(Long modelId) {
        String gatewayRealtimeUUID = eleboxModelServer.getEleboxRealtimeUUIDByModelId(modelId);
        return command.getModelState(gatewayRealtimeUUID, eleboxModelServer.getEleboxModelById(modelId).getUid());
    }

    @Override
    public void configModelState(String modelUUID, short modelLoop, short modelLoopState) {
        String gatewayRealtimeUUID = eleboxModelServer.getEleboxRealtimeUUIDByModelUUID(modelUUID);

        command.configModelState(gatewayRealtimeUUID, modelUUID, modelLoop, modelLoopState);
    }

    @Override
    public void configModelState(Long loopId, short modelLoop, short modelLoopState) {
        String gatewayRealtimeUUID = eleboxModelServer.getEleboxRealtimeUUIDByLoopId(loopId);

        Long modelId = eleboxModelLoopMapper.selectByPrimaryKey(loopId).getNnlightctlEleboxModelId();

        command.configModelState(gatewayRealtimeUUID, eleboxModelServer.getEleboxModelById(modelId).getUid(), modelLoop, modelLoopState);
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
    public void batchConfigSetTime(){
        command.batchConfigSetTime();
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

    @Override
    public void batchConfigTerminalPowerType(List<String> terminalUUIDs, int powerType) {
        if (terminalUUIDs == null || terminalUUIDs.size() < 1) {
            throw new RuntimeException("批量设置终端的电源类型的终端数量为0");
        }

        List<String> realtime_ids = new ArrayList<>(8);
        for (String uuid : terminalUUIDs) {
            realtime_ids.add(lightServer.getLightingByUUID(uuid).getRealtimeUid());
        }

        command.batchConfigTerminalPowerType(powerType, realtime_ids);
    }

    @Override
    public void batchExecScene(List<Long> sceneIds) {
        if (sceneIds == null || sceneIds.size() < 1) {
            throw new RuntimeException("下发场景不可为空！");
        }
        //分别处理每个场景的下发
        for (Long scendId : sceneIds) {
            //获取场景下全部灯具列表
            List<Lighting> lightingList = sceneServer.listLightingsOfScene(scendId);
            //获取场景下全部任务策略列表
            List<SwitchTask> switchTaskList = sceneServer.listSwitchTaskOfScene(scendId);

            //获取灯具uuid
            List<String> lightingUUIDList = new ArrayList<>(8);
            for (Lighting lighting : lightingList) {
                lightingUUIDList.add(lighting.getUid());
            }

            //下发策略
            configTerminalSwitchPolicyBatch(switchTaskList, lightingUUIDList);
        }
    }
}
