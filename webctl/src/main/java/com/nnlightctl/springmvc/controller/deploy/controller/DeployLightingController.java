package com.nnlightctl.springmvc.controller.deploy.controller;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.LampController;
import com.nnlightctl.po.Lighting;
import com.nnlightctl.po.SystemParam;
import com.nnlightctl.request.LampControllerConditionRequest;
import com.nnlightctl.request.LampControllerRequest;
import com.nnlightctl.request.LamppostConditionRequest;
import com.nnlightctl.request.LightRequest;
import com.nnlightctl.request.deployRequest.DeployLighting;
import com.nnlightctl.request.deployRequest.LightingConditionRequest;
import com.nnlightctl.result.JsonResult;
import com.nnlightctl.server.LampControllerServer;
import com.nnlightctl.server.deploy.service.LightingControllerServer;
import com.nnlightctl.springmvc.controller.BaseController;
import com.nnlightctl.vo.DeployLightingView;
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
@RequestMapping("api/deploy")
public class DeployLightingController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(DeployLightingController.class);

    @Autowired
    private LightingControllerServer lightingControllerServer;

    @Autowired
    private LampControllerServer lampControllerServer;


    @RequestMapping("addorupdatelightingcontroller")
    public String AddOrUpdatelightContoller(@Valid LightRequest request, BindingResult bindingResult){

        logger.info("[POST] api/deploy/addorupdatelightingcontroller");
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

        int flag=lightingControllerServer.addOrUpdateLightingController(request);

        JsonResult jsonResult=null;

        if (flag>0){

            jsonResult=JsonResult.getSUCCESS();

            jsonResult.setTotal(-1);

        }else {
            jsonResult=JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }


    @RequestMapping("deletelightingcontroller")
    public String deleteLightingController(LightingConditionRequest request){

        logger.info("[POST] api/roadlighting/deletelightingcontroller");

        int ret = lightingControllerServer.deteleLightingController(request);

        JsonResult jsonResult=null;

        if (ret>0){
            jsonResult=JsonResult.getSUCCESS();
            jsonResult.setTotal(null);
        }else {
           jsonResult=JsonResult.getFAILURE();
        }

        return toJson(jsonResult);

    }


    @RequestMapping("listlightingcontroller")
    public String listLightingController(LightingConditionRequest request){

        logger.info("[POST] api/roadlighting/listlightingcontroller");

        Tuple.TwoTuple<List<Lighting>,Integer> twoTuple=lightingControllerServer.listLightingController(request);

        JsonResult jsonResult = JsonResult.getSUCCESS();

        jsonResult.setTotal(twoTuple.getSecond());

        jsonResult.setData(twoTuple.getFirst());

        return toJson(jsonResult);
    }

    @RequestMapping("selectbyidlightingcontroller")
    public String selectByIdLightingController(LightingConditionRequest request){

        logger.info("[POST] api/roadlighting/selectbyidlightingcontroller ");


        List<Lighting> lightings=new ArrayList<>(7);

        Lighting lighting = lightingControllerServer.selectLightingController(request);

        lightings.add(lighting);

        JsonResult jsonResult=JsonResult.getSUCCESS();

        jsonResult.setTotal(1);

        jsonResult.setData(lightings);
        return toJson(jsonResult);


    }

    @RequestMapping("selectdeploylighting")
    public String selectDeployLighting(){

        logger.info("[POST]  api/deploy/selectdeploylighting");

        DeployLighting deployLighting = lightingControllerServer.selectLightDeploy();

        List<DeployLighting> systemParamList = new ArrayList<>(7);

        systemParamList.add(deployLighting);

        JsonResult jsonResult = JsonResult.getSUCCESS();

        jsonResult.setData(systemParamList);

        return toJson(jsonResult);
    }

    @RequestMapping("selectByLampModel")
    public String selectByLampModel(LampControllerRequest request){

        logger.info("[POST] api/deploy/selectByLampModel");

        List<LampController> lampControllerList = lampControllerServer.selectByLampModel(request);

        JsonResult jsonResult = JsonResult.getSUCCESS();

        jsonResult.setData(lampControllerList);

        jsonResult.setTotal(lampControllerList.size());

        return toJson(jsonResult);


    }

    /**
     * 修改单灯的部署
     */
    @RequestMapping("updatedeploylighting")
    public String updateDeployLighting(LampControllerRequest request){

        logger.info("[POST]  api/deploy/updatedeploylighting");

        int flag = lampControllerServer.deployUpdateLighting(request);

        JsonResult jsonResult=null;

        if (flag>0){

            jsonResult = JsonResult.getSUCCESS();

            jsonResult.setTotal(-1);

        }else {

            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }

    @RequestMapping("showdeploylighting")
    public String ShowDeploylighting(LampControllerConditionRequest request){

        logger.info("[POST]  api/deploy/showdeploylighting");

        Tuple.TwoTuple<List<DeployLightingView>, Integer> showDeployLighting = lampControllerServer.selectByExampleDeployLighting(request);

        JsonResult jsonResult = JsonResult.getSUCCESS();

        jsonResult.setTotal(showDeployLighting.getSecond());

        jsonResult.setData(showDeployLighting.getFirst());

        return toJson(jsonResult);
    }




}
