package com.nnlightctl.po;

import java.io.Serializable;
import java.util.Date;

public class WorkOrderHistory implements Serializable {
    private Long id;

    private Date gmtCreated;

    private Date gmtUpdated;

    private Long nnlightctlWorkOrderId;

    private Date recordDate;

    private String mem;

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

    public Long getNnlightctlWorkOrderId() {
        return nnlightctlWorkOrderId;
    }

    public void setNnlightctlWorkOrderId(Long nnlightctlWorkOrderId) {
        this.nnlightctlWorkOrderId = nnlightctlWorkOrderId;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public String getMem() {
        return mem;
    }

    public void setMem(String mem) {
        this.mem = mem == null ? null : mem.trim();
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
        WorkOrderHistory other = (WorkOrderHistory) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGmtCreated() == null ? other.getGmtCreated() == null : this.getGmtCreated().equals(other.getGmtCreated()))
            && (this.getGmtUpdated() == null ? other.getGmtUpdated() == null : this.getGmtUpdated().equals(other.getGmtUpdated()))
            && (this.getNnlightctlWorkOrderId() == null ? other.getNnlightctlWorkOrderId() == null : this.getNnlightctlWorkOrderId().equals(other.getNnlightctlWorkOrderId()))
            && (this.getRecordDate() == null ? other.getRecordDate() == null : this.getRecordDate().equals(other.getRecordDate()))
            && (this.getMem() == null ? other.getMem() == null : this.getMem().equals(other.getMem()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGmtCreated() == null) ? 0 : getGmtCreated().hashCode());
        result = prime * result + ((getGmtUpdated() == null) ? 0 : getGmtUpdated().hashCode());
        result = prime * result + ((getNnlightctlWorkOrderId() == null) ? 0 : getNnlightctlWorkOrderId().hashCode());
        result = prime * result + ((getRecordDate() == null) ? 0 : getRecordDate().hashCode());
        result = prime * result + ((getMem() == null) ? 0 : getMem().hashCode());
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
        sb.append(", nnlightctlWorkOrderId=").append(nnlightctlWorkOrderId);
        sb.append(", recordDate=").append(recordDate);
        sb.append(", mem=").append(mem);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}