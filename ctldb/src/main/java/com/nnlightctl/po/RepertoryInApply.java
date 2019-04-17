package com.nnlightctl.po;

import java.io.Serializable;
import java.util.Date;

public class RepertoryInApply implements Serializable {
    private Long id;

    private Date gmtCreated;

    private Date gmtUpdated;

    private String serialnumber;

    private Date inRepertoryDate;

    private Long nnlightctlPropertyClassifyCatalogId;

    private Long nnlightctlSupplier;

    private String propertyName;

    private String propertyUid;

    private Long propertyCount;

    private Long nnlightctlRepertoryInReasonId;

    private Long nnlightctlRepertoryId;

    private Long nnlightctlUserApplyId;

    private Byte applyState;

    private String refuseReason;

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

    public String getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber == null ? null : serialnumber.trim();
    }

    public Date getInRepertoryDate() {
        return inRepertoryDate;
    }

    public void setInRepertoryDate(Date inRepertoryDate) {
        this.inRepertoryDate = inRepertoryDate;
    }

    public Long getNnlightctlPropertyClassifyCatalogId() {
        return nnlightctlPropertyClassifyCatalogId;
    }

    public void setNnlightctlPropertyClassifyCatalogId(Long nnlightctlPropertyClassifyCatalogId) {
        this.nnlightctlPropertyClassifyCatalogId = nnlightctlPropertyClassifyCatalogId;
    }

    public Long getNnlightctlSupplier() {
        return nnlightctlSupplier;
    }

    public void setNnlightctlSupplier(Long nnlightctlSupplier) {
        this.nnlightctlSupplier = nnlightctlSupplier;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName == null ? null : propertyName.trim();
    }

    public String getPropertyUid() {
        return propertyUid;
    }

    public void setPropertyUid(String propertyUid) {
        this.propertyUid = propertyUid == null ? null : propertyUid.trim();
    }

    public Long getPropertyCount() {
        return propertyCount;
    }

    public void setPropertyCount(Long propertyCount) {
        this.propertyCount = propertyCount;
    }

    public Long getNnlightctlRepertoryInReasonId() {
        return nnlightctlRepertoryInReasonId;
    }

    public void setNnlightctlRepertoryInReasonId(Long nnlightctlRepertoryInReasonId) {
        this.nnlightctlRepertoryInReasonId = nnlightctlRepertoryInReasonId;
    }

    public Long getNnlightctlRepertoryId() {
        return nnlightctlRepertoryId;
    }

    public void setNnlightctlRepertoryId(Long nnlightctlRepertoryId) {
        this.nnlightctlRepertoryId = nnlightctlRepertoryId;
    }

    public Long getNnlightctlUserApplyId() {
        return nnlightctlUserApplyId;
    }

    public void setNnlightctlUserApplyId(Long nnlightctlUserApplyId) {
        this.nnlightctlUserApplyId = nnlightctlUserApplyId;
    }

    public Byte getApplyState() {
        return applyState;
    }

    public void setApplyState(Byte applyState) {
        this.applyState = applyState;
    }

    public String getRefuseReason() {
        return refuseReason;
    }

    public void setRefuseReason(String refuseReason) {
        this.refuseReason = refuseReason == null ? null : refuseReason.trim();
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
        RepertoryInApply other = (RepertoryInApply) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGmtCreated() == null ? other.getGmtCreated() == null : this.getGmtCreated().equals(other.getGmtCreated()))
            && (this.getGmtUpdated() == null ? other.getGmtUpdated() == null : this.getGmtUpdated().equals(other.getGmtUpdated()))
            && (this.getSerialnumber() == null ? other.getSerialnumber() == null : this.getSerialnumber().equals(other.getSerialnumber()))
            && (this.getInRepertoryDate() == null ? other.getInRepertoryDate() == null : this.getInRepertoryDate().equals(other.getInRepertoryDate()))
            && (this.getNnlightctlPropertyClassifyCatalogId() == null ? other.getNnlightctlPropertyClassifyCatalogId() == null : this.getNnlightctlPropertyClassifyCatalogId().equals(other.getNnlightctlPropertyClassifyCatalogId()))
            && (this.getNnlightctlSupplier() == null ? other.getNnlightctlSupplier() == null : this.getNnlightctlSupplier().equals(other.getNnlightctlSupplier()))
            && (this.getPropertyName() == null ? other.getPropertyName() == null : this.getPropertyName().equals(other.getPropertyName()))
            && (this.getPropertyUid() == null ? other.getPropertyUid() == null : this.getPropertyUid().equals(other.getPropertyUid()))
            && (this.getPropertyCount() == null ? other.getPropertyCount() == null : this.getPropertyCount().equals(other.getPropertyCount()))
            && (this.getNnlightctlRepertoryInReasonId() == null ? other.getNnlightctlRepertoryInReasonId() == null : this.getNnlightctlRepertoryInReasonId().equals(other.getNnlightctlRepertoryInReasonId()))
            && (this.getNnlightctlRepertoryId() == null ? other.getNnlightctlRepertoryId() == null : this.getNnlightctlRepertoryId().equals(other.getNnlightctlRepertoryId()))
            && (this.getNnlightctlUserApplyId() == null ? other.getNnlightctlUserApplyId() == null : this.getNnlightctlUserApplyId().equals(other.getNnlightctlUserApplyId()))
            && (this.getApplyState() == null ? other.getApplyState() == null : this.getApplyState().equals(other.getApplyState()))
            && (this.getRefuseReason() == null ? other.getRefuseReason() == null : this.getRefuseReason().equals(other.getRefuseReason()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGmtCreated() == null) ? 0 : getGmtCreated().hashCode());
        result = prime * result + ((getGmtUpdated() == null) ? 0 : getGmtUpdated().hashCode());
        result = prime * result + ((getSerialnumber() == null) ? 0 : getSerialnumber().hashCode());
        result = prime * result + ((getInRepertoryDate() == null) ? 0 : getInRepertoryDate().hashCode());
        result = prime * result + ((getNnlightctlPropertyClassifyCatalogId() == null) ? 0 : getNnlightctlPropertyClassifyCatalogId().hashCode());
        result = prime * result + ((getNnlightctlSupplier() == null) ? 0 : getNnlightctlSupplier().hashCode());
        result = prime * result + ((getPropertyName() == null) ? 0 : getPropertyName().hashCode());
        result = prime * result + ((getPropertyUid() == null) ? 0 : getPropertyUid().hashCode());
        result = prime * result + ((getPropertyCount() == null) ? 0 : getPropertyCount().hashCode());
        result = prime * result + ((getNnlightctlRepertoryInReasonId() == null) ? 0 : getNnlightctlRepertoryInReasonId().hashCode());
        result = prime * result + ((getNnlightctlRepertoryId() == null) ? 0 : getNnlightctlRepertoryId().hashCode());
        result = prime * result + ((getNnlightctlUserApplyId() == null) ? 0 : getNnlightctlUserApplyId().hashCode());
        result = prime * result + ((getApplyState() == null) ? 0 : getApplyState().hashCode());
        result = prime * result + ((getRefuseReason() == null) ? 0 : getRefuseReason().hashCode());
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
        sb.append(", serialnumber=").append(serialnumber);
        sb.append(", inRepertoryDate=").append(inRepertoryDate);
        sb.append(", nnlightctlPropertyClassifyCatalogId=").append(nnlightctlPropertyClassifyCatalogId);
        sb.append(", nnlightctlSupplier=").append(nnlightctlSupplier);
        sb.append(", propertyName=").append(propertyName);
        sb.append(", propertyUid=").append(propertyUid);
        sb.append(", propertyCount=").append(propertyCount);
        sb.append(", nnlightctlRepertoryInReasonId=").append(nnlightctlRepertoryInReasonId);
        sb.append(", nnlightctlRepertoryId=").append(nnlightctlRepertoryId);
        sb.append(", nnlightctlUserApplyId=").append(nnlightctlUserApplyId);
        sb.append(", applyState=").append(applyState);
        sb.append(", refuseReason=").append(refuseReason);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}