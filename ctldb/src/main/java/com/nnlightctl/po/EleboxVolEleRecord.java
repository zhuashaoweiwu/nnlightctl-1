package com.nnlightctl.po;

import java.io.Serializable;
import java.util.Date;

public class EleboxVolEleRecord implements Serializable {
    private Long id;

    private Date gmtCreated;

    private Date gmtUpdated;

    private String uid;

    private Date realtimeDate;

    private Long voltage;

    private Long electricity;

    private Long eleboxPower;

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

    public Date getRealtimeDate() {
        return realtimeDate;
    }

    public void setRealtimeDate(Date realtimeDate) {
        this.realtimeDate = realtimeDate;
    }

    public Long getVoltage() {
        return voltage;
    }

    public void setVoltage(Long voltage) {
        this.voltage = voltage;
    }

    public Long getElectricity() {
        return electricity;
    }

    public void setElectricity(Long electricity) {
        this.electricity = electricity;
    }

    public Long getEleboxPower() {
        return eleboxPower;
    }

    public void setEleboxPower(Long eleboxPower) {
        this.eleboxPower = eleboxPower;
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
        EleboxVolEleRecord other = (EleboxVolEleRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGmtCreated() == null ? other.getGmtCreated() == null : this.getGmtCreated().equals(other.getGmtCreated()))
            && (this.getGmtUpdated() == null ? other.getGmtUpdated() == null : this.getGmtUpdated().equals(other.getGmtUpdated()))
            && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getRealtimeDate() == null ? other.getRealtimeDate() == null : this.getRealtimeDate().equals(other.getRealtimeDate()))
            && (this.getVoltage() == null ? other.getVoltage() == null : this.getVoltage().equals(other.getVoltage()))
            && (this.getElectricity() == null ? other.getElectricity() == null : this.getElectricity().equals(other.getElectricity()))
            && (this.getEleboxPower() == null ? other.getEleboxPower() == null : this.getEleboxPower().equals(other.getEleboxPower()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGmtCreated() == null) ? 0 : getGmtCreated().hashCode());
        result = prime * result + ((getGmtUpdated() == null) ? 0 : getGmtUpdated().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getRealtimeDate() == null) ? 0 : getRealtimeDate().hashCode());
        result = prime * result + ((getVoltage() == null) ? 0 : getVoltage().hashCode());
        result = prime * result + ((getElectricity() == null) ? 0 : getElectricity().hashCode());
        result = prime * result + ((getEleboxPower() == null) ? 0 : getEleboxPower().hashCode());
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
        sb.append(", realtimeDate=").append(realtimeDate);
        sb.append(", voltage=").append(voltage);
        sb.append(", electricity=").append(electricity);
        sb.append(", eleboxPower=").append(eleboxPower);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}