package com.nnlightctl.po;

import java.io.Serializable;
import java.util.Date;

public class FirewareUploadRecord implements Serializable {
    private Long id;

    private Date gmtCreated;

    private Date gmtUpdated;

    private String firewareVersion;

    private Short packageNumber;

    private Byte lastPackageSize;

    private String persist1;

    private String persist2;

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

    public String getFirewareVersion() {
        return firewareVersion;
    }

    public void setFirewareVersion(String firewareVersion) {
        this.firewareVersion = firewareVersion == null ? null : firewareVersion.trim();
    }

    public Short getPackageNumber() {
        return packageNumber;
    }

    public void setPackageNumber(Short packageNumber) {
        this.packageNumber = packageNumber;
    }

    public Byte getLastPackageSize() {
        return lastPackageSize;
    }

    public void setLastPackageSize(Byte lastPackageSize) {
        this.lastPackageSize = lastPackageSize;
    }

    public String getPersist1() {
        return persist1;
    }

    public void setPersist1(String persist1) {
        this.persist1 = persist1 == null ? null : persist1.trim();
    }

    public String getPersist2() {
        return persist2;
    }

    public void setPersist2(String persist2) {
        this.persist2 = persist2 == null ? null : persist2.trim();
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
        FirewareUploadRecord other = (FirewareUploadRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGmtCreated() == null ? other.getGmtCreated() == null : this.getGmtCreated().equals(other.getGmtCreated()))
            && (this.getGmtUpdated() == null ? other.getGmtUpdated() == null : this.getGmtUpdated().equals(other.getGmtUpdated()))
            && (this.getFirewareVersion() == null ? other.getFirewareVersion() == null : this.getFirewareVersion().equals(other.getFirewareVersion()))
            && (this.getPackageNumber() == null ? other.getPackageNumber() == null : this.getPackageNumber().equals(other.getPackageNumber()))
            && (this.getLastPackageSize() == null ? other.getLastPackageSize() == null : this.getLastPackageSize().equals(other.getLastPackageSize()))
            && (this.getPersist1() == null ? other.getPersist1() == null : this.getPersist1().equals(other.getPersist1()))
            && (this.getPersist2() == null ? other.getPersist2() == null : this.getPersist2().equals(other.getPersist2()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGmtCreated() == null) ? 0 : getGmtCreated().hashCode());
        result = prime * result + ((getGmtUpdated() == null) ? 0 : getGmtUpdated().hashCode());
        result = prime * result + ((getFirewareVersion() == null) ? 0 : getFirewareVersion().hashCode());
        result = prime * result + ((getPackageNumber() == null) ? 0 : getPackageNumber().hashCode());
        result = prime * result + ((getLastPackageSize() == null) ? 0 : getLastPackageSize().hashCode());
        result = prime * result + ((getPersist1() == null) ? 0 : getPersist1().hashCode());
        result = prime * result + ((getPersist2() == null) ? 0 : getPersist2().hashCode());
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
        sb.append(", firewareVersion=").append(firewareVersion);
        sb.append(", packageNumber=").append(packageNumber);
        sb.append(", lastPackageSize=").append(lastPackageSize);
        sb.append(", persist1=").append(persist1);
        sb.append(", persist2=").append(persist2);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}