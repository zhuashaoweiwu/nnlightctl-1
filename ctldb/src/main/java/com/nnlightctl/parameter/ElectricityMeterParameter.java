package com.nnlightctl.parameter;

public class ElectricityMeterParameter {

    private String electricityModel;

    private String electricityName;

    private String communityMode;

    private String measureMode;

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
}
