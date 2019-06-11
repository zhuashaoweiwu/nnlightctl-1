package com.nnlightctl.request;

import java.util.List;

public class ElectricityMeterConditionRequest extends BaseRequest{

    private List<Long> electricityMeterIds;

    private Long id;

    private String electricityModel;

    private String electricityName;

    private String communityMode;

    private String measureMode;

    private String equipmentNumber;

    public String getEquipmentNumber() {
        return equipmentNumber;
    }

    public void setEquipmentNumber(String equipmentNumber) {
        this.equipmentNumber = equipmentNumber;
    }

    public List<Long> getElectricityMeterIds() {
        return electricityMeterIds;
    }

    public void setElectricityMeterIds(List<Long> electricityMeterIds) {
        this.electricityMeterIds = electricityMeterIds;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
