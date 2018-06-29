package com.nnlightctl.springmvc.controller;

import com.nnlightctl.request.CommandRequest;
import com.nnlightctl.result.JsonResult;
import com.nnlightctl.server.CommandServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping("commandReadTerminalInfo")
    public void commandReadTerminalInfo() {
        logger.info("[POST] /api/command/commandReadTerminalInfo");

        commandServer.commandReadTerminalInfo();
    }
}
