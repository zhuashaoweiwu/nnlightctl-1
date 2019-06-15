package com.nnlightctl.springmvc.controller.deploychange;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.LampController;
import com.nnlightctl.request.LampControllerConditionRequest;
import com.nnlightctl.request.LightRequest;
import com.nnlightctl.result.JsonResult;
import com.nnlightctl.springmvc.controller.BaseController;
import com.nnlightctl.vo.LampControllerView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("api/deploy")
public class DeployElebox extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(DeployElebox.class);


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

        int flag=-1;

        JsonResult jsonResult=null;

        if (flag>0){

            jsonResult=JsonResult.getSUCCESS();

        }else {
            jsonResult=JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }


    @RequestMapping("deletelightingcontroller")
    public String deleteLightingController(LampControllerConditionRequest request){

        logger.info("[POST] api/roadlighting/deletelampcontroller");

        int ret = lampControllerServer.deleteLampController(request);

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
    public String listLightingController(LampControllerConditionRequest request){

        logger.info("[POST] api/roadlighting/listlampcontroller");

        Tuple.TwoTuple<List<LampControllerView>,Integer> twoTuple=lampControllerServer.listLampController(request);

        JsonResult jsonResult = JsonResult.getSUCCESS();

        jsonResult.setTotal(twoTuple.getSecond());

        jsonResult.setData(twoTuple.getFirst());

        return toJson(jsonResult);
    }

    @RequestMapping("selectbyidlightingingcontroller")
    public String selectByIdLightingController(LampControllerConditionRequest request){

        logger.info("[POST] api/roadlighting/selectbyidlampcontroller ");

        JsonResult jsonResult=null;


        List<LampController> lampControllerList=new ArrayList<>();

        LampController lampController = lampControllerServer.selectByIdLampController(request);

        jsonResult=JsonResult.getSUCCESS();

        jsonResult.setTotal(1);

        lampControllerList.add(lampController);

        jsonResult.setData(lampControllerList);

        return toJson(jsonResult);


    }




}
