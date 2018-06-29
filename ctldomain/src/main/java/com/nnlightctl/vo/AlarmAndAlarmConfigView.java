package com.nnlightctl.vo;

import java.util.Date;
import java.util.Objects;

public class AlarmAndAlarmConfigView extends BaseView{
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

    private Byte isNoticeMap;

    private Byte isNoticeSms;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Date getGmtCreated() {
        return gmtCreated;
    }

    @Override
    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    @Override
    public Date getGmtUpdated() {
        return gmtUpdated;
    }

    @Override
    public void setGmtUpdated(Date gmtUpdated) {
        this.gmtUpdated = gmtUpdated;
    }

    public String getCodeNumber() {
        return codeNumber;
    }

    public void setCodeNumber(String codeNumber) {
        this.codeNumber = codeNumber;
    }

    public String getAlarmSource() {
        return alarmSource;
    }

    public void setAlarmSource(String alarmSource) {
        this.alarmSource = alarmSource;
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
        this.msg = msg;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AlarmAndAlarmConfigView)) return false;
        AlarmAndAlarmConfigView that = (AlarmAndAlarmConfigView) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getGmtCreated(), that.getGmtCreated()) &&
                Objects.equals(getGmtUpdated(), that.getGmtUpdated()) &&
                Objects.equals(getCodeNumber(), that.getCodeNumber()) &&
                Objects.equals(getAlarmSource(), that.getAlarmSource()) &&
                Objects.equals(getAlarmLevel(), that.getAlarmLevel()) &&
                Objects.equals(getState(), that.getState()) &&
                Objects.equals(getCtype(), that.getCtype()) &&
                Objects.equals(getAlarmTime(), that.getAlarmTime()) &&
                Objects.equals(getRemoveAlarmTime(), that.getRemoveAlarmTime()) &&
                Objects.equals(getMsg(), that.getMsg()) &&
                Objects.equals(getAlarmCount(), that.getAlarmCount()) &&
                Objects.equals(getNnlightctlAlarmConfigId(), that.getNnlightctlAlarmConfigId()) &&
                Objects.equals(getIsNoticeMap(), that.getIsNoticeMap()) &&
                Objects.equals(getIsNoticeSms(), that.getIsNoticeSms());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getGmtCreated(), getGmtUpdated(), getCodeNumber(), getAlarmSource(), getAlarmLevel(), getState(), getCtype(), getAlarmTime(), getRemoveAlarmTime(), getMsg(), getAlarmCount(), getNnlightctlAlarmConfigId(), getIsNoticeMap(), getIsNoticeSms());
    }

    @Override
    public String toString() {
        return "AlarmAndAlarmConfigView{" +
                "id=" + id +
                ", gmtCreated=" + gmtCreated +
                ", gmtUpdated=" + gmtUpdated +
                ", codeNumber='" + codeNumber + '\'' +
                ", alarmSource='" + alarmSource + '\'' +
                ", alarmLevel=" + alarmLevel +
                ", state=" + state +
                ", ctype=" + ctype +
                ", alarmTime=" + alarmTime +
                ", removeAlarmTime=" + removeAlarmTime +
                ", msg='" + msg + '\'' +
                ", alarmCount=" + alarmCount +
                ", nnlightctlAlarmConfigId=" + nnlightctlAlarmConfigId +
                ", isNoticeMap=" + isNoticeMap +
                ", isNoticeSms=" + isNoticeSms +
                '}';
    }
}
