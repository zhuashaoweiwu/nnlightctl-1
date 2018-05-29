package com.nnlightctl.springmvc.controller;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.Elebox;
import com.nnlightctl.po.Lighting;
import com.nnlightctl.request.EleboxConditionRequest;
import com.nnlightctl.request.LightConditionRequest;
import com.nnlightctl.result.JsonResult;
import com.nnlightctl.server.EleboxServer;
import com.nnlightctl.server.LightServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

        Tuple.TwoTuple<List<Lighting>, Integer> tuple = this.lightServer.listLighting(request);

        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setData(tuple.getFirst());
        jsonResult.setTotal(tuple.getSecond());

        return toJson(jsonResult);
    }
}
