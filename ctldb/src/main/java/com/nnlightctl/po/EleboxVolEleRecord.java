package com.nnlightctl.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class EleboxVolEleRecord implements Serializable {
    private Long id;

    private Date gmtCreated;

    private Date gmtUpdated;

    private String uid;

    private Date realtimeDate;

    private BigDecimal voltage;

    private BigDecimal electricity;

    private String aVoltage;

    private String bVoltage;

    private String cVoltage;

    private String aElectricity;

    private String bElectricity;

    private String cElectricity;

    private String aActivePower;

    private String bActivePower;

    private String cActivePower;

    private String totalActivePower;

    private String totalActiveEnergy;

    private String totalReactiveEnergy;

    private String aPowerFactor;

    private String bPowerFactor;

    private String cPowerFactor;

    private String totalPowerFactor;

    private BigDecimal energy;

    private BigDecimal eleboxPower;

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

    public BigDecimal getVoltage() {
        return voltage;
    }

    public void setVoltage(BigDecimal voltage) {
        this.voltage = voltage;
    }

    public BigDecimal getElectricity() {
        return electricity;
    }

    public void setElectricity(BigDecimal electricity) {
        this.electricity = electricity;
    }

    public String getaVoltage() {
        return aVoltage;
    }

    public void setaVoltage(String aVoltage) {
        this.aVoltage = aVoltage == null ? null : aVoltage.trim();
    }

    public String getbVoltage() {
        return bVoltage;
    }

    public void setbVoltage(String bVoltage) {
        this.bVoltage = bVoltage == null ? null : bVoltage.trim();
    }

    public String getcVoltage() {
        return cVoltage;
    }

    public void setcVoltage(String cVoltage) {
        this.cVoltage = cVoltage == null ? null : cVoltage.trim();
    }

    public String getaElectricity() {
        return aElectricity;
    }

    public void setaElectricity(String aElectricity) {
        this.aElectricity = aElectricity == null ? null : aElectricity.trim();
    }

    public String getbElectricity() {
        return bElectricity;
    }

    public void setbElectricity(String bElectricity) {
        this.bElectricity = bElectricity == null ? null : bElectricity.trim();
    }

    public String getcElectricity() {
        return cElectricity;
    }

    public void setcElectricity(String cElectricity) {
        this.cElectricity = cElectricity == null ? null : cElectricity.trim();
    }

    public String getaActivePower() {
        return aActivePower;
    }

    public void setaActivePower(String aActivePower) {
        this.aActivePower = aActivePower == null ? null : aActivePower.trim();
    }

    public String getbActivePower() {
        return bActivePower;
    }

    public void setbActivePower(String bActivePower) {
        this.bActivePower = bActivePower == null ? null : bActivePower.trim();
    }

    public String getcActivePower() {
        return cActivePower;
    }

    public void setcActivePower(String cActivePower) {
        this.cActivePower = cActivePower == null ? null : cActivePower.trim();
    }

    public String getTotalActivePower() {
        return totalActivePower;
    }

    public void setTotalActivePower(String totalActivePower) {
        this.totalActivePower = totalActivePower == null ? null : totalActivePower.trim();
    }

    public String getTotalActiveEnergy() {
        return totalActiveEnergy;
    }

    public void setTotalActiveEnergy(String totalActiveEnergy) {
        this.totalActiveEnergy = totalActiveEnergy == null ? null : totalActiveEnergy.trim();
    }

    public String getTotalReactiveEnergy() {
        return totalReactiveEnergy;
    }

    public void setTotalReactiveEnergy(String totalReactiveEnergy) {
        this.totalReactiveEnergy = totalReactiveEnergy == null ? null : totalReactiveEnergy.trim();
    }

    public String getaPowerFactor() {
        return aPowerFactor;
    }

    public void setaPowerFactor(String aPowerFactor) {
        this.aPowerFactor = aPowerFactor == null ? null : aPowerFactor.trim();
    }

    public String getbPowerFactor() {
        return bPowerFactor;
    }

    public void setbPowerFactor(String bPowerFactor) {
        this.bPowerFactor = bPowerFactor == null ? null : bPowerFactor.trim();
    }

    public String getcPowerFactor() {
        return cPowerFactor;
    }

    public void setcPowerFactor(String cPowerFactor) {
        this.cPowerFactor = cPowerFactor == null ? null : cPowerFactor.trim();
    }

    public String getTotalPowerFactor() {
        return totalPowerFactor;
    }

    public void setTotalPowerFactor(String totalPowerFactor) {
        this.totalPowerFactor = totalPowerFactor == null ? null : totalPowerFactor.trim();
    }

    public BigDecimal getEnergy() {
        return energy;
    }

    public void setEnergy(BigDecimal energy) {
        this.energy = energy;
    }

    public BigDecimal getEleboxPower() {
        return eleboxPower;
    }

    public void setEleboxPower(BigDecimal eleboxPower) {
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
            && (this.getaVoltage() == null ? other.getaVoltage() == null : this.getaVoltage().equals(other.getaVoltage()))
            && (this.getbVoltage() == null ? other.getbVoltage() == null : this.getbVoltage().equals(other.getbVoltage()))
            && (this.getcVoltage() == null ? other.getcVoltage() == null : this.getcVoltage().equals(other.getcVoltage()))
            && (this.getaElectricity() == null ? other.getaElectricity() == null : this.getaElectricity().equals(other.getaElectricity()))
            && (this.getbElectricity() == null ? other.getbElectricity() == null : this.getbElectricity().equals(other.getbElectricity()))
            && (this.getcElectricity() == null ? other.getcElectricity() == null : this.getcElectricity().equals(other.getcElectricity()))
            && (this.getaActivePower() == null ? other.getaActivePower() == null : this.getaActivePower().equals(other.getaActivePower()))
            && (this.getbActivePower() == null ? other.getbActivePower() == null : this.getbActivePower().equals(other.getbActivePower()))
            && (this.getcActivePower() == null ? other.getcActivePower() == null : this.getcActivePower().equals(other.getcActivePower()))
            && (this.getTotalActivePower() == null ? other.getTotalActivePower() == null : this.getTotalActivePower().equals(other.getTotalActivePower()))
            && (this.getTotalActiveEnergy() == null ? other.getTotalActiveEnergy() == null : this.getTotalActiveEnergy().equals(other.getTotalActiveEnergy()))
            && (this.getTotalReactiveEnergy() == null ? other.getTotalReactiveEnergy() == null : this.getTotalReactiveEnergy().equals(other.getTotalReactiveEnergy()))
            && (this.getaPowerFactor() == null ? other.getaPowerFactor() == null : this.getaPowerFactor().equals(other.getaPowerFactor()))
            && (this.getbPowerFactor() == null ? other.getbPowerFactor() == null : this.getbPowerFactor().equals(other.getbPowerFactor()))
            && (this.getcPowerFactor() == null ? other.getcPowerFactor() == null : this.getcPowerFactor().equals(other.getcPowerFactor()))
            && (this.getTotalPowerFactor() == null ? other.getTotalPowerFactor() == null : this.getTotalPowerFactor().equals(other.getTotalPowerFactor()))
            && (this.getEnergy() == null ? other.getEnergy() == null : this.getEnergy().equals(other.getEnergy()))
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
        result = prime * result + ((getaVoltage() == null) ? 0 : getaVoltage().hashCode());
        result = prime * result + ((getbVoltage() == null) ? 0 : getbVoltage().hashCode());
        result = prime * result + ((getcVoltage() == null) ? 0 : getcVoltage().hashCode());
        result = prime * result + ((getaElectricity() == null) ? 0 : getaElectricity().hashCode());
        result = prime * result + ((getbElectricity() == null) ? 0 : getbElectricity().hashCode());
        result = prime * result + ((getcElectricity() == null) ? 0 : getcElectricity().hashCode());
        result = prime * result + ((getaActivePower() == null) ? 0 : getaActivePower().hashCode());
        result = prime * result + ((getbActivePower() == null) ? 0 : getbActivePower().hashCode());
        result = prime * result + ((getcActivePower() == null) ? 0 : getcActivePower().hashCode());
        result = prime * result + ((getTotalActivePower() == null) ? 0 : getTotalActivePower().hashCode());
        result = prime * result + ((getTotalActiveEnergy() == null) ? 0 : getTotalActiveEnergy().hashCode());
        result = prime * result + ((getTotalReactiveEnergy() == null) ? 0 : getTotalReactiveEnergy().hashCode());
        result = prime * result + ((getaPowerFactor() == null) ? 0 : getaPowerFactor().hashCode());
        result = prime * result + ((getbPowerFactor() == null) ? 0 : getbPowerFactor().hashCode());
        result = prime * result + ((getcPowerFactor() == null) ? 0 : getcPowerFactor().hashCode());
        result = prime * result + ((getTotalPowerFactor() == null) ? 0 : getTotalPowerFactor().hashCode());
        result = prime * result + ((getEnergy() == null) ? 0 : getEnergy().hashCode());
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
        sb.append(", aVoltage=").append(aVoltage);
        sb.append(", bVoltage=").append(bVoltage);
        sb.append(", cVoltage=").append(cVoltage);
        sb.append(", aElectricity=").append(aElectricity);
        sb.append(", bElectricity=").append(bElectricity);
        sb.append(", cElectricity=").append(cElectricity);
        sb.append(", aActivePower=").append(aActivePower);
        sb.append(", bActivePower=").append(bActivePower);
        sb.append(", cActivePower=").append(cActivePower);
        sb.append(", totalActivePower=").append(totalActivePower);
        sb.append(", totalActiveEnergy=").append(totalActiveEnergy);
        sb.append(", totalReactiveEnergy=").append(totalReactiveEnergy);
        sb.append(", aPowerFactor=").append(aPowerFactor);
        sb.append(", bPowerFactor=").append(bPowerFactor);
        sb.append(", cPowerFactor=").append(cPowerFactor);
        sb.append(", totalPowerFactor=").append(totalPowerFactor);
        sb.append(", energy=").append(energy);
        sb.append(", eleboxPower=").append(eleboxPower);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}