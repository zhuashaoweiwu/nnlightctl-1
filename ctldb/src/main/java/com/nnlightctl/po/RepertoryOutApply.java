package com.nnlightctl.po;

import java.io.Serializable;
import java.util.Date;

public class RepertoryOutApply implements Serializable {
    private Long id;

    private Date gmtCreated;

    private Date gmtUpdated;

    private String serialnumber;

    private Long nnlightctlPropertyId;

    private Long outCounte;

    private Long nnlightctlUserId;

    private Long nnlightctlOutRepertoryId;

    private Long nnlightctlRepertoryOutReasonId;

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

    public Long getNnlightctlPropertyId() {
        return nnlightctlPropertyId;
    }

    public void setNnlightctlPropertyId(Long nnlightctlPropertyId) {
        this.nnlightctlPropertyId = nnlightctlPropertyId;
    }

    public Long getOutCounte() {
        return outCounte;
    }

    public void setOutCounte(Long outCounte) {
        this.outCounte = outCounte;
    }

    public Long getNnlightctlUserId() {
        return nnlightctlUserId;
    }

    public void setNnlightctlUserId(Long nnlightctlUserId) {
        this.nnlightctlUserId = nnlightctlUserId;
    }

    public Long getNnlightctlOutRepertoryId() {
        return nnlightctlOutRepertoryId;
    }

    public void setNnlightctlOutRepertoryId(Long nnlightctlOutRepertoryId) {
        this.nnlightctlOutRepertoryId = nnlightctlOutRepertoryId;
    }

    public Long getNnlightctlRepertoryOutReasonId() {
        return nnlightctlRepertoryOutReasonId;
    }

    public void setNnlightctlRepertoryOutReasonId(Long nnlightctlRepertoryOutReasonId) {
        this.nnlightctlRepertoryOutReasonId = nnlightctlRepertoryOutReasonId;
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
        RepertoryOutApply other = (RepertoryOutApply) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGmtCreated() == null ? other.getGmtCreated() == null : this.getGmtCreated().equals(other.getGmtCreated()))
            && (this.getGmtUpdated() == null ? other.getGmtUpdated() == null : this.getGmtUpdated().equals(other.getGmtUpdated()))
            && (this.getSerialnumber() == null ? other.getSerialnumber() == null : this.getSerialnumber().equals(other.getSerialnumber()))
            && (this.getNnlightctlPropertyId() == null ? other.getNnlightctlPropertyId() == null : this.getNnlightctlPropertyId().equals(other.getNnlightctlPropertyId()))
            && (this.getOutCounte() == null ? other.getOutCounte() == null : this.getOutCounte().equals(other.getOutCounte()))
            && (this.getNnlightctlUserId() == null ? other.getNnlightctlUserId() == null : this.getNnlightctlUserId().equals(other.getNnlightctlUserId()))
            && (this.getNnlightctlOutRepertoryId() == null ? other.getNnlightctlOutRepertoryId() == null : this.getNnlightctlOutRepertoryId().equals(other.getNnlightctlOutRepertoryId()))
            && (this.getNnlightctlRepertoryOutReasonId() == null ? other.getNnlightctlRepertoryOutReasonId() == null : this.getNnlightctlRepertoryOutReasonId().equals(other.getNnlightctlRepertoryOutReasonId()))
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
        result = prime * result + ((getNnlightctlPropertyId() == null) ? 0 : getNnlightctlPropertyId().hashCode());
        result = prime * result + ((getOutCounte() == null) ? 0 : getOutCounte().hashCode());
        result = prime * result + ((getNnlightctlUserId() == null) ? 0 : getNnlightctlUserId().hashCode());
        result = prime * result + ((getNnlightctlOutRepertoryId() == null) ? 0 : getNnlightctlOutRepertoryId().hashCode());
        result = prime * result + ((getNnlightctlRepertoryOutReasonId() == null) ? 0 : getNnlightctlRepertoryOutReasonId().hashCode());
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
        sb.append(", nnlightctlPropertyId=").append(nnlightctlPropertyId);
        sb.append(", outCounte=").append(outCounte);
        sb.append(", nnlightctlUserId=").append(nnlightctlUserId);
        sb.append(", nnlightctlOutRepertoryId=").append(nnlightctlOutRepertoryId);
        sb.append(", nnlightctlRepertoryOutReasonId=").append(nnlightctlRepertoryOutReasonId);
        sb.append(", applyState=").append(applyState);
        sb.append(", refuseReason=").append(refuseReason);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}