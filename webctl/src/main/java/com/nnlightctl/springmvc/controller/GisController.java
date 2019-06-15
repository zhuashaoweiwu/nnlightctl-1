package com.nnlightctl.springmvc.controller;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.Elebox;
import com.nnlightctl.request.EleboxConditionRequest;
import com.nnlightctl.request.EleboxRequest;
import com.nnlightctl.request.LightConditionRequest;
import com.nnlightctl.result.JsonResult;
import com.nnlightctl.server.EleboxServer;
import com.nnlightctl.server.LightServer;
import com.nnlightctl.vo.EleboxView;
import com.nnlightctl.vo.LightingView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/gis")
public class GisController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(GisController.class);

    @Autowired
    private EleboxServer eleboxServer;

    @Autowired
    private LightServer lightServer;

    @RequestMapping("listElebox")
    public String listElebox(EleboxConditionRequest request) {
        logger.info("[POST] /api/gis/listElebox");

        Tuple.TwoTuple<List<Elebox>, Integer> tuple = this.eleboxServer.listElebox(request);

        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setData(tuple.getFirst());
        jsonResult.setTotal(tuple.getSecond());

        return toJson(jsonResult);
    }

    @RequestMapping("listLighting")
    public String listLighting(LightConditionRequest request) {
        logger.info("[POST] /api/gis/listLighting");

        Tuple.TwoTuple<List<LightingView>, Integer> tuple = this.lightServer.listLightingView(request);

        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setData(tuple.getFirst());
        jsonResult.setTotal(tuple.getSecond());

        return toJson(jsonResult);
    }

    @RequestMapping("listSelectLighting")
    public String listSelectLighting(LightConditionRequest request) {
        logger.info("[POST] /api/gis/listSelectLighting");

        List<LightingView> lightingViewList = lightServer.listSelectLighting(request);

        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setData(lightingViewList);

        return toJson(jsonResult);
    }

    @RequestMapping("listLoopLighting")
    public String listLoopLighting(LightConditionRequest request) {
        logger.info("[POST] /api/gis/listLoopLighting");

        Tuple.TwoTuple<List<LightingView>, Integer> tuple = this.lightServer.listLoopLighting(request);

        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setData(tuple.getFirst());
        jsonResult.setTotal(tuple.getSecond());

        return toJson(jsonResult);
    }
    @RequestMapping("getLightSignalByUUID")
    public String getLightSignalByUUID(String uuid){
        logger.info("[POST] /api/gis/getLightSignalByUUID");
        String signalIntensity = lightServer.getLightSignalByUUID(uuid);
        List<String> list= new ArrayList<>();
        list.add(signalIntensity);
        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setData(list);
        return toJson(jsonResult);
    }
}
