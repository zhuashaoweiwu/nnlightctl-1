package com.nnlightctl.po;

import java.io.Serializable;
import java.util.Date;

public class EleboxModel implements Serializable {
    private Long id;

    private Date gmtCreated;

    private Date gmtUpdated;

    private String uid;

    private Long powerRating;

    private Long electricRating;

    private Long voltageRating;

    private String airSwitchType;

    private String contactorType;

    private Byte loopCount;

    private Long nnlightctlEleboxId;

    private String ac;

    private Long loopElectricity;

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

    public Long getPowerRating() {
        return powerRating;
    }

    public void setPowerRating(Long powerRating) {
        this.powerRating = powerRating;
    }

    public Long getElectricRating() {
        return electricRating;
    }

    public void setElectricRating(Long electricRating) {
        this.electricRating = electricRating;
    }

    public Long getVoltageRating() {
        return voltageRating;
    }

    public void setVoltageRating(Long voltageRating) {
        this.voltageRating = voltageRating;
    }

    public String getAirSwitchType() {
        return airSwitchType;
    }

    public void setAirSwitchType(String airSwitchType) {
        this.airSwitchType = airSwitchType == null ? null : airSwitchType.trim();
    }

    public String getContactorType() {
        return contactorType;
    }

    public void setContactorType(String contactorType) {
        this.contactorType = contactorType == null ? null : contactorType.trim();
    }

    public Byte getLoopCount() {
        return loopCount;
    }

    public void setLoopCount(Byte loopCount) {
        this.loopCount = loopCount;
    }

    public Long getNnlightctlEleboxId() {
        return nnlightctlEleboxId;
    }

    public void setNnlightctlEleboxId(Long nnlightctlEleboxId) {
        this.nnlightctlEleboxId = nnlightctlEleboxId;
    }

    public String getAc() {
        return ac;
    }

    public void setAc(String ac) {
        this.ac = ac == null ? null : ac.trim();
    }

    public Long getLoopElectricity() {
        return loopElectricity;
    }

    public void setLoopElectricity(Long loopElectricity) {
        this.loopElectricity = loopElectricity;
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
        EleboxModel other = (EleboxModel) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGmtCreated() == null ? other.getGmtCreated() == null : this.getGmtCreated().equals(other.getGmtCreated()))
            && (this.getGmtUpdated() == null ? other.getGmtUpdated() == null : this.getGmtUpdated().equals(other.getGmtUpdated()))
            && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getPowerRating() == null ? other.getPowerRating() == null : this.getPowerRating().equals(other.getPowerRating()))
            && (this.getElectricRating() == null ? other.getElectricRating() == null : this.getElectricRating().equals(other.getElectricRating()))
            && (this.getVoltageRating() == null ? other.getVoltageRating() == null : this.getVoltageRating().equals(other.getVoltageRating()))
            && (this.getAirSwitchType() == null ? other.getAirSwitchType() == null : this.getAirSwitchType().equals(other.getAirSwitchType()))
            && (this.getContactorType() == null ? other.getContactorType() == null : this.getContactorType().equals(other.getContactorType()))
            && (this.getLoopCount() == null ? other.getLoopCount() == null : this.getLoopCount().equals(other.getLoopCount()))
            && (this.getNnlightctlEleboxId() == null ? other.getNnlightctlEleboxId() == null : this.getNnlightctlEleboxId().equals(other.getNnlightctlEleboxId()))
            && (this.getAc() == null ? other.getAc() == null : this.getAc().equals(other.getAc()))
            && (this.getLoopElectricity() == null ? other.getLoopElectricity() == null : this.getLoopElectricity().equals(other.getLoopElectricity()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGmtCreated() == null) ? 0 : getGmtCreated().hashCode());
        result = prime * result + ((getGmtUpdated() == null) ? 0 : getGmtUpdated().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getPowerRating() == null) ? 0 : getPowerRating().hashCode());
        result = prime * result + ((getElectricRating() == null) ? 0 : getElectricRating().hashCode());
        result = prime * result + ((getVoltageRating() == null) ? 0 : getVoltageRating().hashCode());
        result = prime * result + ((getAirSwitchType() == null) ? 0 : getAirSwitchType().hashCode());
        result = prime * result + ((getContactorType() == null) ? 0 : getContactorType().hashCode());
        result = prime * result + ((getLoopCount() == null) ? 0 : getLoopCount().hashCode());
        result = prime * result + ((getNnlightctlEleboxId() == null) ? 0 : getNnlightctlEleboxId().hashCode());
        result = prime * result + ((getAc() == null) ? 0 : getAc().hashCode());
        result = prime * result + ((getLoopElectricity() == null) ? 0 : getLoopElectricity().hashCode());
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
        sb.append(", powerRating=").append(powerRating);
        sb.append(", electricRating=").append(electricRating);
        sb.append(", voltageRating=").append(voltageRating);
        sb.append(", airSwitchType=").append(airSwitchType);
        sb.append(", contactorType=").append(contactorType);
        sb.append(", loopCount=").append(loopCount);
        sb.append(", nnlightctlEleboxId=").append(nnlightctlEleboxId);
        sb.append(", ac=").append(ac);
        sb.append(", loopElectricity=").append(loopElectricity);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}