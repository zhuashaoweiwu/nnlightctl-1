package com.nnlightctl.springmvc.controller;

import com.nnlight.common.Tuple;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.request.LightGroupRequest;
import com.nnlightctl.result.JsonResult;
import com.nnlightctl.server.LightGroupServer;
import com.nnlightctl.vo.LightGroupView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/lightGroup")
public class LightGroupController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(LightGroupController.class);

    @Autowired
    private LightGroupServer lightGroupServer;

    @RequestMapping("createLightGroupByLightIds")
    public String createLightGroupByLightId(LightGroupRequest request) {
        logger.info("[POST] /api/lightGroup/createLightGroupByLightIds");

        int ret = lightGroupServer.createLightGroupByLightIds(request);
        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }

    @RequestMapping("createLightGroupByLightUIDs")
    public String createLightGroupByLightUIDs(LightGroupRequest request) {
        logger.info("[POST] /api/lightGroup/createLightGroupByLightUIDs");

        int ret = lightGroupServer.createLightGroupByLightUIDs(request);
        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }

    @RequestMapping("createLightGroupByLightGroup")
    public String createLightGroupByGroup(LightGroupRequest request) {
        logger.info("[POST] /api/lightGroup/createLightGroupByLightGroup");

        int ret = lightGroupServer.createLightGroupByLightGroup(request);
        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }

    @RequestMapping("listLightGroup")
    public String listLightGroup(LightGroupRequest request) {
        logger.info("[POST] /api/lightGroup/listLightGroup");

        Tuple.TwoTuple<List<LightGroupView>, Integer> tuple = this.lightGroupServer.listLightGroup(request);

        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setData(tuple.getFirst());
        jsonResult.setTotal(tuple.getSecond());

        return toJson(jsonResult);
    }
}
