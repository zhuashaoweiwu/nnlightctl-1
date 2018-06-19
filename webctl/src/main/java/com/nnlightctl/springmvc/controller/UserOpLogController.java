package com.nnlightctl.springmvc.controller;

import com.nnlight.common.Tuple;
import com.nnlightctl.request.UserOpLogConditionRequest;
import com.nnlightctl.result.JsonResult;
import com.nnlightctl.server.UserOpLogServer;
import com.nnlightctl.vo.UserOpLogView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserOpLogController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(UserOpLogController.class);

    @Autowired
    private UserOpLogServer userOpLogServer;

    @RequestMapping("listUserOpLog")
    public String listUserOpLog(UserOpLogConditionRequest request) {
        logger.info("[POST] /api/user/listUserOpLog");

        Tuple.TwoTuple<List<UserOpLogView>, Integer> tuple = userOpLogServer.listUserOpLog(request);

        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setData(tuple.getFirst());
        jsonResult.setTotal(tuple.getSecond());

        return toJson(jsonResult);
    }
}
