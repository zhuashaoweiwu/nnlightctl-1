package com.nnlightctl.request;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;


/**
 * 光照计信息
 */
public class PhotoperiodRequest extends BaseRequest{

    private Long id;

    @NotBlank(message = "设备编码不能为空")
    private String equipmentNumber;

    @NotBlank(message = "光照计的型号不能为空！")
    private String photoperiodModel;

    @NotBlank(message = "光照计的名字不能为空！")
    private String photoperiodName;

    @NotBlank(message = "关照计的通讯方式不能为空！")
    private String communicationMode;
    @NotNull(message = "调光方式不能为空")
    private Integer dimmingMode;

    private Double accuracy;

    private Double workVoltage;

    private String mem;

    private int deployFlag;

    private Long eleboxId;

    public Long getEleboxId() {
        return eleboxId;
    }

    public void setEleboxId(Long eleboxId) {
        this.eleboxId = eleboxId;
    }

    public int getDeployFlag() {
        return deployFlag;
    }

    public void setDeployFlag(int deployFlag) {
        this.deployFlag = deployFlag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhotoperiodModel() {
        return photoperiodModel;
    }

    public void setPhotoperiodModel(String photoperiodModel) {
        this.photoperiodModel = photoperiodModel;
    }

    public String getPhotoperiodName() {
        return photoperiodName;
    }

    public void setPhotoperiodName(String photoperiodName) {
        this.photoperiodName = photoperiodName;
    }

    public String getCommunicationMode() {
        return communicationMode;
    }

    public void setCommunicationMode(String communicationMode) {
        this.communicationMode = communicationMode;
    }

    public Integer getDimmingMode() {
        return dimmingMode;
    }

    public void setDimmingMode(Integer dimmingMode) {
        this.dimmingMode = dimmingMode;
    }

    public Double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Double accuracy) {
        this.accuracy = accuracy;
    }

    public Double getWorkVoltage() {
        return workVoltage;
    }

    public void setWorkVoltage(Double workVoltage) {
        this.workVoltage = workVoltage;
    }

    public String getMem() {
        return mem;
    }

    public void setMem(String mem) {
        this.mem = mem;
    }

    public String getEquipmentNumber() {
        return equipmentNumber;
    }

    public void setEquipmentNumber(String equipmentNumber) {
        this.equipmentNumber = equipmentNumber;
    }
}
