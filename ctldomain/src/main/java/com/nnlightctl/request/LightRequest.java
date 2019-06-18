package com.nnlightctl.request;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class LightRequest {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getLightingCode() {
        return lightingCode;
    }

    public void setLightingCode(String lightingCode) {
        this.lightingCode = lightingCode;
    }

    public Date getManufacture() {
        return manufacture;
    }

    public void setManufacture(Date manufacture) {
        this.manufacture = manufacture;
    }

    public Date getUseDate() {
        return useDate;
    }

    public void setUseDate(Date useDate) {
        this.useDate = useDate;
    }

    public String getLamppost() {
        return lamppost;
    }

    public void setLamppost(String lamppost) {
        this.lamppost = lamppost;
    }

    public String getLamphead() {
        return lamphead;
    }

    public void setLamphead(String lamphead) {
        this.lamphead = lamphead;
    }

    public Long getNnlightctlLightingModelId() {
        return nnlightctlLightingModelId;
    }

    public void setNnlightctlLightingModelId(Long nnlightctlLightingModelId) {
        this.nnlightctlLightingModelId = nnlightctlLightingModelId;
    }

    public Long getNnlightctlLightingGisId() {
        return nnlightctlLightingGisId;
    }

    public void setNnlightctlLightingGisId(Long nnlightctlLightingGisId) {
        this.nnlightctlLightingGisId = nnlightctlLightingGisId;
    }

    public String getPropertySerialNumber() {
        return propertySerialNumber;
    }

    public void setPropertySerialNumber(String propertySerialNumber) {
        this.propertySerialNumber = propertySerialNumber;
    }

    public String getDecay() {
        return decay;
    }

    public void setDecay(String decay) {
        this.decay = decay;
    }

    public Long getMaxUseTime() {
        return maxUseTime;
    }

    public void setMaxUseTime(Long maxUseTime) {
        this.maxUseTime = maxUseTime;
    }

    public String getMem() {
        return mem;
    }

    public void setMem(String mem) {
        this.mem = mem;
    }

    public Long getNnlightctlProjectId() {
        return nnlightctlProjectId;
    }

    public void setNnlightctlProjectId(Long nnlightctlProjectId) {
        this.nnlightctlProjectId = nnlightctlProjectId;
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

    public Long getNnlightctlRegionId() {
        return nnlightctlRegionId;
    }

    public void setNnlightctlRegionId(Long nnlightctlRegionId) {
        this.nnlightctlRegionId = nnlightctlRegionId;
    }

    private Long id;
    private String uid;
    //@NotEmpty(message = "灯具唯一编码不能为空！")
    private String lightingCode;
    private Date manufacture;
    private Date useDate;
    //@NotEmpty(message = "灯杆不能为空！")
    private String lamppost;
    //@NotEmpty(message = "灯头号不能为空！")
    private String lamphead;
    private Long nnlightctlLightingModelId;
    private Long nnlightctlLightingGisId;
    private String propertySerialNumber;
    private String decay;
    private Long maxUseTime;
    private String mem;
    //@NotNull(message = "灯具必须选择所属项目")
    private Long nnlightctlProjectId;
    private String longitude;
    private String latitude;
    private Long nnlightctlRegionId;

    /**
     * 新添加字段
     */

    private String communicationMode;

    private Integer dimmingMode;

    private Double ratedVoltage;

    private Double ratedCurrent;

    private Double staticPower;

    private String alarmMessage;

    private String lampMode;

    private String lampName;

    /**
     * 灯具的外键iid
     */
    private Long nnlightctlLightModelId;

    /**
     * 灯头的外键id
     */
    private Long nnlightctlLamppostId;

    /**
     * 单灯控制器的外键id
     */
    private Long nnlightctlLampControllerIds;

    public Long getNnlightctlLampControllerIds() {
        return nnlightctlLampControllerIds;
    }

    public void setNnlightctlLampControllerIds(Long nnlightctlLampControllerIds) {
        this.nnlightctlLampControllerIds = nnlightctlLampControllerIds;
    }



    public Long getNnlightctlLightModelId() {
        return nnlightctlLightModelId;
    }

    public void setNnlightctlLightModelId(Long nnlightctlLightModelId) {
        this.nnlightctlLightModelId = nnlightctlLightModelId;
    }

    public Long getNnlightctlLamppostId() {
        return nnlightctlLamppostId;
    }

    public void setNnlightctlLamppostId(Long nnlightctlLamppostId) {
        this.nnlightctlLamppostId = nnlightctlLamppostId;
    }


    public String getLampMode() {
        return lampMode;
    }

    public void setLampMode(String lampMode) {
        this.lampMode = lampMode;
    }

    public String getLampName() {
        return lampName;
    }

    public void setLampName(String lampName) {
        this.lampName = lampName;
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

    public static class BatchLightRequest {
        public List<LightRequest> getAddLightings() {
            return addLightings;
        }

        public void setAddLightings(List<LightRequest> addLightings) {
            this.addLightings = addLightings;
        }

        private List<LightRequest> addLightings;
    }
}
