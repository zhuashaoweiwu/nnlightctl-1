package com.nnlightctl.springmvc.controller;

import com.nnlightctl.request.CommandRequest;
import com.nnlightctl.server.CommandServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/command")
public class CommandController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(CommandController.class);

    @Autowired
    private CommandServer commandServer;

    @RequestMapping("sendcommand")
    public String sendCommand(CommandRequest request) {
        logger.info("[POST] /api/command/sendcommand");

        return commandServer.sendCommand(request.getMsg());
    }
}
