package com.nnlightctl.po;

import java.io.Serializable;
import java.util.Date;

public class RepairRecordAutoCommit implements Serializable {
    private Long id;

    private Date gmtCreated;

    private Date gmtUpdated;

    private Date autoCommitTime;

    private Long repairRecordId;

    private Byte commitState;

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

    public Date getAutoCommitTime() {
        return autoCommitTime;
    }

    public void setAutoCommitTime(Date autoCommitTime) {
        this.autoCommitTime = autoCommitTime;
    }

    public Long getRepairRecordId() {
        return repairRecordId;
    }

    public void setRepairRecordId(Long repairRecordId) {
        this.repairRecordId = repairRecordId;
    }

    public Byte getCommitState() {
        return commitState;
    }

    public void setCommitState(Byte commitState) {
        this.commitState = commitState;
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
        RepairRecordAutoCommit other = (RepairRecordAutoCommit) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGmtCreated() == null ? other.getGmtCreated() == null : this.getGmtCreated().equals(other.getGmtCreated()))
            && (this.getGmtUpdated() == null ? other.getGmtUpdated() == null : this.getGmtUpdated().equals(other.getGmtUpdated()))
            && (this.getAutoCommitTime() == null ? other.getAutoCommitTime() == null : this.getAutoCommitTime().equals(other.getAutoCommitTime()))
            && (this.getRepairRecordId() == null ? other.getRepairRecordId() == null : this.getRepairRecordId().equals(other.getRepairRecordId()))
            && (this.getCommitState() == null ? other.getCommitState() == null : this.getCommitState().equals(other.getCommitState()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGmtCreated() == null) ? 0 : getGmtCreated().hashCode());
        result = prime * result + ((getGmtUpdated() == null) ? 0 : getGmtUpdated().hashCode());
        result = prime * result + ((getAutoCommitTime() == null) ? 0 : getAutoCommitTime().hashCode());
        result = prime * result + ((getRepairRecordId() == null) ? 0 : getRepairRecordId().hashCode());
        result = prime * result + ((getCommitState() == null) ? 0 : getCommitState().hashCode());
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
        sb.append(", autoCommitTime=").append(autoCommitTime);
        sb.append(", repairRecordId=").append(repairRecordId);
        sb.append(", commitState=").append(commitState);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}