package com.nnlightctl.springmvc.controller.deploy.controller;

import com.nnlightctl.request.deployRequest.DeployEleboxRequest;
import com.nnlightctl.result.JsonResult;
import com.nnlightctl.server.EleboxServer;
import com.nnlightctl.springmvc.controller.BaseController;
import com.nnlightctl.springmvc.controller.RoadLightingController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("deployElebox")
public class DeployEleboxController extends BaseController {

    @Autowired
    private EleboxServer eleboxServer;

    private static final Logger logger = LoggerFactory.getLogger(RoadLightingController.class);

    @RequestMapping("addelebox")
    public String addEleBox(@Valid DeployEleboxRequest request, BindingResult bindingResult) {
        logger.info("[POST] /api/roadlighting/addelebox");

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
