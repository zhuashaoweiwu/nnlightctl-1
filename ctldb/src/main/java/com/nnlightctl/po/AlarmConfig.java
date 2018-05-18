package com.nnlightctl.po;

import java.io.Serializable;
import java.util.Date;

public class AlarmConfig implements Serializable {
    private Long id;

    private Date gmtCreated;

    private Date gmtUpdated;

    private Byte alarmConfigLevel;

    private Byte isNoticeMap;

    private Byte isNoticeSms;

    private Byte isNoticeEmail;

    private Byte isNoticeWeixin;

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

    public Byte getAlarmConfigLevel() {
        return alarmConfigLevel;
    }

    public void setAlarmConfigLevel(Byte alarmConfigLevel) {
        this.alarmConfigLevel = alarmConfigLevel;
    }

    public Byte getIsNoticeMap() {
        return isNoticeMap;
    }

    public void setIsNoticeMap(Byte isNoticeMap) {
        this.isNoticeMap = isNoticeMap;
    }

    public Byte getIsNoticeSms() {
        return isNoticeSms;
    }

    public void setIsNoticeSms(Byte isNoticeSms) {
        this.isNoticeSms = isNoticeSms;
    }

    public Byte getIsNoticeEmail() {
        return isNoticeEmail;
    }

    public void setIsNoticeEmail(Byte isNoticeEmail) {
        this.isNoticeEmail = isNoticeEmail;
    }

    public Byte getIsNoticeWeixin() {
        return isNoticeWeixin;
    }

    public void setIsNoticeWeixin(Byte isNoticeWeixin) {
        this.isNoticeWeixin = isNoticeWeixin;
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
        AlarmConfig other = (AlarmConfig) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGmtCreated() == null ? other.getGmtCreated() == null : this.getGmtCreated().equals(other.getGmtCreated()))
            && (this.getGmtUpdated() == null ? other.getGmtUpdated() == null : this.getGmtUpdated().equals(other.getGmtUpdated()))
            && (this.getAlarmConfigLevel() == null ? other.getAlarmConfigLevel() == null : this.getAlarmConfigLevel().equals(other.getAlarmConfigLevel()))
            && (this.getIsNoticeMap() == null ? other.getIsNoticeMap() == null : this.getIsNoticeMap().equals(other.getIsNoticeMap()))
            && (this.getIsNoticeSms() == null ? other.getIsNoticeSms() == null : this.getIsNoticeSms().equals(other.getIsNoticeSms()))
            && (this.getIsNoticeEmail() == null ? other.getIsNoticeEmail() == null : this.getIsNoticeEmail().equals(other.getIsNoticeEmail()))
            && (this.getIsNoticeWeixin() == null ? other.getIsNoticeWeixin() == null : this.getIsNoticeWeixin().equals(other.getIsNoticeWeixin()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGmtCreated() == null) ? 0 : getGmtCreated().hashCode());
        result = prime * result + ((getGmtUpdated() == null) ? 0 : getGmtUpdated().hashCode());
        result = prime * result + ((getAlarmConfigLevel() == null) ? 0 : getAlarmConfigLevel().hashCode());
        result = prime * result + ((getIsNoticeMap() == null) ? 0 : getIsNoticeMap().hashCode());
        result = prime * result + ((getIsNoticeSms() == null) ? 0 : getIsNoticeSms().hashCode());
        result = prime * result + ((getIsNoticeEmail() == null) ? 0 : getIsNoticeEmail().hashCode());
        result = prime * result + ((getIsNoticeWeixin() == null) ? 0 : getIsNoticeWeixin().hashCode());
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
        sb.append(", alarmConfigLevel=").append(alarmConfigLevel);
        sb.append(", isNoticeMap=").append(isNoticeMap);
        sb.append(", isNoticeSms=").append(isNoticeSms);
        sb.append(", isNoticeEmail=").append(isNoticeEmail);
        sb.append(", isNoticeWeixin=").append(isNoticeWeixin);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}