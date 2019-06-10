package com.nnlightctl.parameter;

public class LampControllerParameter {

    private String lampModel;

    private String lampName;

    private String longitude;

    private String latitude;

    private String communicationMode;

    private Integer dimmingMode;

    public String getLampModel() {
        return lampModel;
    }

    public void setLampModel(String lampModel) {
        this.lampModel = lampModel;
    }

    public String getLampName() {
        return lampName;
    }

    public void setLampName(String lampName) {
        this.lampName = lampName;
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
}
