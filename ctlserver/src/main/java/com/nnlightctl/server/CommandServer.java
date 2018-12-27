package com.nnlightctl.server;

import com.nnlightctl.net.D0Response;
import com.nnlightctl.net.ModBusResponse;
import com.nnlightctl.po.FirewareUploadRecord;
import com.nnlightctl.po.SwitchTask;
import com.nnlightctl.request.CommandRequest;
import com.nnlightctl.request.UpdateFirewareCommandRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface CommandServer {
    void sendCommand(String msg);
    void sendLightAdjustCommand(int percent);
    void sendLightAdjustCommandBatch(List<Long> lightIds, int percent);
    void sendLightAdjustCommandBatchUUID(List<String> lightUUIDs, int percent);
    String webRequireMsg();
    void resetCommand();
    void configTerminalSendMsgPeriod(int period);
    void commandTerminalEleboxOn(Boolean terminalEleboxOn);
    void commandReadTerminalInfo();
    void configTerminalSwitchPolicy(List<SwitchTask> switchTasks);
    void configTerminalSwitchPolicyBatch(List<SwitchTask> switchTasks, List<String> terminalUUIDs);
    void configTerminalAutoModel(int model);
    void batchConfigTerminalAutoModel(int model, List<String> uuidList);
    void commandReadServiceFixedInfo(List<Long> lightIds);
    D0Response getModelState(String modelUUID);
    D0Response getModelState(Long modelId);
    void configModelState(String modelUUID, short modelLoop, short modelLoopState);
    void configModelState(Long loopId, short modelLoop, short modelLoopState);
    void configServiceOpenClose(List<Long> lightIds);
    void batchConfigRestart(List<Long> lightIds);
    void batchCommandReadTimeParameter(List<Long> lightIds);
    void batchCommandReadSending(List<Long> lightIds);
    void batchConfigSetTime();
    void batchConfigOpenCloseStrategy(List<Long> lightIds);
    void batchConfigWorkModel(List<Long> lightIds);
    void batchConfigTerminalPowerType(List<String> terminalUUIDs, int powerType);
    void batchExecScene(List<Long> sceneIds);
    int updateFireware(UpdateFirewareCommandRequest request, HttpServletRequest servletRequest);
    List<FirewareUploadRecord> listFirewareUploadRecord();
    void batchInvokeFirewareUpdateUUID(CommandRequest request);
    void batchInvokeFirewareUpdateId(CommandRequest request);
    ModBusResponse invokeModbusDirective(String realtimeUUID, byte[] directiveBytes);
}
