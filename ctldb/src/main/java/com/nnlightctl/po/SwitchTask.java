package com.nnlightctl.po;

import java.io.Serializable;
import java.util.Date;

public class SwitchTask implements Serializable {
    private Long id;

    private Date gmtCreated;

    private Date gmtUpdated;

    private String switchName;

    private Date startTime;

    private Date endTime;

    private Byte isLighton;

    private Byte isUsebeam;

    private Byte period;

    private Byte lightPercent;

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

    public String getSwitchName() {
        return switchName;
    }

    public void setSwitchName(String switchName) {
        this.switchName = switchName == null ? null : switchName.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Byte getIsLighton() {
        return isLighton;
    }

    public void setIsLighton(Byte isLighton) {
        this.isLighton = isLighton;
    }

    public Byte getIsUsebeam() {
        return isUsebeam;
    }

    public void setIsUsebeam(Byte isUsebeam) {
        this.isUsebeam = isUsebeam;
    }

    public Byte getPeriod() {
        return period;
    }

    public void setPeriod(Byte period) {
        this.period = period;
    }

    public Byte getLightPercent() {
        return lightPercent;
    }

    public void setLightPercent(Byte lightPercent) {
        this.lightPercent = lightPercent;
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
        SwitchTask other = (SwitchTask) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGmtCreated() == null ? other.getGmtCreated() == null : this.getGmtCreated().equals(other.getGmtCreated()))
            && (this.getGmtUpdated() == null ? other.getGmtUpdated() == null : this.getGmtUpdated().equals(other.getGmtUpdated()))
            && (this.getSwitchName() == null ? other.getSwitchName() == null : this.getSwitchName().equals(other.getSwitchName()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getIsLighton() == null ? other.getIsLighton() == null : this.getIsLighton().equals(other.getIsLighton()))
            && (this.getIsUsebeam() == null ? other.getIsUsebeam() == null : this.getIsUsebeam().equals(other.getIsUsebeam()))
            && (this.getPeriod() == null ? other.getPeriod() == null : this.getPeriod().equals(other.getPeriod()))
            && (this.getLightPercent() == null ? other.getLightPercent() == null : this.getLightPercent().equals(other.getLightPercent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGmtCreated() == null) ? 0 : getGmtCreated().hashCode());
        result = prime * result + ((getGmtUpdated() == null) ? 0 : getGmtUpdated().hashCode());
        result = prime * result + ((getSwitchName() == null) ? 0 : getSwitchName().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getIsLighton() == null) ? 0 : getIsLighton().hashCode());
        result = prime * result + ((getIsUsebeam() == null) ? 0 : getIsUsebeam().hashCode());
        result = prime * result + ((getPeriod() == null) ? 0 : getPeriod().hashCode());
        result = prime * result + ((getLightPercent() == null) ? 0 : getLightPercent().hashCode());
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
        sb.append(", switchName=").append(switchName);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", isLighton=").append(isLighton);
        sb.append(", isUsebeam=").append(isUsebeam);
        sb.append(", period=").append(period);
        sb.append(", lightPercent=").append(lightPercent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}