package com.nnlightctl.springmvc.controller;

import com.nnlightctl.request.*;
import com.nnlightctl.result.JsonResult;
import com.nnlightctl.server.EleboxModelServer;
import com.nnlightctl.server.EleboxServer;
import com.nnlightctl.server.ModelLoopServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/roadlighting")
public class RoadLightingController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(RoadLightingController.class);

    @Autowired
    private ModelLoopServer modelLoopServer;

    @Autowired
    private EleboxModelServer modelServer;

    @Autowired
    private EleboxServer eleboxServer;

    @RequestMapping("addorupdatemodelloop")
    public String addOrUpdateModelLoop(ModelLoopRequest request) {
        logger.info("[POST] /api/roadlighting/addorupdatemodelloop");

        int ret = modelLoopServer.addOrUpdateModelLoop(request);

        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }

    @RequestMapping("deletemodelloop")
    public String deleteModeLoop(ModelLoopConditionRequest request) {
        logger.info("[POST] /api/roadlighting/deletemodelloop");

        int ret = modelLoopServer.deleteModelLoop(request);
        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }

    @RequestMapping("addeleboxmodel")
    public String addEleboxModel(EleboxModelRequest request) {
        logger.info("[POST] /api/roadlighting/addeleboxmodel");

        int ret = modelServer.addEleboxModel(request);

        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }

    @RequestMapping("updateeleboxmodel")
    public String updateEleboxModel(EleboxModelRequest request) {
        logger.info("[POST] /api/roadlighting/updateeleboxmodel");

        int ret = modelServer.updateEleboxModel(request);
        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }

    @RequestMapping("deleteeleboxmodel")
    public String deleteEleboxModel(EleboxModelConditionRequest request) {
        logger.info("[POST] /api/roadlighting/deleteeleboxmodel");

        int ret = modelServer.deleteEleboxModel(request);
        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }

    @RequestMapping("addelebox")
    public String addEleBox(EleboxAddModelRequest request) {
        logger.info("[POST] /api/roadlighting/addelebox");

        int ret = eleboxServer.insertElebox(request);
        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }
}
