package com.nnlightctl.request;

import java.util.List;

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

    public Integer getTerminalSendMsgPeriod() {
        return terminalSendMsgPeriod;
    }

    public void setTerminalSendMsgPeriod(Integer terminalSendMsgPeriod) {
        this.terminalSendMsgPeriod = terminalSendMsgPeriod;
    }

    public Boolean getTerminalEleboxOn() {
        return terminalEleboxOn;
    }

    public void setTerminalEleboxOn(Boolean terminalEleboxOn) {
        this.terminalEleboxOn = terminalEleboxOn;
    }


    public List<Long> getEleboxIds() {
        return eleboxIds;
    }

    public void setEleboxIds(List<Long> eleboxIds) {
        this.eleboxIds = eleboxIds;
    }

    public List<Long> getLightIds() {
        return lightIds;
    }

    public void setLightIds(List<Long> lightIds) {
        this.lightIds = lightIds;
    }

    private List<Long> eleboxIds;

    private List<Long> lightIds;

    private Boolean terminalEleboxOn;

    private Integer terminalSendMsgPeriod;

    private int lightPercent;

    private String msg;
}
