package com.nnlightctl.po;

import java.io.Serializable;
import java.util.Date;

public class Alarm implements Serializable {
    private Long id;

    private Date gmtCreated;

    private Date gmtUpdated;

    private String codeNumber;

    private String alarmSource;

    private Byte alarmLevel;

    private Byte state;

    private Byte ctype;

    private Date alarmTime;

    private Date removeAlarmTime;

    private String msg;

    private Long alarmCount;

    private Long nnlightctlAlarmConfigId;

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

    public String getCodeNumber() {
        return codeNumber;
    }

    public void setCodeNumber(String codeNumber) {
        this.codeNumber = codeNumber == null ? null : codeNumber.trim();
    }

    public String getAlarmSource() {
        return alarmSource;
    }

    public void setAlarmSource(String alarmSource) {
        this.alarmSource = alarmSource == null ? null : alarmSource.trim();
    }

    public Byte getAlarmLevel() {
        return alarmLevel;
    }

    public void setAlarmLevel(Byte alarmLevel) {
        this.alarmLevel = alarmLevel;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Byte getCtype() {
        return ctype;
    }

    public void setCtype(Byte ctype) {
        this.ctype = ctype;
    }

    public Date getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(Date alarmTime) {
        this.alarmTime = alarmTime;
    }

    public Date getRemoveAlarmTime() {
        return removeAlarmTime;
    }

    public void setRemoveAlarmTime(Date removeAlarmTime) {
        this.removeAlarmTime = removeAlarmTime;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }

    public Long getAlarmCount() {
        return alarmCount;
    }

    public void setAlarmCount(Long alarmCount) {
        this.alarmCount = alarmCount;
    }

    public Long getNnlightctlAlarmConfigId() {
        return nnlightctlAlarmConfigId;
    }

    public void setNnlightctlAlarmConfigId(Long nnlightctlAlarmConfigId) {
        this.nnlightctlAlarmConfigId = nnlightctlAlarmConfigId;
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
        Alarm other = (Alarm) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGmtCreated() == null ? other.getGmtCreated() == null : this.getGmtCreated().equals(other.getGmtCreated()))
            && (this.getGmtUpdated() == null ? other.getGmtUpdated() == null : this.getGmtUpdated().equals(other.getGmtUpdated()))
            && (this.getCodeNumber() == null ? other.getCodeNumber() == null : this.getCodeNumber().equals(other.getCodeNumber()))
            && (this.getAlarmSource() == null ? other.getAlarmSource() == null : this.getAlarmSource().equals(other.getAlarmSource()))
            && (this.getAlarmLevel() == null ? other.getAlarmLevel() == null : this.getAlarmLevel().equals(other.getAlarmLevel()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getCtype() == null ? other.getCtype() == null : this.getCtype().equals(other.getCtype()))
            && (this.getAlarmTime() == null ? other.getAlarmTime() == null : this.getAlarmTime().equals(other.getAlarmTime()))
            && (this.getRemoveAlarmTime() == null ? other.getRemoveAlarmTime() == null : this.getRemoveAlarmTime().equals(other.getRemoveAlarmTime()))
            && (this.getMsg() == null ? other.getMsg() == null : this.getMsg().equals(other.getMsg()))
            && (this.getAlarmCount() == null ? other.getAlarmCount() == null : this.getAlarmCount().equals(other.getAlarmCount()))
            && (this.getNnlightctlAlarmConfigId() == null ? other.getNnlightctlAlarmConfigId() == null : this.getNnlightctlAlarmConfigId().equals(other.getNnlightctlAlarmConfigId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGmtCreated() == null) ? 0 : getGmtCreated().hashCode());
        result = prime * result + ((getGmtUpdated() == null) ? 0 : getGmtUpdated().hashCode());
        result = prime * result + ((getCodeNumber() == null) ? 0 : getCodeNumber().hashCode());
        result = prime * result + ((getAlarmSource() == null) ? 0 : getAlarmSource().hashCode());
        result = prime * result + ((getAlarmLevel() == null) ? 0 : getAlarmLevel().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getCtype() == null) ? 0 : getCtype().hashCode());
        result = prime * result + ((getAlarmTime() == null) ? 0 : getAlarmTime().hashCode());
        result = prime * result + ((getRemoveAlarmTime() == null) ? 0 : getRemoveAlarmTime().hashCode());
        result = prime * result + ((getMsg() == null) ? 0 : getMsg().hashCode());
        result = prime * result + ((getAlarmCount() == null) ? 0 : getAlarmCount().hashCode());
        result = prime * result + ((getNnlightctlAlarmConfigId() == null) ? 0 : getNnlightctlAlarmConfigId().hashCode());
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
        sb.append(", codeNumber=").append(codeNumber);
        sb.append(", alarmSource=").append(alarmSource);
        sb.append(", alarmLevel=").append(alarmLevel);
        sb.append(", state=").append(state);
        sb.append(", ctype=").append(ctype);
        sb.append(", alarmTime=").append(alarmTime);
        sb.append(", removeAlarmTime=").append(removeAlarmTime);
        sb.append(", msg=").append(msg);
        sb.append(", alarmCount=").append(alarmCount);
        sb.append(", nnlightctlAlarmConfigId=").append(nnlightctlAlarmConfigId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}