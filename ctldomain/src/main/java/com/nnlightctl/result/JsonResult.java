package com.nnlightctl.result;

import java.util.List;

public class JsonResult {
    public static JsonResult SUCCESS = new JsonResult("1000", "成功");
    public static JsonResult FAILURE = new JsonResult("1001", "失败");

    public JsonResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static JsonResult getSUCCESS() {
        SUCCESS.setData(null);
        return SUCCESS;
    }

    public static JsonResult getFAILURE() {
        FAILURE.setData(null);
        return FAILURE;
    }

    public JsonResult() {}

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    private String code;
    private String msg;
    private List<?> data;
}
