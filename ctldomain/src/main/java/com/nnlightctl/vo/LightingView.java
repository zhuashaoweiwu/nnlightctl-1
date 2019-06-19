package com.nnlightctl.vo;

import java.math.BigDecimal;
import java.util.Date;

public class LightingView extends BaseView {

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getLightingImei() {
        return lightingImei;
    }

    public void setLightingImei(String lightingImei) {
        this.lightingImei = lightingImei;
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

    public String getPropertySerialNumber() {
        return propertySerialNumber;
    }

    public void setPropertySerialNumber(String propertySerialNumber) {
        this.propertySerialNumber = propertySerialNumber;
    }

    public BigDecimal getDecay() {
        return decay;
    }

    public void setDecay(BigDecimal decay) {
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

    public Byte getLoopPriority() {
        return loopPriority;
    }

    public void setLoopPriority(Byte loopPriority) {
        this.loopPriority = loopPriority;
    }

    public Byte getFaultTag() {
        return faultTag;
    }

    public void setFaultTag(Byte faultTag) {
        this.faultTag = faultTag;
    }

    public String getRegionLevelDesc() {
        return regionLevelDesc;
    }

    public void setRegionLevelDesc(String regionLevelDesc) {
        this.regionLevelDesc = regionLevelDesc;
    }

    public String getLightingCode() {
        return lightingCode;
    }

    public void setLightingCode(String lightingCode) {
        this.lightingCode = lightingCode;
    }

    public Long getNnlightctlEleboxId() {
        return nnlightctlEleboxId;
    }

    public void setNnlightctlEleboxId(Long nnlightctlEleboxId) {
        this.nnlightctlEleboxId = nnlightctlEleboxId;
    }

    public Long getNnlightctlRegionId() {
        return nnlightctlRegionId;
    }

    public void setNnlightctlRegionId(Long nnlightctlRegionId) {
        this.nnlightctlRegionId = nnlightctlRegionId;
    }

    public Long getNnlightctlEleboxModelLoopId() {
        return nnlightctlEleboxModelLoopId;
    }

    public void setNnlightctlEleboxModelLoopId(Long nnlightctlEleboxModelLoopId) {
        this.nnlightctlEleboxModelLoopId = nnlightctlEleboxModelLoopId;
    }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }

    private Long nnlightctlEleboxModelLoopId;

    private Long nnlightctlEleboxId;

    private String lightingCode;

    private String uid;

    private String lightingImei;

    private Date manufacture;

    private Date useDate;

    private String lamppost;

    private String lamphead;

    private String propertySerialNumber;

    private BigDecimal decay;

    private Long maxUseTime;

    private String mem;

    private String longitude;

    private String latitude;

    private Byte loopPriority;

    private Byte faultTag;

    private String regionLevelDesc;

    private Long nnlightctlRegionId;

    private String modelType;

}
