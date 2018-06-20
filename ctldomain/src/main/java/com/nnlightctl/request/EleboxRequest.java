package com.nnlightctl.request;

import java.math.BigDecimal;
import java.util.Date;

public class EleboxRequest {
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

    public String getCodeNumber() {
        return codeNumber;
    }

    public void setCodeNumber(String codeNumber) {
        this.codeNumber = codeNumber;
    }

    public Date getManufacture() {
        return manufacture;
    }

    public void setManufacture(Date manufacture) {
        this.manufacture = manufacture;
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

    public Date getUseDate() {
        return useDate;
    }

    public void setUseDate(Date useDate) {
        this.useDate = useDate;
    }

    public BigDecimal getRatedVoltage() {
        return ratedVoltage;
    }

    public void setRatedVoltage(BigDecimal ratedVoltage) {
        this.ratedVoltage = ratedVoltage;
    }

    public BigDecimal getRatedElectricty() {
        return ratedElectricty;
    }

    public void setRatedElectricty(BigDecimal ratedElectricty) {
        this.ratedElectricty = ratedElectricty;
    }

    public BigDecimal getPowerRating() {
        return powerRating;
    }

    public void setPowerRating(BigDecimal powerRating) {
        this.powerRating = powerRating;
    }

    public Long getMaxUseTime() {
        return maxUseTime;
    }

    public void setMaxUseTime(Long maxUseTime) {
        this.maxUseTime = maxUseTime;
    }

    public String getSpd() {
        return spd;
    }

    public void setSpd(String spd) {
        this.spd = spd;
    }

    public String getMainSwitch() {
        return mainSwitch;
    }

    public void setMainSwitch(String mainSwitch) {
        this.mainSwitch = mainSwitch;
    }

    public Long getNnlightctlEleboxGisId() {
        return nnlightctlEleboxGisId;
    }

    public void setNnlightctlEleboxGisId(Long nnlightctlEleboxGisId) {
        this.nnlightctlEleboxGisId = nnlightctlEleboxGisId;
    }

    public Long getNnlightctlRegionId() {
        return nnlightctlRegionId;
    }

    public void setNnlightctlRegionId(Long nnlightctlRegionId) {
        this.nnlightctlRegionId = nnlightctlRegionId;
    }

    public Long getNnlightctlProjectId() {
        return nnlightctlProjectId;
    }

    public void setNnlightctlProjectId(Long nnlightctlProjectId) {
        this.nnlightctlProjectId = nnlightctlProjectId;
    }

    private Long id;
    private String uid;
    private String codeNumber;
    private Date manufacture;
    private String longitude;
    private String latitude;
    private Date useDate;
    private BigDecimal ratedVoltage;
    private BigDecimal ratedElectricty;
    private BigDecimal powerRating;
    private Long maxUseTime;
    private String spd;
    private String mainSwitch;
    private Long nnlightctlEleboxGisId;
    private Long nnlightctlRegionId;
    private Long nnlightctlProjectId;
}
