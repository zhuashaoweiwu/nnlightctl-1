package com.nnlightctl.po;

import java.io.Serializable;
import java.util.Date;

public class LightingGroup implements Serializable {
    private Long id;

    private Date gmtCreated;

    private Date gmtUpdated;

    private String cGroupName;

    private String mem;

    private Long beProjectId;

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

    public String getcGroupName() {
        return cGroupName;
    }

    public void setcGroupName(String cGroupName) {
        this.cGroupName = cGroupName == null ? null : cGroupName.trim();
    }

    public String getMem() {
        return mem;
    }

    public void setMem(String mem) {
        this.mem = mem == null ? null : mem.trim();
    }

    public Long getBeProjectId() {
        return beProjectId;
    }

    public void setBeProjectId(Long beProjectId) {
        this.beProjectId = beProjectId;
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
        LightingGroup other = (LightingGroup) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGmtCreated() == null ? other.getGmtCreated() == null : this.getGmtCreated().equals(other.getGmtCreated()))
            && (this.getGmtUpdated() == null ? other.getGmtUpdated() == null : this.getGmtUpdated().equals(other.getGmtUpdated()))
            && (this.getcGroupName() == null ? other.getcGroupName() == null : this.getcGroupName().equals(other.getcGroupName()))
            && (this.getMem() == null ? other.getMem() == null : this.getMem().equals(other.getMem()))
            && (this.getBeProjectId() == null ? other.getBeProjectId() == null : this.getBeProjectId().equals(other.getBeProjectId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGmtCreated() == null) ? 0 : getGmtCreated().hashCode());
        result = prime * result + ((getGmtUpdated() == null) ? 0 : getGmtUpdated().hashCode());
        result = prime * result + ((getcGroupName() == null) ? 0 : getcGroupName().hashCode());
        result = prime * result + ((getMem() == null) ? 0 : getMem().hashCode());
        result = prime * result + ((getBeProjectId() == null) ? 0 : getBeProjectId().hashCode());
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
        sb.append(", cGroupName=").append(cGroupName);
        sb.append(", mem=").append(mem);
        sb.append(", beProjectId=").append(beProjectId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}