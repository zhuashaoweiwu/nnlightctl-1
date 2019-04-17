package com.nnlightctl.po;

import java.io.Serializable;
import java.util.Date;

public class AlarmHistory implements Serializable {
    private Long id;

    private Date gmtCreated;

    private Date gmtUpdated;

    private Long nnlightctlAlarmId;

    private String terminal;

    private String address;

    private String alarmHistoryChannel;

    private Date recordTime;

    private String mem;

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

    public Long getNnlightctlAlarmId() {
        return nnlightctlAlarmId;
    }

    public void setNnlightctlAlarmId(Long nnlightctlAlarmId) {
        this.nnlightctlAlarmId = nnlightctlAlarmId;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal == null ? null : terminal.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getAlarmHistoryChannel() {
        return alarmHistoryChannel;
    }

    public void setAlarmHistoryChannel(String alarmHistoryChannel) {
        this.alarmHistoryChannel = alarmHistoryChannel == null ? null : alarmHistoryChannel.trim();
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public String getMem() {
        return mem;
    }

    public void setMem(String mem) {
        this.mem = mem == null ? null : mem.trim();
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
        AlarmHistory other = (AlarmHistory) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGmtCreated() == null ? other.getGmtCreated() == null : this.getGmtCreated().equals(other.getGmtCreated()))
            && (this.getGmtUpdated() == null ? other.getGmtUpdated() == null : this.getGmtUpdated().equals(other.getGmtUpdated()))
            && (this.getNnlightctlAlarmId() == null ? other.getNnlightctlAlarmId() == null : this.getNnlightctlAlarmId().equals(other.getNnlightctlAlarmId()))
            && (this.getTerminal() == null ? other.getTerminal() == null : this.getTerminal().equals(other.getTerminal()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getAlarmHistoryChannel() == null ? other.getAlarmHistoryChannel() == null : this.getAlarmHistoryChannel().equals(other.getAlarmHistoryChannel()))
            && (this.getRecordTime() == null ? other.getRecordTime() == null : this.getRecordTime().equals(other.getRecordTime()))
            && (this.getMem() == null ? other.getMem() == null : this.getMem().equals(other.getMem()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGmtCreated() == null) ? 0 : getGmtCreated().hashCode());
        result = prime * result + ((getGmtUpdated() == null) ? 0 : getGmtUpdated().hashCode());
        result = prime * result + ((getNnlightctlAlarmId() == null) ? 0 : getNnlightctlAlarmId().hashCode());
        result = prime * result + ((getTerminal() == null) ? 0 : getTerminal().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getAlarmHistoryChannel() == null) ? 0 : getAlarmHistoryChannel().hashCode());
        result = prime * result + ((getRecordTime() == null) ? 0 : getRecordTime().hashCode());
        result = prime * result + ((getMem() == null) ? 0 : getMem().hashCode());
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
        sb.append(", nnlightctlAlarmId=").append(nnlightctlAlarmId);
        sb.append(", terminal=").append(terminal);
        sb.append(", address=").append(address);
        sb.append(", alarmHistoryChannel=").append(alarmHistoryChannel);
        sb.append(", recordTime=").append(recordTime);
        sb.append(", mem=").append(mem);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}