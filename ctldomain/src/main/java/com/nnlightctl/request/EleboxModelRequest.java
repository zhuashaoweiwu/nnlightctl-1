package com.nnlightctl.request;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

public class EleboxModelRequest {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public BigDecimal getPowerRating() {
        return powerRating;
    }

    public void setPowerRating(BigDecimal powerRating) {
        this.powerRating = powerRating;
    }

    public BigDecimal getElectricRating() {
        return electricRating;
    }

    public void setElectricRating(BigDecimal electricRating) {
        this.electricRating = electricRating;
    }

    public BigDecimal getVoltageRating() {
        return voltageRating;
    }

    public void setVoltageRating(BigDecimal voltageRating) {
        this.voltageRating = voltageRating;
    }

    public String getAirSwitchType() {
        return airSwitchType;
    }

    public void setAirSwitchType(String airSwitchType) {
        this.airSwitchType = airSwitchType;
    }

    public String getContactorType() {
        return contactorType;
    }

    public void setContactorType(String contactorType) {
        this.contactorType = contactorType;
    }

    public Byte getLoopCount() {
        return loopCount;
    }

    public void setLoopCount(Byte loopCount) {
        this.loopCount = loopCount;
    }

    public String getAc() {
        return ac;
    }

    public void setAc(String ac) {
        this.ac = ac;
    }

    public BigDecimal getLoopElectricity() {
        return loopElectricity;
    }

    public void setLoopElectricity(BigDecimal loopElectricity) {
        this.loopElectricity = loopElectricity;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<ModelLoopRequest> getModelLoopList() {
        return modelLoopList;
    }

    public void setModelLoopList(List<ModelLoopRequest> modelLoopList) {
        this.modelLoopList = modelLoopList;
    }

    public Long getNnlightctlEleboxId() {
        return nnlightctlEleboxId;
    }

    public void setNnlightctlEleboxId(Long nnlightctlEleboxId) {
        this.nnlightctlEleboxId = nnlightctlEleboxId;
    }

    private Long id;
    @NotEmpty(message = "唯一编码不能为空！")
    private String uid;
    @NotEmpty(message = "模块编码不可为空！")
    private String modelCode;
    @NotEmpty(message = "模块名称不能为空！")
    private String modelName;
    private BigDecimal powerRating;
    private BigDecimal electricRating;
    private BigDecimal voltageRating;
    private String airSwitchType;
    private String contactorType;
    @NotNull(message = "回路数量不能为空！")
    private Byte loopCount;
    private String ac;
    private BigDecimal loopElectricity;
    private List<ModelLoopRequest> modelLoopList;
    private Long nnlightctlEleboxId;
    private Integer count;
}
