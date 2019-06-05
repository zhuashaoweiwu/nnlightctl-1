package com.Controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.common.Result.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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

        //total数据总数
        body.put("total", jsonResult.getTotal());

        jsonObject.put("body", body);

        return jsonObject.toJSONString();
    }

    @ExceptionHandler(RuntimeException.class)
    public void caughtException(RuntimeException exception, HttpServletResponse response) {
        JsonResult jsonResult = JsonResult.getFailure();
        jsonResult.setMsg(exception.getMessage());

        response.setContentType("application/json;charset=UTF-8");

        try (PrintWriter printWriter = response.getWriter()) {
            printWriter.write(toJson(jsonResult));
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
