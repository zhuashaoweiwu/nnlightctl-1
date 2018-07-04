package com.nnlightctl.springmvc.controller;

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

        commandServer.configTerminalSwitchPolicy(switchTaskList);
    }

    @RequestMapping("commandReadTerminalInfo")
    public void commandReadTerminalInfo() {
        logger.info("[POST] /api/command/commandReadTerminalInfo");

        commandServer.commandReadTerminalInfo();
    }
}
