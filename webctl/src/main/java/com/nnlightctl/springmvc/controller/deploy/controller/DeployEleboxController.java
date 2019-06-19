package com.nnlightctl.springmvc.controller.deploy.controller;

import com.nnlight.common.PubMethod;
import com.nnlight.common.Tuple;
import com.nnlightctl.request.deployRequest.DeployEleboxModelRequest;
import com.nnlightctl.request.deployRequest.DeployEleboxRequest;
import com.nnlightctl.request.deployRequest.DeployExleboxArrangeRequest;
import com.nnlightctl.result.JsonResult;
import com.nnlightctl.server.deploy.service.DeployEleboxModelServer;
import com.nnlightctl.server.deploy.service.DeployEleboxServer;
import com.nnlightctl.springmvc.controller.BaseController;
import com.nnlightctl.springmvc.controller.RoadLightingController;
import com.nnlightctl.vo.DeployEleboxView;
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
@RequestMapping("deployElebox")
public class DeployEleboxController extends BaseController {

    @Autowired
    private DeployEleboxServer deployEleboxServer;

    @Autowired
    private DeployEleboxModelServer eleboxModelServer;

    private static final Logger logger = LoggerFactory.getLogger(RoadLightingController.class);

    @RequestMapping("deployAddOrModifyElebox")
    public String deployAddOrModifyElebox(@Valid DeployEleboxRequest request, BindingResult bindingResult) {
        logger.info("[POST] deployElebox/deployAddElebox");

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
        int ret = 0;
        if (PubMethod.isEmpty(request.getId())) {
            ret = deployEleboxServer.insertElebox(request);
        } else {
            ret = deployEleboxServer.updateElebox(request);
        }
        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }


    @RequestMapping("deployAddOrModifyEleboxModel")
    public String deployAddOrModifyEleboxModel(@Valid DeployEleboxModelRequest request, BindingResult bindingResult) {
        logger.info("[POST] deployElebox/deployAddOrModifyEleboxModel");

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
        int ret = 0;
        if (PubMethod.isEmpty(request.getId())) {
            ret = eleboxModelServer.insertEleboxModel(request);
        } else {
            ret = eleboxModelServer.updateEleboxModel(request);
        }
        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }

    /**
     * 控制柜修改部署
     */
    @RequestMapping("deployEleboxList")
    public String deployEleboxList(@Valid DeployEleboxRequest request, BindingResult bindingResult) {
        logger.info("[POST] deployElebox/deployEleboxList");

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

        Tuple.TwoTuple<List<DeployEleboxView>, Integer> tuple = this.eleboxModelServer.deployEleboxList(request);
        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setData(tuple.getFirst());
        jsonResult.setTotal(tuple.getSecond());
        return toJson(jsonResult);
    }


    @RequestMapping("deployExleboxDelete")
    public String deployExleboxDelete(@Valid DeployExleboxArrangeRequest request, BindingResult bindingResult) {
        logger.info("[POST] deployElebox/deployExleboxArrange");

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
        Boolean arrangeRequest = this.deployEleboxServer.deployExleboxDelete(request.getExleboxId());
        JsonResult jsonResult = null;
        if (arrangeRequest) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }


    @RequestMapping("deployExleboxModify")
    public String deployExleboxModify(@Valid DeployExleboxArrangeRequest request, BindingResult bindingResult) {
        logger.info("[POST] deployElebox/deployExleboxArrange");

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

        this.deployEleboxServer.deployExleboxModify(request);
        return toJson(JsonResult.getSUCCESS());
    }



    @RequestMapping("deployExleboxArrange")
    public String deployExleboxArrange(@Valid DeployExleboxArrangeRequest request, BindingResult bindingResult) {
        logger.info("[POST] deployElebox/deployExleboxArrange");

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

//        request.setExleboxId(45L);
//        request.setExleboxModelIds(new ArrayList<Long>(){{add(40L);}});
//
//
//        DeployEleboxModelLoopRequest deployEleboxModelLoopRequest = new DeployEleboxModelLoopRequest();
//        deployEleboxModelLoopRequest.setMem("lxwTest");
//        deployEleboxModelLoopRequest.setExleboxModelId(40L);
//        deployEleboxModelLoopRequest.setLoopCode("1");
//
//        List<Long>  lightingList = new ArrayList();
//        lightingList.add(110L);
//        deployEleboxModelLoopRequest.setLightingList(lightingList);
//        List p = new ArrayList<DeployEleboxModelLoopRequest>();
//        p.add(deployEleboxModelLoopRequest);
//        request.setModelLoopRequests(p);

        Boolean arrangeRequest = this.deployEleboxServer.deployExleboxArrange(request);
        JsonResult jsonResult = null;
        if (arrangeRequest) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }


}