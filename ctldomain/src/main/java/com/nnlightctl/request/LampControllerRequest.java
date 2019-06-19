package com.nnlightctl.request;


public class LampControllerRequest {

    private Long id;

    private String lampName;

    private String lampModel;

    private String longitude;

    private String latitude;

    private String communicationMode;

    private Integer dimmingMode;

    private Double ratedVoltage;

    private Double ratedCurrent;

    private Double staticPower;

    private String alarmMessage;

    private String mem;

    private String equipmentNumber;

    /**
     * 灯具的外键id
     */
    private Long nnlightctlLampModelId;

    /**
     * 灯头的外键id
     */
    private Long nnlightctlLamppostId;

    /**
     *
     * 所属项目id
     */
    private Long nnlightctlProjectId;


    public Long getNnlightctlLampModelId() {
        return nnlightctlLampModelId;
    }

    public void setNnlightctlLampModelId(Long nnlightctlLampModelId) {
        this.nnlightctlLampModelId = nnlightctlLampModelId;
    }

    public Long getNnlightctlLamppostId() {
        return nnlightctlLamppostId;
    }

    public void setNnlightctlLamppostId(Long nnlightctlLamppostId) {
        this.nnlightctlLamppostId = nnlightctlLamppostId;
    }

    public Long getNnlightctlProjectId() {
        return nnlightctlProjectId;
    }

    public void setNnlightctlProjectId(Long nnlightctlProjectId) {
        this.nnlightctlProjectId = nnlightctlProjectId;
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

    public String getLampName() {
        return lampName;
    }

    public void setLampName(String lampName) {
        this.lampName = lampName;
    }

    public String getLampModel() {
        return lampModel;
    }

    public void setLampModel(String lampModel) {
        this.lampModel = lampModel;
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
