package com.nnlightctl.po;

import java.io.Serializable;
import java.util.Date;

public class PropertyClassifyCatalog implements Serializable {
    private Long id;

    private Date gmtCreated;

    private Date gmtUpdated;

    private String myCatalogName;

    private Byte catalogLevel;

    private Long nnlightctlPropertyClassifyCatalogId;

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

    public String getMyCatalogName() {
        return myCatalogName;
    }

    public void setMyCatalogName(String myCatalogName) {
        this.myCatalogName = myCatalogName == null ? null : myCatalogName.trim();
    }

    public Byte getCatalogLevel() {
        return catalogLevel;
    }

    public void setCatalogLevel(Byte catalogLevel) {
        this.catalogLevel = catalogLevel;
    }

    public Long getNnlightctlPropertyClassifyCatalogId() {
        return nnlightctlPropertyClassifyCatalogId;
    }

    public void setNnlightctlPropertyClassifyCatalogId(Long nnlightctlPropertyClassifyCatalogId) {
        this.nnlightctlPropertyClassifyCatalogId = nnlightctlPropertyClassifyCatalogId;
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
        PropertyClassifyCatalog other = (PropertyClassifyCatalog) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGmtCreated() == null ? other.getGmtCreated() == null : this.getGmtCreated().equals(other.getGmtCreated()))
            && (this.getGmtUpdated() == null ? other.getGmtUpdated() == null : this.getGmtUpdated().equals(other.getGmtUpdated()))
            && (this.getMyCatalogName() == null ? other.getMyCatalogName() == null : this.getMyCatalogName().equals(other.getMyCatalogName()))
            && (this.getCatalogLevel() == null ? other.getCatalogLevel() == null : this.getCatalogLevel().equals(other.getCatalogLevel()))
            && (this.getNnlightctlPropertyClassifyCatalogId() == null ? other.getNnlightctlPropertyClassifyCatalogId() == null : this.getNnlightctlPropertyClassifyCatalogId().equals(other.getNnlightctlPropertyClassifyCatalogId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGmtCreated() == null) ? 0 : getGmtCreated().hashCode());
        result = prime * result + ((getGmtUpdated() == null) ? 0 : getGmtUpdated().hashCode());
        result = prime * result + ((getMyCatalogName() == null) ? 0 : getMyCatalogName().hashCode());
        result = prime * result + ((getCatalogLevel() == null) ? 0 : getCatalogLevel().hashCode());
        result = prime * result + ((getNnlightctlPropertyClassifyCatalogId() == null) ? 0 : getNnlightctlPropertyClassifyCatalogId().hashCode());
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
        sb.append(", myCatalogName=").append(myCatalogName);
        sb.append(", catalogLevel=").append(catalogLevel);
        sb.append(", nnlightctlPropertyClassifyCatalogId=").append(nnlightctlPropertyClassifyCatalogId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}