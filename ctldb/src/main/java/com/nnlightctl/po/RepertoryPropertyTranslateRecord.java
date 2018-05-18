package com.nnlightctl.po;

import java.io.Serializable;
import java.util.Date;

public class RepertoryPropertyTranslateRecord implements Serializable {
    private Long id;

    private Date gmtCreated;

    private Date gmtUpdated;

    private Long nnlightctlPropertyId;

    private Date translateDate;

    private Long sourceRepertyId;

    private Long targetRepertyId;

    private Long nnlightctlUserIdApply;

    private Long nnlightctlUserIdReceive;

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

    public Long getNnlightctlPropertyId() {
        return nnlightctlPropertyId;
    }

    public void setNnlightctlPropertyId(Long nnlightctlPropertyId) {
        this.nnlightctlPropertyId = nnlightctlPropertyId;
    }

    public Date getTranslateDate() {
        return translateDate;
    }

    public void setTranslateDate(Date translateDate) {
        this.translateDate = translateDate;
    }

    public Long getSourceRepertyId() {
        return sourceRepertyId;
    }

    public void setSourceRepertyId(Long sourceRepertyId) {
        this.sourceRepertyId = sourceRepertyId;
    }

    public Long getTargetRepertyId() {
        return targetRepertyId;
    }

    public void setTargetRepertyId(Long targetRepertyId) {
        this.targetRepertyId = targetRepertyId;
    }

    public Long getNnlightctlUserIdApply() {
        return nnlightctlUserIdApply;
    }

    public void setNnlightctlUserIdApply(Long nnlightctlUserIdApply) {
        this.nnlightctlUserIdApply = nnlightctlUserIdApply;
    }

    public Long getNnlightctlUserIdReceive() {
        return nnlightctlUserIdReceive;
    }

    public void setNnlightctlUserIdReceive(Long nnlightctlUserIdReceive) {
        this.nnlightctlUserIdReceive = nnlightctlUserIdReceive;
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
        RepertoryPropertyTranslateRecord other = (RepertoryPropertyTranslateRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGmtCreated() == null ? other.getGmtCreated() == null : this.getGmtCreated().equals(other.getGmtCreated()))
            && (this.getGmtUpdated() == null ? other.getGmtUpdated() == null : this.getGmtUpdated().equals(other.getGmtUpdated()))
            && (this.getNnlightctlPropertyId() == null ? other.getNnlightctlPropertyId() == null : this.getNnlightctlPropertyId().equals(other.getNnlightctlPropertyId()))
            && (this.getTranslateDate() == null ? other.getTranslateDate() == null : this.getTranslateDate().equals(other.getTranslateDate()))
            && (this.getSourceRepertyId() == null ? other.getSourceRepertyId() == null : this.getSourceRepertyId().equals(other.getSourceRepertyId()))
            && (this.getTargetRepertyId() == null ? other.getTargetRepertyId() == null : this.getTargetRepertyId().equals(other.getTargetRepertyId()))
            && (this.getNnlightctlUserIdApply() == null ? other.getNnlightctlUserIdApply() == null : this.getNnlightctlUserIdApply().equals(other.getNnlightctlUserIdApply()))
            && (this.getNnlightctlUserIdReceive() == null ? other.getNnlightctlUserIdReceive() == null : this.getNnlightctlUserIdReceive().equals(other.getNnlightctlUserIdReceive()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGmtCreated() == null) ? 0 : getGmtCreated().hashCode());
        result = prime * result + ((getGmtUpdated() == null) ? 0 : getGmtUpdated().hashCode());
        result = prime * result + ((getNnlightctlPropertyId() == null) ? 0 : getNnlightctlPropertyId().hashCode());
        result = prime * result + ((getTranslateDate() == null) ? 0 : getTranslateDate().hashCode());
        result = prime * result + ((getSourceRepertyId() == null) ? 0 : getSourceRepertyId().hashCode());
        result = prime * result + ((getTargetRepertyId() == null) ? 0 : getTargetRepertyId().hashCode());
        result = prime * result + ((getNnlightctlUserIdApply() == null) ? 0 : getNnlightctlUserIdApply().hashCode());
        result = prime * result + ((getNnlightctlUserIdReceive() == null) ? 0 : getNnlightctlUserIdReceive().hashCode());
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
        sb.append(", nnlightctlPropertyId=").append(nnlightctlPropertyId);
        sb.append(", translateDate=").append(translateDate);
        sb.append(", sourceRepertyId=").append(sourceRepertyId);
        sb.append(", targetRepertyId=").append(targetRepertyId);
        sb.append(", nnlightctlUserIdApply=").append(nnlightctlUserIdApply);
        sb.append(", nnlightctlUserIdReceive=").append(nnlightctlUserIdReceive);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}