package com.nnlightctl.request;

public class CommandRequest {
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getLightPercent() {
        return lightPercent;
    }

    public void setLightPercent(int lightPercent) {
        this.lightPercent = lightPercent;
    }

    private int lightPercent;

    private String msg;
}