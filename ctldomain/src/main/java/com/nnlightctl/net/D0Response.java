package com.nnlightctl.net;

public class D0Response {
    public byte[] getUuid() {
        return uuid;
    }

    public void setUuid(byte[] uuid) {
        this.uuid = uuid;
    }

    public byte[] getModelState() {
        return modelState;
    }

    public void setModelState(byte[] modelState) {
        this.modelState = modelState;
    }

    public byte[] getModelPowerState() {
        return modelPowerState;
    }

    public void setModelPowerState(byte[] modelPowerState) {
        this.modelPowerState = modelPowerState;
    }

    public byte[] getTime() {
        return time;
    }

    public void setTime(byte[] time) {
        this.time = time;
    }

    private byte[] uuid = new byte[36];
    private byte[] modelState = new byte[2];
    private byte[] modelPowerState = new byte[2];
    private byte[] time = new byte[3];
}
