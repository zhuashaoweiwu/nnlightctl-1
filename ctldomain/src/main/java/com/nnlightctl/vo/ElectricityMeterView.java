package com.nnlightctl.vo;

import java.io.Serializable;

public class ElectricityMeterView implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String electricityModel;

    private String electricityName;

    private String electricStandards;

    private String voltageTest;

    private Integer activeEnergy;

    private String installationMode;

    private String communityMode;

    private String measureMode;

    private String powerFactor;

    private String powerWaste;

    private String mem;

    private String equipmentNumber;

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getEquipmentNumber() {
        return equipmentNumber;
    }

    public void setEquipmentNumber(String equipmentNumber) {
        this.equipmentNumber = equipmentNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getElectricityModel() {
        return electricityModel;
    }

    public void setElectricityModel(String electricityModel) {
        this.electricityModel = electricityModel;
    }

    public String getElectricityName() {
        return electricityName;
    }

    public void setElectricityName(String electricityName) {
        this.electricityName = electricityName;
    }

    public String getElectricStandards() {
        return electricStandards;
    }

    public void setElectricStandards(String electricStandards) {
        this.electricStandards = electricStandards;
    }

    public String getVoltageTest() {
        return voltageTest;
    }

    public void setVoltageTest(String voltageTest) {
        this.voltageTest = voltageTest;
    }

    public Integer getActiveEnergy() {
        return activeEnergy;
    }

    public void setActiveEnergy(Integer activeEnergy) {
        this.activeEnergy = activeEnergy;
    }

    public String getInstallationMode() {
        return installationMode;
    }

    public void setInstallationMode(String installationMode) {
        this.installationMode = installationMode;
    }

    public String getCommunityMode() {
        return communityMode;
    }

    public void setCommunityMode(String communityMode) {
        this.communityMode = communityMode;
    }

    public String getMeasureMode() {
        return measureMode;
    }

    public void setMeasureMode(String measureMode) {
        this.measureMode = measureMode;
    }

    public String getPowerFactor() {
        return powerFactor;
    }

    public void setPowerFactor(String powerFactor) {
        this.powerFactor = powerFactor;
    }

    public String getPowerWaste() {
        return powerWaste;
    }

    public void setPowerWaste(String powerWaste) {
        this.powerWaste = powerWaste;
    }

    public String getMem() {
        return mem;
    }

    public void setMem(String mem) {
        this.mem = mem;
    }
}