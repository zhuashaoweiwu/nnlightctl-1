package com.nnlightctl.result;

import java.util.List;

public class JsonResult {
    public static JsonResult SUCCESS = new JsonResult("1000", "成功");
    public static JsonResult FAILURE = new JsonResult("1001", "失败");
    //通过id查询或者删除
    public static  JsonResult FALLURE_IDS_NULL=new JsonResult("4001","传入id为空");

    public static JsonResult FALLURE_IDS_CODEERROR=new JsonResult("4002","传入的id有误");

    //校验是否传递当前页，和每页显示多少条
    public static JsonResult FALLURE_NOPAGE=new JsonResult("4101","没有传入页码");

    //校验查询参数
    public static JsonResult FALLURE_PARAMSERROR=new JsonResult("4102","您查询的条件有误");





    public JsonResult(String code, String msg) {
        this();
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

    public JsonResult() {this.total = -1;}

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

    private Integer total;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    private String code;
    private String msg;
    private List<?> data;
}
