package com.nnlightctl.po;

import java.io.Serializable;
import java.util.Date;

public class RepairRecord implements Serializable {
    private Long id;

    private Date gmtCreated;

    private Date gmtUpdated;

    private Long nnlightctlEleboxId;

    private Long nnlightctlPropertyClassifyCatalogId;

    private String propertyName;

    private Long propertyCount;

    private Date faultDate;

    private Date createDate;

    private Long nnlightctlUserId;

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

    public Long getNnlightctlEleboxId() {
        return nnlightctlEleboxId;
    }

    public void setNnlightctlEleboxId(Long nnlightctlEleboxId) {
        this.nnlightctlEleboxId = nnlightctlEleboxId;
    }

    public Long getNnlightctlPropertyClassifyCatalogId() {
        return nnlightctlPropertyClassifyCatalogId;
    }

    public void setNnlightctlPropertyClassifyCatalogId(Long nnlightctlPropertyClassifyCatalogId) {
        this.nnlightctlPropertyClassifyCatalogId = nnlightctlPropertyClassifyCatalogId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName == null ? null : propertyName.trim();
    }

    public Long getPropertyCount() {
        return propertyCount;
    }

    public void setPropertyCount(Long propertyCount) {
        this.propertyCount = propertyCount;
    }

    public Date getFaultDate() {
        return faultDate;
    }

    public void setFaultDate(Date faultDate) {
        this.faultDate = faultDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getNnlightctlUserId() {
        return nnlightctlUserId;
    }

    public void setNnlightctlUserId(Long nnlightctlUserId) {
        this.nnlightctlUserId = nnlightctlUserId;
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
        RepairRecord other = (RepairRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGmtCreated() == null ? other.getGmtCreated() == null : this.getGmtCreated().equals(other.getGmtCreated()))
            && (this.getGmtUpdated() == null ? other.getGmtUpdated() == null : this.getGmtUpdated().equals(other.getGmtUpdated()))
            && (this.getNnlightctlEleboxId() == null ? other.getNnlightctlEleboxId() == null : this.getNnlightctlEleboxId().equals(other.getNnlightctlEleboxId()))
            && (this.getNnlightctlPropertyClassifyCatalogId() == null ? other.getNnlightctlPropertyClassifyCatalogId() == null : this.getNnlightctlPropertyClassifyCatalogId().equals(other.getNnlightctlPropertyClassifyCatalogId()))
            && (this.getPropertyName() == null ? other.getPropertyName() == null : this.getPropertyName().equals(other.getPropertyName()))
            && (this.getPropertyCount() == null ? other.getPropertyCount() == null : this.getPropertyCount().equals(other.getPropertyCount()))
            && (this.getFaultDate() == null ? other.getFaultDate() == null : this.getFaultDate().equals(other.getFaultDate()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getNnlightctlUserId() == null ? other.getNnlightctlUserId() == null : this.getNnlightctlUserId().equals(other.getNnlightctlUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGmtCreated() == null) ? 0 : getGmtCreated().hashCode());
        result = prime * result + ((getGmtUpdated() == null) ? 0 : getGmtUpdated().hashCode());
        result = prime * result + ((getNnlightctlEleboxId() == null) ? 0 : getNnlightctlEleboxId().hashCode());
        result = prime * result + ((getNnlightctlPropertyClassifyCatalogId() == null) ? 0 : getNnlightctlPropertyClassifyCatalogId().hashCode());
        result = prime * result + ((getPropertyName() == null) ? 0 : getPropertyName().hashCode());
        result = prime * result + ((getPropertyCount() == null) ? 0 : getPropertyCount().hashCode());
        result = prime * result + ((getFaultDate() == null) ? 0 : getFaultDate().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getNnlightctlUserId() == null) ? 0 : getNnlightctlUserId().hashCode());
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
        sb.append(", nnlightctlEleboxId=").append(nnlightctlEleboxId);
        sb.append(", nnlightctlPropertyClassifyCatalogId=").append(nnlightctlPropertyClassifyCatalogId);
        sb.append(", propertyName=").append(propertyName);
        sb.append(", propertyCount=").append(propertyCount);
        sb.append(", faultDate=").append(faultDate);
        sb.append(", createDate=").append(createDate);
        sb.append(", nnlightctlUserId=").append(nnlightctlUserId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}