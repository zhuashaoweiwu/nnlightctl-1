package com.nnlightctl.po;

import java.io.Serializable;
import java.util.Date;

public class RepertoryInRecord implements Serializable {
    private Long id;

    private Date gmtCreated;

    private Date gmtUpdated;

    private String serialnumber;

    private Date inRepertoryDate;

    private Long nnlightctlPropertyId;

    private Long nnlightctlRepertoryId;

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

    public Long getNnlightctlPropertyId() {
        return nnlightctlPropertyId;
    }

    public void setNnlightctlPropertyId(Long nnlightctlPropertyId) {
        this.nnlightctlPropertyId = nnlightctlPropertyId;
    }

    public Long getNnlightctlRepertoryId() {
        return nnlightctlRepertoryId;
    }

    public void setNnlightctlRepertoryId(Long nnlightctlRepertoryId) {
        this.nnlightctlRepertoryId = nnlightctlRepertoryId;
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
        RepertoryInRecord other = (RepertoryInRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGmtCreated() == null ? other.getGmtCreated() == null : this.getGmtCreated().equals(other.getGmtCreated()))
            && (this.getGmtUpdated() == null ? other.getGmtUpdated() == null : this.getGmtUpdated().equals(other.getGmtUpdated()))
            && (this.getSerialnumber() == null ? other.getSerialnumber() == null : this.getSerialnumber().equals(other.getSerialnumber()))
            && (this.getInRepertoryDate() == null ? other.getInRepertoryDate() == null : this.getInRepertoryDate().equals(other.getInRepertoryDate()))
            && (this.getNnlightctlPropertyId() == null ? other.getNnlightctlPropertyId() == null : this.getNnlightctlPropertyId().equals(other.getNnlightctlPropertyId()))
            && (this.getNnlightctlRepertoryId() == null ? other.getNnlightctlRepertoryId() == null : this.getNnlightctlRepertoryId().equals(other.getNnlightctlRepertoryId()))
            && (this.getNnlightctlUserId() == null ? other.getNnlightctlUserId() == null : this.getNnlightctlUserId().equals(other.getNnlightctlUserId()));
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
        result = prime * result + ((getNnlightctlPropertyId() == null) ? 0 : getNnlightctlPropertyId().hashCode());
        result = prime * result + ((getNnlightctlRepertoryId() == null) ? 0 : getNnlightctlRepertoryId().hashCode());
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
        sb.append(", serialnumber=").append(serialnumber);
        sb.append(", inRepertoryDate=").append(inRepertoryDate);
        sb.append(", nnlightctlPropertyId=").append(nnlightctlPropertyId);
        sb.append(", nnlightctlRepertoryId=").append(nnlightctlRepertoryId);
        sb.append(", nnlightctlUserId=").append(nnlightctlUserId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}