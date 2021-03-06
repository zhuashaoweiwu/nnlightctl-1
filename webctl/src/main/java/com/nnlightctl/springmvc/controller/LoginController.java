package com.nnlightctl.springmvc.controller;

import com.nnlightctl.request.LoginRequest;

import com.nnlightctl.result.JsonResult;
import com.nnlightctl.server.LoginServer;
import com.nnlightctl.vo.MenuView;
import com.nnlightctl.vo.UserView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("api/login")
public class LoginController extends BaseController {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginServer loginServer;

    @RequestMapping("Login")
    @ResponseBody
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

    @RequestMapping("Logout")
    @ResponseBody
    public String logout() {
        log.info("[POST] /api/login/Logout");

        int ret = loginServer.logout();
        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }

    @RequestMapping("getMenu")
    @ResponseBody
    public String getMenu() {
        log.info("[POST] /api/login/getMenu");

        List<MenuView> menuViewList = loginServer.listMenu();
        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setData(menuViewList);
        return toJson(jsonResult);
    }

    @RequestMapping("getStaticMenu")
    @ResponseBody
    public String getStaticMenu() {
        log.info("[POST] /api/login/getStaticMenu");

        List<MenuView> menuViewList = loginServer.getStaticMenu();
        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setData(menuViewList);

        return toJson(jsonResult);
    }

    @RequestMapping("getMenuById")
    @ResponseBody
    public String getMenuById(Long id) {
        log.info("[POST] /api/login/getMenuById");

        List<MenuView> menuViewList = loginServer.getMenuByUserId(id);
        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setData(menuViewList);

        return toJson(jsonResult);
    }

    @RequestMapping("loginUrl")
    public String loginUrl() {
        log.info("[POST] /api/login/loginUrl");

        return "redirect:/html/singlelamp/nnlightctl/Login.html";
    }

    @RequestMapping("sucessUrl")
    public String successLogin() {
        log.info("[POST] /api/login/sucessUrl");

        return "redirect:/html/singlelamp/nnlightctl/Index.html";
    }

    @RequestMapping("getLoginUser")
    @ResponseBody
    public String getLoginUser() {
        log.info("[POST] /api/login/getLoginUser");

        UserView userView = loginServer.getLoginUser();
        List<UserView> userViewList = new ArrayList<>(1);
        userViewList.add(userView);

        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setData(userViewList);

        return toJson(jsonResult);
    }
}
