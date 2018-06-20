package com.nnlightctl.springmvc.controller;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.User;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.request.UserConditionRequest;
import com.nnlightctl.request.UserRequest;
import com.nnlightctl.result.JsonResult;
import com.nnlightctl.server.UserServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserServer userServer;

    @RequestMapping("addOrUpdateUser")
    public String addOrUpdateUser(UserRequest request) {
        logger.info("[POST] /api/user/addOrUpdateUser");

        int ret = userServer.addOrUpdateUser(request);

        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }

    @RequestMapping("listUser")
    public String listUser(BaseRequest request) {
        logger.info("[POST] /api/user/listUser");

        Tuple.TwoTuple<List<User>, Integer> tuple = userServer.listUser(request);

        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setData(tuple.getFirst());
        jsonResult.setTotal(tuple.getSecond());

        return toJson(jsonResult);
    }

    @RequestMapping("getUser")
    public String getUser(Long id) {
        logger.info("[POST] /api/user/getUser");

        User user = userServer.getUser(id);

        List<User> userList = new ArrayList<>(1);
        userList.add(user);

        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setData(userList);

        return toJson(jsonResult);
    }

    @RequestMapping("deleteUser")
    public String deleteUser(UserConditionRequest request) {
        logger.info("[POST] /api/user/deleteUser");

        int ret = userServer.deleteUser(request);

        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }

    @RequestMapping("updateUserPwd")
    public String updateUserPwd(UserConditionRequest request) {
        logger.info("[POST] /api/user/updateUserPwd");

        int ret = userServer.updateUserPwd(request);

        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }

    @RequestMapping("listOnlineUser")
    public String listOnlineUser() {
        logger.info("[POST] /api/user/listOnlineUser");

        Tuple.TwoTuple<List<User>, Integer> tuple = userServer.listOnlineUser();

        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setData(tuple.getFirst());
        jsonResult.setTotal(tuple.getSecond());

        return toJson(jsonResult);
    }
}