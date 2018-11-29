package com.nnlightctl.springmvc.controller;

import com.nnlightctl.net.D0Response;
import com.nnlightctl.po.SwitchTask;
import com.nnlightctl.request.CommandRequest;
import com.nnlightctl.result.JsonResult;
import com.nnlightctl.server.CommandServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/command")
public class CommandController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(CommandController.class);

    @Autowired
    private CommandServer commandServer;

    @RequestMapping("sendcommand")
    public void sendCommand(CommandRequest request) {
        logger.info("[POST] /api/command/sendcommand");

        commandServer.sendCommand(request.getMsg());
    }

    @RequestMapping("sendLightAdjustCommand")
    public String sendLightAdjustCommand(CommandRequest request) {
        logger.info("[POST] /api/command/sendLightAdjustCommand");

        commandServer.sendLightAdjustCommand(request.getLightPercent());

        return toJson(JsonResult.getSUCCESS());
    }

    @RequestMapping("webClientReceiveMsg")
    public String webClientReceiveMsg() {
        logger.info("[POST] /api/command/webClientReceiveMsg");

        String msg = commandServer.webRequireMsg();

        List<String> data = new ArrayList<>(1);
        data.add(msg);

        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setData(data);

        return toJson(jsonResult);
    }

    @RequestMapping("resetCommand")
    public String resetCommand() {
        logger.info("[POST] /api/command/resetCommand");

        commandServer.resetCommand();

        return toJson(JsonResult.getSUCCESS());
    }

    @RequestMapping("configTerminalSendMsgPeriod")
    public String configTerminalSendMsgPeriod(CommandRequest request) {
        logger.info("[POST] /api/command/configTerminalSendMsgPeriod");

        commandServer.configTerminalSendMsgPeriod(request.getTerminalSendMsgPeriod());

        return toJson(JsonResult.getSUCCESS());
    }

    @RequestMapping("commandTerminalEleboxOn")
    public String commandTerminalEleboxOn(CommandRequest request) {
        logger.info("[POST] /api/command/commandTerminalEleboxOn");

        commandServer.commandTerminalEleboxOn(request.getTerminalEleboxOn());

        return toJson(JsonResult.getSUCCESS());
    }

    @RequestMapping("testConfigTerminalSwitchPolicy")
    public void testConfigTerminalSwitchPolicy(HttpServletRequest request) {
        logger.info("[POST] /api/command/testConfigTerminalSwitchPolicy");

        String switch1Type = request.getParameter("switch1Type");
        String switch1StartDate = request.getParameter("switch1StartDate");
        String switch1EndDate = request.getParameter("switch1EndDate");
        String switch1Percent = request.getParameter("switch1Percent");

        String switch2Type = request.getParameter("switch2Type");
        String switch2StartDate = request.getParameter("switch2StartDate");
        String switch2EndDate = request.getParameter("switch2EndDate");
        String switch2Percent = request.getParameter("switch2Percent");

        List<SwitchTask> switchTaskList = new ArrayList<>(8);

        SwitchTask switchTask1 = new SwitchTask();
        SwitchTask switchTask2 = new SwitchTask();

        switchTask1.setPeriod(Byte.parseByte(switch1Type));
        switchTask2.setPeriod(Byte.parseByte(switch2Type));

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            switchTask1.setStartTime(dateFormat.parse(switch1StartDate));
            switchTask1.setEndTime(dateFormat.parse(switch1EndDate));

            switchTask2.setStartTime(dateFormat.parse(switch2StartDate));
            switchTask2.setEndTime(dateFormat.parse(switch2EndDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        switchTask1.setLightPercent(Byte.parseByte(switch1Percent));
        switchTask2.setLightPercent(Byte.parseByte(switch2Percent));

        switchTaskList.add(switchTask1);
        switchTaskList.add(switchTask2);

        String uuid = request.getParameter("uuid");

        List<String> uuidList = new ArrayList<>(1);
        uuidList.add(uuid);

        commandServer.configTerminalSwitchPolicyBatch(switchTaskList, uuidList);
    }

    @RequestMapping("commandReadTerminalInfo")
    public void commandReadTerminalInfo() {
        logger.info("[POST] /api/command/commandReadTerminalInfo");

        commandServer.commandReadTerminalInfo();
    }

    @RequestMapping("commandConfigTerminalAutModel")
    public void commandConfigTerminalAutoModel(CommandRequest request) {
        logger.info("[POST] /api/command/commandConfigTerminalAutModel");

        commandServer.configTerminalAutoModel(request.getAutoModel());
    }

    @RequestMapping("batchCommandConfigTerminalAutoModel")
    public void batchCommandConfigTerminalAutoModel(CommandRequest request) {
        logger.info("[POST] /api/command/batchCommandConfigTerminalAutoModel");

        commandServer.batchConfigTerminalAutoModel(request.getAutoModel(), request.getLightUUIDs());
    }

    @RequestMapping("sendLightAdjustCommandBatch")
    public String batchLightAdjustCommand(CommandRequest request) {
        logger.info("[POST] /api/command/sendLightAdjustCommandBatch");

        commandServer.sendLightAdjustCommandBatch(request.getLightIds(), request.getLightPercent());

        return toJson(JsonResult.getSUCCESS());
    }

    @RequestMapping("batchUUIDLightAdjustCommand")
    public String batchUUIDLightAdjustCommand(CommandRequest request) {
        logger.info("[POST] /api/command/batchUUIDLightAdjustCommand");

        commandServer.sendLightAdjustCommandBatchUUID(request.getLightUUIDs(), request.getLightPercent());

        return toJson(JsonResult.getSUCCESS());
    }

    @RequestMapping("resetCommandBatch")
    public String batchResetCommand(CommandRequest request) {
        logger.info("[POST] /api/command/resetCommandBatch");

        return toJson(JsonResult.getSUCCESS());
    }

    @RequestMapping("configTerminalSendMsgPeriodBatch")
    public String batchConfigTerminalSendMsgPeriod(CommandRequest request) {
        logger.info("[POST] /api/command/configTerminalSendMsgPeriodBatch");

        return toJson(JsonResult.getSUCCESS());
    }

    @RequestMapping("commandTerminalEleboxOnBatch")
    public String batchCommandTerminalEleboxOn(CommandRequest request) {
        logger.info("[POST] /api/command/commandTerminalEleboxOnBatch");

        return toJson(JsonResult.getSUCCESS());
    }

    @RequestMapping("commandReadTerminalInfoBatch")
    public void batchCommandReadTerminalInfo(CommandRequest request) {
        logger.info("[POST] /api/command/commandReadTerminalInfoBatch");

    }

    @RequestMapping("batchCommandConfigTerminalPowerType")
    public void batchCommandConfigTerminalPowerType(CommandRequest request) {
        logger.info("[POST] /api/command/batchCommandConfigTerminalPowerType");

        commandServer.batchConfigTerminalPowerType(request.getLightUUIDs(), request.getPowerType());
    }

    /*
    *服务器获取固定信息0xD0
    * */
    @RequestMapping("batchCommandReadServiceFixedInfo")
    public String  batchCommandReadServiceFixedInfo(CommandRequest request) {
        logger.info("[POST] /api/command/batchCommandReadServiceFixedInfo");
        commandServer.commandReadServiceFixedInfo(request.getLightIds());
        return toJson(JsonResult.getSUCCESS());
    }

    /**
     * D0 uuid
     * @param request
     * @return
     */
    @RequestMapping("batchCommandGetModelInfoUUID")
    public String batchCommandGetModelInfoUUID(CommandRequest request) {
        logger.info("[POST] /api/command/batchCommandGetModelInfoUUID");

        D0Response d0Response = commandServer.getModelState(request.getModelUUIDs().get(0));

        JsonResult jsonResult = JsonResult.getSUCCESS();
        List<D0Response> d0ResponseList = new ArrayList<>(1);
        d0ResponseList.add(d0Response);
        jsonResult.setData(d0ResponseList);

        return toJson(jsonResult);
    }

    /**
     * D0 id
     * @param request
     * @return
     */
    @RequestMapping("commandGetModelStateInfoId")
    public String commandGetModelStateInfoId(CommandRequest request) {
        logger.info("[POST] /api/command/commandGetModelStateInfoId");

        D0Response d0Response = commandServer.getModelState(request.getModelId());

        JsonResult jsonResult = JsonResult.getSUCCESS();
        List<D0Response> d0ResponseList = new ArrayList<>(1);
        d0ResponseList.add(d0Response);
        jsonResult.setData(d0ResponseList);

        return toJson(jsonResult);
    }

    /*
    * 控制继电器开闭状态 0xD1
    * */
    @RequestMapping("batchConfigerviceOpenClose")
    public String  batchConfigerviceOpenClose(CommandRequest request) {
        logger.info("[POST] /api/command/batchConfigerviceOpenClose");
        commandServer.configServiceOpenClose(request.getLightIds());
        return toJson(JsonResult.getSUCCESS());
    }

    /**
     * D1 uuid
     * @param request
     * @return
     */
    @RequestMapping("batchConfigModelStateUUID")
    public String batchConfigModelStateUUID(CommandRequest request) {
        logger.info("[POST] /api/command/batchConfigModelStateUUID");

        commandServer.configModelState(request.getModelUUIDs().get(0), request.getModelLoop(), request.getModelLoopState());

        return toJson(JsonResult.getSUCCESS());
    }

    /**
     * D1 id
     * @param request
     * @return
     */
    @RequestMapping("configModelStateId")
    public String configModelStateId(CommandRequest request) {
        logger.info("[POST] /api/command/configModelStateId");

        commandServer.configModelState(request.getLoopId(), request.getModelLoop(), request.getModelLoopState());

        return toJson(JsonResult.getSUCCESS());
    }

    /*
    *重启/复位 0xD2
    * */
    @RequestMapping("batchConfigRestart")
    public String batchConfigRestart(CommandRequest request){
        logger.info("[POST] /api/command/batchConfigRestart");
        commandServer.batchConfigRestart(request.getLightIds());
        return toJson(JsonResult.getSUCCESS());
    }
    /*
     *设置定时发送参数 0xD3
     * */
    @RequestMapping("batchCommandReadTimeParameter")
    public String batchCommandReadTimeParameter(CommandRequest request){
        logger.info("[POST] /api/command/batchCommandReadTimeParameter");
        commandServer.batchCommandReadTimeParameter(request.getLightIds());
        return toJson(JsonResult.getSUCCESS());
    }
    /*
    *读取/发送信息 0xD4
     */
    @RequestMapping("batchCommandReadSending")
    public String batchCommandReadSending(CommandRequest request){
        logger.info("[POST] /api/command/batchCommandReadSending");
        commandServer.batchCommandReadSending(request.getLightIds());
        return toJson(JsonResult.getSUCCESS());
    }
    /*
    * 服务器对设备广播对时 0xD5
    * */
    @RequestMapping("batchConfigSetTime")
    public void batchConfigSetTime(){
        logger.info("[POST] /api/command/batchConfigSetTime");
        commandServer.batchConfigSetTime();
    }
    /*
    *设置亮/灭灯定时策略 0xD6
     */
    @RequestMapping("batchConfigOpenCloseStrategy")
    public String batchConfigOpenCloseStrategy(CommandRequest request){
        logger.info("[POST] /api/command/batchConfigOpenCloseStrategy");
        commandServer.batchConfigOpenCloseStrategy(request.getLightIds());
        return toJson(JsonResult.getSUCCESS());
    }
    /*
     * 设置终端设备的工作模式（手动or自动）D7
     */
    @RequestMapping("batchConfigWorkModel")
    public String batchConfigWorkModel(CommandRequest request){
        logger.info("[POST] /api/command/batchConfigWorkModel");
        commandServer.batchConfigWorkModel(request.getLightIds());
        return toJson(JsonResult.getSUCCESS());
    }

    /**
     * 批量下发场景策略
     * @param request
     */
    @RequestMapping("batchExecScene")
    public void batchExecScene(CommandRequest request) {
        logger.info("[POST] /api/command/batchExecScene");

        commandServer.batchExecScene(request.getSceneIds());
    }
}
