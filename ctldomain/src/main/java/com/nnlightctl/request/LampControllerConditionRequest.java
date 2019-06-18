package com.nnlightctl.request;


import java.util.List;

public class LampControllerConditionRequest extends BaseRequest{

    private List<Long> lampControllerIds;

    private String lampModel;

    private String lampName;

    private Long id;

    private String longtitude;

    private String latitude;

    private String communicationMode;

    private Integer dimmingMode;

    private String equipmentNumber;

    public String getEquipmentNumber() {
        return equipmentNumber;
    }

    public void setEquipmentNumber(String equipmentNumber) {
        this.equipmentNumber = equipmentNumber;
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(String longtitude) {
        this.longtitude = longtitude;
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

    public List<Long> getLampControllerIds() {
        return lampControllerIds;
    }

    public void setLampControllerIds(List<Long> lampControllerIds) {
        this.lampControllerIds = lampControllerIds;
    }


}
