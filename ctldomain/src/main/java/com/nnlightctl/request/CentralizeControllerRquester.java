package com.nnlightctl.request;

import org.hibernate.validator.constraints.NotBlank;

public class CentralizeControllerRquester {

    private Long id;

    @NotBlank(message = "集中控制器的型号不能为空")
    private String centralizeModel;

    @NotBlank(message = "集中控制器的名字不能为空")
    private String centralizeName;

    @NotBlank(message = "经度不能为空")
    private String longitude;

    @NotBlank(message = "纬度不能为空")
    private String latitude;

    private Long doChannel;

    private Long diChannel;

    private Long switchChannel;

    private Long voltageChannel;

    private Long electricChannel;

    private Long testChannel;

    private int upChannel;

    private int downChannel;

    private String mem;

    @NotBlank(message = "设备编码不能为空")
    private String equipmentNumber;

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

    public String getCentralizeModel() {
        return centralizeModel;
    }

    public void setCentralizeModel(String centralizeModel) {
        this.centralizeModel = centralizeModel;
    }

    public String getCentralizeName() {
        return centralizeName;
    }

    public void setCentralizeName(String centralizeName) {
        this.centralizeName = centralizeName;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Long getDoChannel() {
        return doChannel;
    }

    public void setDoChannel(Long doChannel) {
        this.doChannel = doChannel;
    }

    public Long getDiChannel() {
        return diChannel;
    }

    public void setDiChannel(Long diChannel) {
        this.diChannel = diChannel;
    }

    public Long getSwitchChannel() {
        return switchChannel;
    }

    public void setSwitchChannel(Long switchChannel) {
        this.switchChannel = switchChannel;
    }

    public Long getVoltageChannel() {
        return voltageChannel;
    }

    public void setVoltageChannel(Long voltageChannel) {
        this.voltageChannel = voltageChannel;
    }

    public Long getElectricChannel() {
        return electricChannel;
    }

    public void setElectricChannel(Long electricChannel) {
        this.electricChannel = electricChannel;
    }

    public Long getTestChannel() {
        return testChannel;
    }

    public void setTestChannel(Long testChannel) {
        this.testChannel = testChannel;
    }

    public int getUpChannel() {
        return upChannel;
    }

    public void setUpChannel(int upChannel) {
        this.upChannel = upChannel;
    }

    public int getDownChannel() {
        return downChannel;
    }

    public void setDownChannel(int downChannel) {
        this.downChannel = downChannel;
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
