package com.nnlightctl.request;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
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

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Double getPowerRating() {
        return powerRating;
    }

    public void setPowerRating(Double powerRating) {
        this.powerRating = powerRating;
    }

    public Double getElectricRating() {
        return electricRating;
    }

    public void setElectricRating(Double electricRating) {
        this.electricRating = electricRating;
    }

    public Double getVoltageRating() {
        return voltageRating;
    }

    public void setVoltageRating(Double voltageRating) {
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

    public Double getLoopElectricity() {
        return loopElectricity;
    }

    public void setLoopElectricity(Double loopElectricity) {
        this.loopElectricity = loopElectricity;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
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
    @NotBlank(message = "唯一编码不能为空！")
    private String uid;
    @NotBlank(message = "模块名称不能为空！")
    private String modelName;
    private Double powerRating;
    private Double electricRating;
    private Double voltageRating;
    private String airSwitchType;
    private String contactorType;
    @NotNull(message = "回路数量不能为空！")
    private Byte loopCount;
    private String ac;
    private Double loopElectricity;
    private List<ModelLoopRequest> modelLoopList;
    private Long nnlightctlEleboxId;
    @NotNull(message = "数量不能为空！")
    private int count;
}
