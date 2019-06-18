package com.nnlightctl.request;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
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
    @NotBlank(message = "型号名称不能为空！")
    private String modelName;

    private BigDecimal ratedVoltage;

    private BigDecimal ratedElectric;

    private BigDecimal ratedPower;

    private Byte ledCount;

    private String mem;

    /**
     * 新添加字段
     */
    private String chip;

    private String beanAngle;

    private String controllerMode;

    private String grade;

    private int indexMode;

    private int flux;

    private String equipmentNumber;

    private String colorMode;

    public String getColorMode() {
        return colorMode;
    }

    public void setColorMode(String colorMode) {
        this.colorMode = colorMode;
    }

    public String getEquipmentNumber() {
        return equipmentNumber;
    }

    public void setEquipmentNumber(String equipmentNumber) {
        this.equipmentNumber = equipmentNumber;
    }

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public String getBeanAngle() {
        return beanAngle;
    }

    public void setBeanAngle(String beanAngle) {
        this.beanAngle = beanAngle;
    }

    public String getControllerMode() {
        return controllerMode;
    }

    public void setControllerMode(String controllerMode) {
        this.controllerMode = controllerMode;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }


    public int getFlux() {
        return flux;
    }

    public void setFlux(int flux) {
        this.flux = flux;
    }

    public int getIndexMode() {
        return indexMode;
    }

    public void setIndexMode(int indexMode) {
        this.indexMode = indexMode;
    }
}
