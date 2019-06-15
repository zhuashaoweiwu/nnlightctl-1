package com.nnlightctl.springmvc.controller.deploychange;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.LampController;
import com.nnlightctl.po.Lighting;
import com.nnlightctl.request.LampControllerConditionRequest;
import com.nnlightctl.request.LightConditionRequest;
import com.nnlightctl.request.LightRequest;
import com.nnlightctl.request.deployRequest.LightingConditionRequest;
import com.nnlightctl.result.JsonResult;
import com.nnlightctl.server.deploy.LightingController;
import com.nnlightctl.springmvc.controller.BaseController;
import com.nnlightctl.vo.LampControllerView;
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
    private LightingController lightingController;


    @RequestMapping("addorupdatelightingcontroller")
    public String AddOrUpdatelightContoller(@Valid LightRequest request, BindingResult bindingResult){

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

        int flag=lightingController.addOrUpdateLightingController(request);

        JsonResult jsonResult=null;

        if (flag>0){

            jsonResult=JsonResult.getSUCCESS();

        }else {
            jsonResult=JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }


    @RequestMapping("deletelightingcontroller")
    public String deleteLightingController(LightingConditionRequest request){

        logger.info("[POST] api/roadlighting/deletelightingcontroller");

        int ret = lightingController.deteleLightingController(request);

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

        Tuple.TwoTuple<List<Lighting>,Integer> twoTuple=lightingController.listLightingController(request);

        JsonResult jsonResult = JsonResult.getSUCCESS();

        jsonResult.setTotal(twoTuple.getSecond());

        jsonResult.setData(twoTuple.getFirst());

        return toJson(jsonResult);
    }

    @RequestMapping("selectbyidlightingcontroller")
    public String selectByIdLightingController(LightingConditionRequest request){

        logger.info("[POST] api/roadlighting/selectbyidlightingcontroller ");


        List<Lighting> lightings=new ArrayList<>(7);

        Lighting lighting = lightingController.selectLightingController(request);

        lightings.add(lighting);

        JsonResult jsonResult=JsonResult.getSUCCESS();

        jsonResult.setTotal(1);

        jsonResult.setData(lightings);
        return toJson(jsonResult);


    }




}
