package com.common.Result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class JsonResult {

    private int total;

    private String  code;

    private String msg;

    private List<?> data;

    public static final JsonResult SUCCESS_CODE=new JsonResult("1000","数据获取成功");

    public static final JsonResult FAILURE_CODE=new JsonResult("1001","数据获取失败");

    public JsonResult(String code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public static JsonResult getSuccess() {
        SUCCESS_CODE.setData(null);
        return SUCCESS_CODE;
    }

    public static JsonResult getFailure() {
        FAILURE_CODE.setData(null);
        return FAILURE_CODE;
    }
}
