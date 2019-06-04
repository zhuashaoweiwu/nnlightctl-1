package com.nnlightctl.po;

import java.io.Serializable;

public class LampController implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String centralizeModel;

    private String centralizeName;

    private String longitude;

    private String latitude;

    private String communicationMode;

    private String dimmingMode;

    private Double ratedVoltage;

    private Double ratedCurrent;

    private Double staticPower;

    private String alarmMessage;

    private String mem;

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public String getCommunicationMode() {
        return communicationMode;
    }

    public void setCommunicationMode(String communicationMode) {
        this.communicationMode = communicationMode;
    }

    public String getDimmingMode() {
        return dimmingMode;
    }

    public void setDimmingMode(String dimmingMode) {
        this.dimmingMode = dimmingMode;
    }

    public Double getRatedVoltage() {
        return ratedVoltage;
    }

    public void setRatedVoltage(Double ratedVoltage) {
        this.ratedVoltage = ratedVoltage;
    }

    public Double getRatedCurrent() {
        return ratedCurrent;
    }

    public void setRatedCurrent(Double ratedCurrent) {
        this.ratedCurrent = ratedCurrent;
    }

    public Double getStaticPower() {
        return staticPower;
    }

    public void setStaticPower(Double staticPower) {
        this.staticPower = staticPower;
    }

    public String getAlarmMessage() {
        return alarmMessage;
    }

    public void setAlarmMessage(String alarmMessage) {
        this.alarmMessage = alarmMessage;
    }

    public String getMem() {
        return mem;
    }

    public void setMem(String mem) {
        this.mem = mem;
    }
}
