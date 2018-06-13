package com.nnlightctl.po;

import java.io.Serializable;
import java.util.Date;

public class Region implements Serializable {
    private Long id;

    private Date gmtCreated;

    private Date gmtUpdated;

    private String areaName;

    private String regionDesc;

    private Byte regionLevel;

    private Long nnlightctlParentRegion;

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

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }

    public String getRegionDesc() {
        return regionDesc;
    }

    public void setRegionDesc(String regionDesc) {
        this.regionDesc = regionDesc == null ? null : regionDesc.trim();
    }

    public Byte getRegionLevel() {
        return regionLevel;
    }

    public void setRegionLevel(Byte regionLevel) {
        this.regionLevel = regionLevel;
    }

    public Long getNnlightctlParentRegion() {
        return nnlightctlParentRegion;
    }

    public void setNnlightctlParentRegion(Long nnlightctlParentRegion) {
        this.nnlightctlParentRegion = nnlightctlParentRegion;
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
        Region other = (Region) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGmtCreated() == null ? other.getGmtCreated() == null : this.getGmtCreated().equals(other.getGmtCreated()))
            && (this.getGmtUpdated() == null ? other.getGmtUpdated() == null : this.getGmtUpdated().equals(other.getGmtUpdated()))
            && (this.getAreaName() == null ? other.getAreaName() == null : this.getAreaName().equals(other.getAreaName()))
            && (this.getRegionDesc() == null ? other.getRegionDesc() == null : this.getRegionDesc().equals(other.getRegionDesc()))
            && (this.getRegionLevel() == null ? other.getRegionLevel() == null : this.getRegionLevel().equals(other.getRegionLevel()))
            && (this.getNnlightctlParentRegion() == null ? other.getNnlightctlParentRegion() == null : this.getNnlightctlParentRegion().equals(other.getNnlightctlParentRegion()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGmtCreated() == null) ? 0 : getGmtCreated().hashCode());
        result = prime * result + ((getGmtUpdated() == null) ? 0 : getGmtUpdated().hashCode());
        result = prime * result + ((getAreaName() == null) ? 0 : getAreaName().hashCode());
        result = prime * result + ((getRegionDesc() == null) ? 0 : getRegionDesc().hashCode());
        result = prime * result + ((getRegionLevel() == null) ? 0 : getRegionLevel().hashCode());
        result = prime * result + ((getNnlightctlParentRegion() == null) ? 0 : getNnlightctlParentRegion().hashCode());
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
        sb.append(", areaName=").append(areaName);
        sb.append(", regionDesc=").append(regionDesc);
        sb.append(", regionLevel=").append(regionLevel);
        sb.append(", nnlightctlParentRegion=").append(nnlightctlParentRegion);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}