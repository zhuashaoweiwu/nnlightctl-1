package com.nnlightctl.vo;


public class PhotoperiodView {

    private String photoperiodModel;

    private String photoperiodName;

    private String communicationMode;

    private Integer dimmingMode;

    private Double accuracy;

    private Double workVoltage;

    private String mem;

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
}