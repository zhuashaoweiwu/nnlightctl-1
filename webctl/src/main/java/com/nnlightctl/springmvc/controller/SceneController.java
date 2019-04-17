package com.nnlightctl.springmvc.controller;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.Scene;
import com.nnlightctl.po.SceneShotcut;
import com.nnlightctl.request.*;
import com.nnlightctl.result.JsonResult;
import com.nnlightctl.server.SceneServer;
import com.nnlightctl.vo.SceneView;
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
@RequestMapping("api/scene")
public class SceneController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(SceneController.class);

    @Autowired
    private SceneServer sceneServer;

    @RequestMapping("addOrUpdateScene")
    public String addOrUpdateScene(@Valid SceneRequest request, BindingResult bindingResult) {
        logger.info("[POST] /api/scene/addOrUpdateScene");

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

        int ret = sceneServer.addOrUpdateScene(request);
        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }

    /*
    *前端接口-GIS地理信息模块
    *十五点一、通过快捷键名称统计快捷场景映射数量（判断快捷键名称重复）
    * */
    @RequestMapping("countSceneShotcutByShotcutName")
    public String countSceneShotcutByShotcutName(String shotcutName){
        logger.info("[POST] /api/scene/countSceneShotcutByShotcutName");
        int total = sceneServer.getCountSceneShotcutByShotcutName(shotcutName);
        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setTotal(total);
        return toJson(jsonResult);
    }
    /*
     *前端接口-GIS地理信息模块
     *十五点二、通过场景ID统计快捷键场景映射数量（判断场景ID是否重复）
     * */
    @RequestMapping("countSceneShotcutBySceneId")
    public String countSceneShotcutBySceneId(Long sceneId){
        logger.info("[POST] /api/scene/countSceneShotcutBySceneId");
        int total = sceneServer.getCountSceneShotcutBySceneId(sceneId);
        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setTotal(total);
        return toJson(jsonResult);
    }

    @RequestMapping("listScene")
    public String listScene(SceneRequest request) {
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
    public String addOrUpdateSceneShotcut(@Valid SceneShotcutRequest request, BindingResult bindingResult) {
        logger.info("[POST] /api/scene/addOrUpdateSceneShotcut");

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

    @RequestMapping("invokeSceneShotcut")
    public String invokeSceneShotCut(String shotcutName) {
        logger.info("[POST] /api/scene/invokeSceneShotcut");

        int ret = sceneServer.getInvokeSceneShotcut(shotcutName);

        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }

    @RequestMapping("listSceneShotCut")
    public String listSceneShotCut() {
        logger.info("[POST] /api/scene/listSceneShotCut");

        List<SceneShotcut> sceneShotcutList = sceneServer.listSceneShotcut();

        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setData(sceneShotcutList);

        return toJson(jsonResult);
    }
}
