package com.nnlightctl.request;

public class ModelLoopRequest {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoopCode() {
        return loopCode;
    }

    public void setLoopCode(String loopCode) {
        this.loopCode = loopCode;
    }

    public Double getVoltage() {
        return voltage;
    }

    public void setVoltage(Double voltage) {
        this.voltage = voltage;
    }

    public Double getElectricity() {
        return electricity;
    }

    public void setElectricity(Double electricity) {
        this.electricity = electricity;
    }

    public Byte getLightCount() {
        return lightCount;
    }

    public void setLightCount(Byte lightCount) {
        this.lightCount = lightCount;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Long getNnlightctlEleboxModelId() {
        return nnlightctlEleboxModelId;
    }

    public void setNnlightctlEleboxModelId(Long nnlightctlEleboxModelId) {
        this.nnlightctlEleboxModelId = nnlightctlEleboxModelId;
    }

    private Long id;
    private String loopCode;
    private Double voltage;
    private Double electricity;
    private Byte lightCount;
    private Byte state;
    private Long nnlightctlEleboxModelId;
}
