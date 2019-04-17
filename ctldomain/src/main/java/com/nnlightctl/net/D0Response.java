package com.nnlightctl.net;

import com.nnlightctl.util.BytesHexStrTranslate;

public class D0Response {
    public byte[] getUuid() {
        return uuid;
    }

    public void setUuid(byte[] uuid) {
        this.uuid = uuid;
        setUuidDesc(new String(uuid));
    }

    public byte[] getModelState() {
        return modelState;
    }

    public void setModelState(byte[] modelState) {
        this.modelState = modelState;
        setModelStateDesc(BytesHexStrTranslate.bytesToHexFun(modelState));
    }

    public byte[] getModelPowerState() {
        return modelPowerState;
    }

    public void setModelPowerState(byte[] modelPowerState) {
        this.modelPowerState = modelPowerState;
        setModelPowerstateDesc(BytesHexStrTranslate.bytesToHexFun(modelPowerState));
    }

    public byte[] getTime() {
        return time;
    }

    public void setTime(byte[] time) {
        this.time = time;
    }

    public String getModelStateDesc() {
        return modelStateDesc;
    }

    public void setModelStateDesc(String modelStateDesc) {
        this.modelStateDesc = modelStateDesc;
    }

    public String getUuidDesc() {
        return uuidDesc;
    }

    public void setUuidDesc(String uuidDesc) {
        this.uuidDesc = uuidDesc;
    }

    public String getModelPowerstateDesc() {
        return modelPowerstateDesc;
    }

    public void setModelPowerstateDesc(String modelPowerstateDesc) {
        this.modelPowerstateDesc = modelPowerstateDesc;
    }


    private String modelPowerstateDesc;
    private String modelStateDesc;
    private String uuidDesc;
    private byte[] uuid = new byte[36];
    private byte[] modelState = new byte[2];
    private byte[] modelPowerState = new byte[2];
    private byte[] time = new byte[3];
}
