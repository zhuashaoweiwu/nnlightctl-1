package com.nnlightctl.request;

import java.math.BigDecimal;

public class LightModelRequest {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public BigDecimal getRatedVoltage() {
        return ratedVoltage;
    }

    public void setRatedVoltage(BigDecimal ratedVoltage) {
        this.ratedVoltage = ratedVoltage;
    }

    public BigDecimal getRatedElectric() {
        return ratedElectric;
    }

    public void setRatedElectric(BigDecimal ratedElectric) {
        this.ratedElectric = ratedElectric;
    }

    public BigDecimal getRatedPower() {
        return ratedPower;
    }

    public void setRatedPower(BigDecimal ratedPower) {
        this.ratedPower = ratedPower;
    }

    public Byte getLedCount() {
        return ledCount;
    }

    public void setLedCount(Byte ledCount) {
        this.ledCount = ledCount;
    }

    public String getMem() {
        return mem;
    }

    public void setMem(String mem) {
        this.mem = mem;
    }

    private Long id;

    private String modelName;

    private BigDecimal ratedVoltage;

    private BigDecimal ratedElectric;

    private BigDecimal ratedPower;

    private Byte ledCount;

    private String mem;
}
