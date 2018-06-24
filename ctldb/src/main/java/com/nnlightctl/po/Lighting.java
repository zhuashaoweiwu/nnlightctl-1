package com.nnlightctl.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Lighting implements Serializable {
    private Long id;

    private Date gmtCreated;

    private Date gmtUpdated;

    private String uid;

    private Date manufacture;

    private Date useDate;

    private String lamppost;

    private String lamphead;

    private Long nnlightctlLightingModelId;

    private Long nnlightctlLightingGisId;

    private String propertySerialNumber;

    private BigDecimal decay;

    private Long maxUseTime;

    private String mem;

    private Long nnlightctlEleboxModelLoopId;

    private Long nnlightctlRegionId;

    private Long nnlightctlProjectId;

    private Long nnlightctlEleboxId;

    private Byte loopPriority;

    private Byte faultTag;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public Date getGmtUpdated() {
        return gmtUpdated;
    }

    public void setGmtUpdated(Date gmtUpdated) {
        this.gmtUpdated = gmtUpdated;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
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
        this.lamppost = lamppost == null ? null : lamppost.trim();
    }

    public String getLamphead() {
        return lamphead;
    }

    public void setLamphead(String lamphead) {
        this.lamphead = lamphead == null ? null : lamphead.trim();
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
        this.propertySerialNumber = propertySerialNumber == null ? null : propertySerialNumber.trim();
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
        this.mem = mem == null ? null : mem.trim();
    }

    public Long getNnlightctlEleboxModelLoopId() {
        return nnlightctlEleboxModelLoopId;
    }

    public void setNnlightctlEleboxModelLoopId(Long nnlightctlEleboxModelLoopId) {
        this.nnlightctlEleboxModelLoopId = nnlightctlEleboxModelLoopId;
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

    public Long getNnlightctlEleboxId() {
        return nnlightctlEleboxId;
    }

    public void setNnlightctlEleboxId(Long nnlightctlEleboxId) {
        this.nnlightctlEleboxId = nnlightctlEleboxId;
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

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Lighting other = (Lighting) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGmtCreated() == null ? other.getGmtCreated() == null : this.getGmtCreated().equals(other.getGmtCreated()))
            && (this.getGmtUpdated() == null ? other.getGmtUpdated() == null : this.getGmtUpdated().equals(other.getGmtUpdated()))
            && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getManufacture() == null ? other.getManufacture() == null : this.getManufacture().equals(other.getManufacture()))
            && (this.getUseDate() == null ? other.getUseDate() == null : this.getUseDate().equals(other.getUseDate()))
            && (this.getLamppost() == null ? other.getLamppost() == null : this.getLamppost().equals(other.getLamppost()))
            && (this.getLamphead() == null ? other.getLamphead() == null : this.getLamphead().equals(other.getLamphead()))
            && (this.getNnlightctlLightingModelId() == null ? other.getNnlightctlLightingModelId() == null : this.getNnlightctlLightingModelId().equals(other.getNnlightctlLightingModelId()))
            && (this.getNnlightctlLightingGisId() == null ? other.getNnlightctlLightingGisId() == null : this.getNnlightctlLightingGisId().equals(other.getNnlightctlLightingGisId()))
            && (this.getPropertySerialNumber() == null ? other.getPropertySerialNumber() == null : this.getPropertySerialNumber().equals(other.getPropertySerialNumber()))
            && (this.getDecay() == null ? other.getDecay() == null : this.getDecay().equals(other.getDecay()))
            && (this.getMaxUseTime() == null ? other.getMaxUseTime() == null : this.getMaxUseTime().equals(other.getMaxUseTime()))
            && (this.getMem() == null ? other.getMem() == null : this.getMem().equals(other.getMem()))
            && (this.getNnlightctlEleboxModelLoopId() == null ? other.getNnlightctlEleboxModelLoopId() == null : this.getNnlightctlEleboxModelLoopId().equals(other.getNnlightctlEleboxModelLoopId()))
            && (this.getNnlightctlRegionId() == null ? other.getNnlightctlRegionId() == null : this.getNnlightctlRegionId().equals(other.getNnlightctlRegionId()))
            && (this.getNnlightctlProjectId() == null ? other.getNnlightctlProjectId() == null : this.getNnlightctlProjectId().equals(other.getNnlightctlProjectId()))
            && (this.getNnlightctlEleboxId() == null ? other.getNnlightctlEleboxId() == null : this.getNnlightctlEleboxId().equals(other.getNnlightctlEleboxId()))
            && (this.getLoopPriority() == null ? other.getLoopPriority() == null : this.getLoopPriority().equals(other.getLoopPriority()))
            && (this.getFaultTag() == null ? other.getFaultTag() == null : this.getFaultTag().equals(other.getFaultTag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGmtCreated() == null) ? 0 : getGmtCreated().hashCode());
        result = prime * result + ((getGmtUpdated() == null) ? 0 : getGmtUpdated().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getManufacture() == null) ? 0 : getManufacture().hashCode());
        result = prime * result + ((getUseDate() == null) ? 0 : getUseDate().hashCode());
        result = prime * result + ((getLamppost() == null) ? 0 : getLamppost().hashCode());
        result = prime * result + ((getLamphead() == null) ? 0 : getLamphead().hashCode());
        result = prime * result + ((getNnlightctlLightingModelId() == null) ? 0 : getNnlightctlLightingModelId().hashCode());
        result = prime * result + ((getNnlightctlLightingGisId() == null) ? 0 : getNnlightctlLightingGisId().hashCode());
        result = prime * result + ((getPropertySerialNumber() == null) ? 0 : getPropertySerialNumber().hashCode());
        result = prime * result + ((getDecay() == null) ? 0 : getDecay().hashCode());
        result = prime * result + ((getMaxUseTime() == null) ? 0 : getMaxUseTime().hashCode());
        result = prime * result + ((getMem() == null) ? 0 : getMem().hashCode());
        result = prime * result + ((getNnlightctlEleboxModelLoopId() == null) ? 0 : getNnlightctlEleboxModelLoopId().hashCode());
        result = prime * result + ((getNnlightctlRegionId() == null) ? 0 : getNnlightctlRegionId().hashCode());
        result = prime * result + ((getNnlightctlProjectId() == null) ? 0 : getNnlightctlProjectId().hashCode());
        result = prime * result + ((getNnlightctlEleboxId() == null) ? 0 : getNnlightctlEleboxId().hashCode());
        result = prime * result + ((getLoopPriority() == null) ? 0 : getLoopPriority().hashCode());
        result = prime * result + ((getFaultTag() == null) ? 0 : getFaultTag().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", gmtCreated=").append(gmtCreated);
        sb.append(", gmtUpdated=").append(gmtUpdated);
        sb.append(", uid=").append(uid);
        sb.append(", manufacture=").append(manufacture);
        sb.append(", useDate=").append(useDate);
        sb.append(", lamppost=").append(lamppost);
        sb.append(", lamphead=").append(lamphead);
        sb.append(", nnlightctlLightingModelId=").append(nnlightctlLightingModelId);
        sb.append(", nnlightctlLightingGisId=").append(nnlightctlLightingGisId);
        sb.append(", propertySerialNumber=").append(propertySerialNumber);
        sb.append(", decay=").append(decay);
        sb.append(", maxUseTime=").append(maxUseTime);
        sb.append(", mem=").append(mem);
        sb.append(", nnlightctlEleboxModelLoopId=").append(nnlightctlEleboxModelLoopId);
        sb.append(", nnlightctlRegionId=").append(nnlightctlRegionId);
        sb.append(", nnlightctlProjectId=").append(nnlightctlProjectId);
        sb.append(", nnlightctlEleboxId=").append(nnlightctlEleboxId);
        sb.append(", loopPriority=").append(loopPriority);
        sb.append(", faultTag=").append(faultTag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}