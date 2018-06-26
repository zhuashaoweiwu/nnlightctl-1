package com.nnlightctl.springmvc.controller;

import com.nnlightctl.po.Alarm;
import com.nnlight.common.Tuple;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.result.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.nnlightctl.server.ALarmServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/alarm")
public class AlarmController extends BaseController{

    private Logger logger = LoggerFactory.getLogger(AlarmController.class);
    @Autowired
    private ALarmServer aLarmServer;

    @RequestMapping("listAlarm")
    public String listAlarm(BaseRequest request){
        logger.info("[POST] /api/alarm/listAlarm");

        JsonResult jsonResult = JsonResult.getSUCCESS();

        Tuple.TwoTuple<List<Alarm>, Integer> tuple = aLarmServer.listAlarm(request);

        jsonResult.setData(tuple.getFirst());
        jsonResult.setTotal(tuple.getSecond());

        return toJson(jsonResult);
    }
}
