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

    private Boolean terminalEleboxOn;

    private Integer terminalSendMsgPeriod;

    private int lightPercent;

    private String msg;
}
