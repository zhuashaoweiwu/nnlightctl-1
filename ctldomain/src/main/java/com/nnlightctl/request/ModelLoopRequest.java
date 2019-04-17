package com.nnlightctl.request;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

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

    public BigDecimal getVoltage() {
        return voltage;
    }

    public void setVoltage(BigDecimal voltage) {
        this.voltage = voltage;
    }

    public BigDecimal getElectricity() {
        return electricity;
    }

    public void setElectricity(BigDecimal electricity) {
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
    @NotBlank(message = "回路编码不能为空！")
    private String loopCode;
    private BigDecimal voltage;
    private BigDecimal electricity;
    private Byte lightCount;
    private Byte state;
    private Long nnlightctlEleboxModelId;
}
