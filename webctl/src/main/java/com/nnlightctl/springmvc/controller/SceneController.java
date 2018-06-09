package com.nnlightctl.springmvc.controller;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.Scene;
import com.nnlightctl.request.*;
import com.nnlightctl.result.JsonResult;
import com.nnlightctl.server.SceneServer;
import com.nnlightctl.vo.SceneView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/scene")
public class SceneController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(SceneController.class);

    @Autowired
    private SceneServer sceneServer;

    @RequestMapping("addOrUpdateScene")
    public String addOrUpdateScene(SceneRequest request) {
        logger.info("[POST] /api/scene/addOrUpdateScene");

        int ret = sceneServer.addOrUpdateScene(request);
        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }

    @RequestMapping("listScene")
    public String listScene(BaseRequest request) {
        logger.info("[POST] /api/scene/listScene");

        Tuple.TwoTuple<List<Scene>, Integer> tuple = sceneServer.listScene(request);

        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setData(tuple.getFirst());
        jsonResult.setTotal(tuple.getSecond());

        return toJson(jsonResult);
    }

    @RequestMapping("getScene")
    public String getScene(Long id) {
        logger.info("[POST] /api/scene/getScene");

        SceneView sceneView = sceneServer.getScene(id);

        JsonResult jsonResult = JsonResult.getSUCCESS();

        List<SceneView> sceneViewList = new ArrayList<>(1);
        sceneViewList.add(sceneView);

        jsonResult.setData(sceneViewList);

        return toJson(jsonResult);
    }

    @RequestMapping("deleteScene")
    public String deleteScene(SceneConditionRequest request) {
        logger.info("[POST] /api/scene/deleteScene");

        int ret = sceneServer.deleteScene(request);

        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }

    @RequestMapping("addOrUpdateSceneShotcut")
    public String addOrUpdateSceneShotcut(SceneShotcutRequest request) {
        logger.info("[POST] /api/scene/addOrUpdateSceneShotcut");

        int ret = sceneServer.addOrUpdateSceneShotcut(request);
        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }

    @RequestMapping("deleteSceneShotcut")
    public String deleteSceneShotcut(SceneShotcutConditionRequest request) {
        logger.info("[POST] /api/scene/deleteSceneShotcut");

        int ret = sceneServer.deleteSceneShotcut(request);

        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }
}
