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

    public Integer getAutoModel() {
        return autoModel;
    }

    public void setAutoModel(Integer autoModel) {
        this.autoModel = autoModel;
    }

    public List<String> getLightUUIDs() {
        return lightUUIDs;
    }

    public void setLightUUIDs(List<String> lightUUIDs) {
        this.lightUUIDs = lightUUIDs;
    }

    public Integer getPowerType() {
        return powerType;
    }

    public void setPowerType(Integer powerType) {
        this.powerType = powerType;
    }

    public List<String> getModelUUIDs() {
        return modelUUIDs;
    }

    public void setModelUUIDs(List<String> modelUUIDs) {
        this.modelUUIDs = modelUUIDs;
    }

    public Short getModelLoopState() {
        return modelLoopState;
    }

    public void setModelLoopState(Short modelLoopState) {
        this.modelLoopState = modelLoopState;
    }

    public Short getModelLoop() {
        return modelLoop;
    }

    public void setModelLoop(Short modelLoop) {
        this.modelLoop = modelLoop;
    }

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public Long getLoopId() {
        return loopId;
    }

    public void setLoopId(Long loopId) {
        this.loopId = loopId;
    }

    public List<Long> getSceneIds() {
        return sceneIds;
    }

    public void setSceneIds(List<Long> sceneIds) {
        this.sceneIds = sceneIds;
    }

    public Long getUploadFirewareRecordId() {
        return uploadFirewareRecordId;
    }

    public void setUploadFirewareRecordId(Long uploadFirewareRecordId) {
        this.uploadFirewareRecordId = uploadFirewareRecordId;
    }


    private Long uploadFirewareRecordId;

    private List<Long> sceneIds;

    private Long loopId;

    private Long modelId;

    private Short modelLoopState;

    private Short modelLoop;

    private List<String> modelUUIDs;

    private Integer powerType;

    private List<String> lightUUIDs;

    private Integer autoModel;

    private List<Long> eleboxIds;

    private List<Long> lightIds;

    private Boolean terminalEleboxOn;

    private Integer terminalSendMsgPeriod;

    private int lightPercent;

    private String msg;
}
