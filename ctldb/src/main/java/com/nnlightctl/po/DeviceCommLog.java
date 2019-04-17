package com.nnlightctl.po;

import java.io.Serializable;
import java.util.Date;

public class DeviceCommLog implements Serializable {
    private Long id;

    private Date gmtCreated;

    private Date gmtUpdated;

    private String uid;

    private Date communicationDate;

    private Byte communicationType;

    private byte[] communicationDatagram;

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

    public Date getCommunicationDate() {
        return communicationDate;
    }

    public void setCommunicationDate(Date communicationDate) {
        this.communicationDate = communicationDate;
    }

    public Byte getCommunicationType() {
        return communicationType;
    }

    public void setCommunicationType(Byte communicationType) {
        this.communicationType = communicationType;
    }

    public byte[] getCommunicationDatagram() {
        return communicationDatagram;
    }

    public void setCommunicationDatagram(byte[] communicationDatagram) {
        this.communicationDatagram = communicationDatagram;
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
        DeviceCommLog other = (DeviceCommLog) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGmtCreated() == null ? other.getGmtCreated() == null : this.getGmtCreated().equals(other.getGmtCreated()))
            && (this.getGmtUpdated() == null ? other.getGmtUpdated() == null : this.getGmtUpdated().equals(other.getGmtUpdated()))
            && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getCommunicationDate() == null ? other.getCommunicationDate() == null : this.getCommunicationDate().equals(other.getCommunicationDate()))
            && (this.getCommunicationType() == null ? other.getCommunicationType() == null : this.getCommunicationType().equals(other.getCommunicationType()))
            && (this.getCommunicationDatagram() == null ? other.getCommunicationDatagram() == null : this.getCommunicationDatagram().equals(other.getCommunicationDatagram()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGmtCreated() == null) ? 0 : getGmtCreated().hashCode());
        result = prime * result + ((getGmtUpdated() == null) ? 0 : getGmtUpdated().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getCommunicationDate() == null) ? 0 : getCommunicationDate().hashCode());
        result = prime * result + ((getCommunicationType() == null) ? 0 : getCommunicationType().hashCode());
        result = prime * result + ((getCommunicationDatagram() == null) ? 0 : getCommunicationDatagram().hashCode());
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
        sb.append(", communicationDate=").append(communicationDate);
        sb.append(", communicationType=").append(communicationType);
        sb.append(", communicationDatagram=").append(communicationDatagram);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}