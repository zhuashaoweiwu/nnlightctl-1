package com.nnlightctl.springmvc.controller;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.User;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.request.UserConditionRequest;
import com.nnlightctl.request.UserRequest;
import com.nnlightctl.result.JsonResult;
import com.nnlightctl.server.UserServer;
import com.nnlightctl.vo.UserView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserServer userServer;

    @RequestMapping("addOrUpdateUser")
    public String addOrUpdateUser(@Valid UserRequest request, BindingResult bindingResult) {
        logger.info("[POST] /api/user/addOrUpdateUser");

        //参数检验
        if (bindingResult.hasErrors()) {
            JsonResult jsonResult = JsonResult.getFAILURE();
            StringBuilder stringBuilder = new StringBuilder();
            List<ObjectError> objectErrorList = bindingResult.getAllErrors();
            for (ObjectError objectError : objectErrorList) {
                stringBuilder.append(objectError.getDefaultMessage() + "\r\n");
            }

            jsonResult.setMsg(stringBuilder.toString());
            return toJson(jsonResult);
        }

        int ret = userServer.addOrUpdateUser(request);

        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }
    /*
    *用户管理
    *一点一、通过登录名统计用户数量（判断用户登录名是否重复）
    * */
    @RequestMapping("countUserByLoginName")
    public String countUserByLoginName(String loginName){
        logger.info("[POST] /api/user/countUserByLoginName");
        int total = userServer.getCountUserByLoginName(loginName);
        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setTotal(total);
        return toJson(jsonResult);
    }
    /*
     *用户管理
     *一点二、通过编号统计用户数量（判断编号是否重复）
     * */
    @RequestMapping("countUserByCodeNumber")
    public String countUserByCodeNumber(String codeNumber){
        logger.info("[POST] /api/user/countUserByCodeNumber");
        int total = userServer.getCountUserByCodeNumber(codeNumber);
        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setTotal(total);
        return toJson(jsonResult);
    }

    @RequestMapping("listUser")
    public String listUser(UserConditionRequest request) {
        logger.info("[POST] /api/user/listUser");

        Tuple.TwoTuple<List<UserView>, Integer> tuple = userServer.listUser(request);

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

        int ret = userServer.deleteUser(request.getUserIds());
        List<Long> userIds = request.getUserIds();
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

    @RequestMapping("initUserPassword")
    public String initUserPassword(Long id) {
        logger.info("[POST] /api/user/initUserPassword");

        int ret = userServer.updateInitUserPwd(id);
        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }

    @RequestMapping("lockUser")
    public String lockUser(UserConditionRequest request) {
        logger.info("[POST] /api/user/lockUser");

        int ret = userServer.updateUserLockState(request.getId(), request.getState());
        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }
}
