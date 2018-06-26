package com.nnlightctl.springmvc.controller;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.SystemParam;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.request.SystemParamRequest;
import com.nnlightctl.result.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.nnlightctl.server.SystemParamServer;
import com.nnlightctl.request.SystemParamIdsRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/systemParam")
public class SystemParamController  extends BaseController{
    private Logger logger = LoggerFactory.getLogger(SystemParamController.class);

    @Autowired
    private SystemParamServer systemParamServer;

    /*
     * 系统参数的新增和修改
     * */
    @RequestMapping("addOrUpdateSystemParam")
    public String addOrUpdateSystemParam(SystemParamRequest request) {
        logger.info("[POST] /api/systemParam/addOrUpdateSystemParam/");

        JsonResult jsonResult = null;

        int ret = systemParamServer.addOrUpdateSystemParam(request);
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }
        return toJson(jsonResult);
    }
    /*
    * 通过id获取单个系统参数
    * */
    @RequestMapping("getSystemParamById")
    public String getSystemParamById(Long id ){
        logger.info("[POST] /api/systemParam/getSystemParamById");

        SystemParam systemParam =  systemParamServer.getDepartment(id);

        JsonResult jsonResult = JsonResult.getSUCCESS();

        List<SystemParam> systemParamList = new ArrayList<>(1);
        systemParamList.add(systemParam);

        JsonResult jsonResult1 = JsonResult.getSUCCESS();
        jsonResult.setData(systemParamList);

        return toJson(jsonResult);

    }
    /*
     * 通过系统参数唯一编码获取系统参数
     * */
    @RequestMapping("getSystemParamByCode")
    public String getSystemParamByCode(String codeNumber){

        logger.info("[POST] /api/systemParam/getSystemParamByCode");

        JsonResult jsonResult = JsonResult.getSUCCESS();

        List<SystemParam> systemParamList =  systemParamServer.getSystemParamByCode(codeNumber);
        jsonResult.setData(systemParamList);

        return toJson(jsonResult);
    }

    /*
    *通过过搜索条件分页获取全部系统参数集合
    * */
    public String listSystemParam(BaseRequest request){
        logger.info("[POST] /api/systemParam/listSystemParam");


        Tuple.TwoTuple<List<SystemParam>, Integer> tuple = systemParamServer.listSystemParam(request);

        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setData(tuple.getFirst());
        jsonResult.setTotal(tuple.getSecond());

        return toJson(jsonResult);
    }
    /*
    *删除系统参数
    * */
    @RequestMapping("deleteSystemParam")
    public String deleteSystemParam(SystemParamIdsRequest request){
        logger.info("[POST] /api/systemParam/deleteSystemParam");
        int ret = systemParamServer.deleteSystemParam(request.getSystemParamIds());
        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }
}
