package com.nnlightctl.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class LightSignalLog implements Serializable {
    private Long id;

    private Date gmtCreated;

    private Date gmtUpdated;

    private String uid;

    private Date signalLogDate;

    private BigDecimal signalIntensity;

    private String unit;

    private Byte signalLevel;

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

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public Date getSignalLogDate() {
        return signalLogDate;
    }

    public void setSignalLogDate(Date signalLogDate) {
        this.signalLogDate = signalLogDate;
    }

    public BigDecimal getSignalIntensity() {
        return signalIntensity;
    }

    public void setSignalIntensity(BigDecimal signalIntensity) {
        this.signalIntensity = signalIntensity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public Byte getSignalLevel() {
        return signalLevel;
    }

    public void setSignalLevel(Byte signalLevel) {
        this.signalLevel = signalLevel;
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
        LightSignalLog other = (LightSignalLog) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGmtCreated() == null ? other.getGmtCreated() == null : this.getGmtCreated().equals(other.getGmtCreated()))
            && (this.getGmtUpdated() == null ? other.getGmtUpdated() == null : this.getGmtUpdated().equals(other.getGmtUpdated()))
            && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getSignalLogDate() == null ? other.getSignalLogDate() == null : this.getSignalLogDate().equals(other.getSignalLogDate()))
            && (this.getSignalIntensity() == null ? other.getSignalIntensity() == null : this.getSignalIntensity().equals(other.getSignalIntensity()))
            && (this.getUnit() == null ? other.getUnit() == null : this.getUnit().equals(other.getUnit()))
            && (this.getSignalLevel() == null ? other.getSignalLevel() == null : this.getSignalLevel().equals(other.getSignalLevel()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGmtCreated() == null) ? 0 : getGmtCreated().hashCode());
        result = prime * result + ((getGmtUpdated() == null) ? 0 : getGmtUpdated().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getSignalLogDate() == null) ? 0 : getSignalLogDate().hashCode());
        result = prime * result + ((getSignalIntensity() == null) ? 0 : getSignalIntensity().hashCode());
        result = prime * result + ((getUnit() == null) ? 0 : getUnit().hashCode());
        result = prime * result + ((getSignalLevel() == null) ? 0 : getSignalLevel().hashCode());
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
        sb.append(", uid=").append(uid);
        sb.append(", signalLogDate=").append(signalLogDate);
        sb.append(", signalIntensity=").append(signalIntensity);
        sb.append(", unit=").append(unit);
        sb.append(", signalLevel=").append(signalLevel);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}