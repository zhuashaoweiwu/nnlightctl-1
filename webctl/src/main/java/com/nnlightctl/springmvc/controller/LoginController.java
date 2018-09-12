package com.nnlightctl.springmvc.controller;

import com.nnlightctl.request.LoginRequest;

import com.nnlightctl.result.JsonResult;
import com.nnlightctl.server.LoginServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/login")
public class LoginController extends BaseController {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginServer loginServer;

    @RequestMapping("Login")
    public String login(LoginRequest request) {
        log.info("[POST] /api/login/Login");

        int ret = loginServer.login(request);
        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }
}
