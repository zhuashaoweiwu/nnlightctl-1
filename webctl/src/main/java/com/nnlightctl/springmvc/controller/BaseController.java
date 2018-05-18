package com.nnlightctl.springmvc.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nnlightctl.po.ProjectCountry;
import com.nnlightctl.result.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BaseController {
    /**
     * 对象返回json字符串
     * @param jsonResult
     * @return
     */
    public String toJson(JsonResult jsonResult) {
        JSONObject jsonObject = new JSONObject();
        //返回头
        JSONObject header = new JSONObject();
        header.put("code", jsonResult.getCode());
        header.put("msg", jsonResult.getMsg());
        jsonObject.put("header", header);
        //返回体
        JSONObject body = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        List<?> dataList = jsonResult.getData();
        if (dataList != null) {
            for (Object data : dataList) {
                jsonArray.add(data);
            }
        }
        body.put("data", jsonArray);
        jsonObject.put("body", body);

        return jsonObject.toJSONString();
    }

    @ExceptionHandler
    @ResponseBody
    public String caughtException(RuntimeException exception) {
        JsonResult jsonResult = JsonResult.FAILURE;
        jsonResult.setMsg(exception.getMessage());
        return toJson(jsonResult);
    }

    public static void main(String[] args) {
        JsonResult jsonResult = JsonResult.SUCCESS;
        List<ProjectCountry> dataList = new ArrayList<>(2);
        ProjectCountry projectCountry = new ProjectCountry();
        projectCountry.setId(1L);
        projectCountry.setGmtCreated(new Date());
        projectCountry.setGmtUpdated(new Date());
        projectCountry.setCodeNumber("+86");
        projectCountry.setCountryName("中国");
        projectCountry.setMem("China");
        dataList.add(projectCountry);
        ProjectCountry projectCountry2 = new ProjectCountry();
        projectCountry2.setId(2L);
        projectCountry2.setGmtCreated(new Date());
        projectCountry2.setGmtUpdated(new Date());
        projectCountry2.setCodeNumber("+0987");
        projectCountry2.setCountryName("泰国");
        projectCountry2.setMem("Thai");
        dataList.add(projectCountry2);
        jsonResult.setData(dataList);
        System.out.println(new BaseController().toJson(jsonResult));
    }
}
