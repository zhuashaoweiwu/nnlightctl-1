package com.nnlightctl.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class LightingVolEleRecord implements Serializable {
    private Long id;

    private Date gmtCreated;

    private Date gmtUpdated;

    private String uid;

    private Date recordDatetime;

    private BigDecimal voltage;

    private BigDecimal electricty;

    private BigDecimal energy;

    private BigDecimal dampness;

    private BigDecimal temperature;

    private BigDecimal beam;

    private BigDecimal persist1;

    private BigDecimal persist2;

    private BigDecimal persist3;

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

    public Date getRecordDatetime() {
        return recordDatetime;
    }

    public void setRecordDatetime(Date recordDatetime) {
        this.recordDatetime = recordDatetime;
    }

    public BigDecimal getVoltage() {
        return voltage;
    }

    public void setVoltage(BigDecimal voltage) {
        this.voltage = voltage;
    }

    public BigDecimal getElectricty() {
        return electricty;
    }

    public void setElectricty(BigDecimal electricty) {
        this.electricty = electricty;
    }

    public BigDecimal getEnergy() {
        return energy;
    }

    public void setEnergy(BigDecimal energy) {
        this.energy = energy;
    }

    public BigDecimal getDampness() {
        return dampness;
    }

    public void setDampness(BigDecimal dampness) {
        this.dampness = dampness;
    }

    public BigDecimal getTemperature() {
        return temperature;
    }

    public void setTemperature(BigDecimal temperature) {
        this.temperature = temperature;
    }

    public BigDecimal getBeam() {
        return beam;
    }

    public void setBeam(BigDecimal beam) {
        this.beam = beam;
    }

    public BigDecimal getPersist1() {
        return persist1;
    }

    public void setPersist1(BigDecimal persist1) {
        this.persist1 = persist1;
    }

    public BigDecimal getPersist2() {
        return persist2;
    }

    public void setPersist2(BigDecimal persist2) {
        this.persist2 = persist2;
    }

    public BigDecimal getPersist3() {
        return persist3;
    }

    public void setPersist3(BigDecimal persist3) {
        this.persist3 = persist3;
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
        LightingVolEleRecord other = (LightingVolEleRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGmtCreated() == null ? other.getGmtCreated() == null : this.getGmtCreated().equals(other.getGmtCreated()))
            && (this.getGmtUpdated() == null ? other.getGmtUpdated() == null : this.getGmtUpdated().equals(other.getGmtUpdated()))
            && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getRecordDatetime() == null ? other.getRecordDatetime() == null : this.getRecordDatetime().equals(other.getRecordDatetime()))
            && (this.getVoltage() == null ? other.getVoltage() == null : this.getVoltage().equals(other.getVoltage()))
            && (this.getElectricty() == null ? other.getElectricty() == null : this.getElectricty().equals(other.getElectricty()))
            && (this.getEnergy() == null ? other.getEnergy() == null : this.getEnergy().equals(other.getEnergy()))
            && (this.getDampness() == null ? other.getDampness() == null : this.getDampness().equals(other.getDampness()))
            && (this.getTemperature() == null ? other.getTemperature() == null : this.getTemperature().equals(other.getTemperature()))
            && (this.getBeam() == null ? other.getBeam() == null : this.getBeam().equals(other.getBeam()))
            && (this.getPersist1() == null ? other.getPersist1() == null : this.getPersist1().equals(other.getPersist1()))
            && (this.getPersist2() == null ? other.getPersist2() == null : this.getPersist2().equals(other.getPersist2()))
            && (this.getPersist3() == null ? other.getPersist3() == null : this.getPersist3().equals(other.getPersist3()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGmtCreated() == null) ? 0 : getGmtCreated().hashCode());
        result = prime * result + ((getGmtUpdated() == null) ? 0 : getGmtUpdated().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getRecordDatetime() == null) ? 0 : getRecordDatetime().hashCode());
        result = prime * result + ((getVoltage() == null) ? 0 : getVoltage().hashCode());
        result = prime * result + ((getElectricty() == null) ? 0 : getElectricty().hashCode());
        result = prime * result + ((getEnergy() == null) ? 0 : getEnergy().hashCode());
        result = prime * result + ((getDampness() == null) ? 0 : getDampness().hashCode());
        result = prime * result + ((getTemperature() == null) ? 0 : getTemperature().hashCode());
        result = prime * result + ((getBeam() == null) ? 0 : getBeam().hashCode());
        result = prime * result + ((getPersist1() == null) ? 0 : getPersist1().hashCode());
        result = prime * result + ((getPersist2() == null) ? 0 : getPersist2().hashCode());
        result = prime * result + ((getPersist3() == null) ? 0 : getPersist3().hashCode());
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
        sb.append(", recordDatetime=").append(recordDatetime);
        sb.append(", voltage=").append(voltage);
        sb.append(", electricty=").append(electricty);
        sb.append(", energy=").append(energy);
        sb.append(", dampness=").append(dampness);
        sb.append(", temperature=").append(temperature);
        sb.append(", beam=").append(beam);
        sb.append(", persist1=").append(persist1);
        sb.append(", persist2=").append(persist2);
        sb.append(", persist3=").append(persist3);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}