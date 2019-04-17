package com.nnlightctl.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class LightingVolEleRecord implements Serializable {
    private Long id;

    private Date gmtCreated;

    private Date gmtUpdated;

    private String uid;

    private String lightimei;

    private Date recordDatetime;

    private BigDecimal voltage;

    private BigDecimal electricty;

    private BigDecimal energy;

    private BigDecimal dampness;

    private BigDecimal temperature;

    private BigDecimal beam;

    private BigDecimal signalIntensity;

    private String longitude;

    private String latitude;

    private String inElectricity;

    private String inVoltage;

    private String elecFrequency;

    private String inActivePower;

    private String inReactivePower;

    private String inSeenPower;

    private String inActiveEnergy;

    private String inReactiveEnergy;

    private String inSeenEnergy;

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

    public String getLightimei() {
        return lightimei;
    }

    public void setLightimei(String lightimei) {
        this.lightimei = lightimei == null ? null : lightimei.trim();
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

    public BigDecimal getSignalIntensity() {
        return signalIntensity;
    }

    public void setSignalIntensity(BigDecimal signalIntensity) {
        this.signalIntensity = signalIntensity;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    public String getInElectricity() {
        return inElectricity;
    }

    public void setInElectricity(String inElectricity) {
        this.inElectricity = inElectricity == null ? null : inElectricity.trim();
    }

    public String getInVoltage() {
        return inVoltage;
    }

    public void setInVoltage(String inVoltage) {
        this.inVoltage = inVoltage == null ? null : inVoltage.trim();
    }

    public String getElecFrequency() {
        return elecFrequency;
    }

    public void setElecFrequency(String elecFrequency) {
        this.elecFrequency = elecFrequency == null ? null : elecFrequency.trim();
    }

    public String getInActivePower() {
        return inActivePower;
    }

    public void setInActivePower(String inActivePower) {
        this.inActivePower = inActivePower == null ? null : inActivePower.trim();
    }

    public String getInReactivePower() {
        return inReactivePower;
    }

    public void setInReactivePower(String inReactivePower) {
        this.inReactivePower = inReactivePower == null ? null : inReactivePower.trim();
    }

    public String getInSeenPower() {
        return inSeenPower;
    }

    public void setInSeenPower(String inSeenPower) {
        this.inSeenPower = inSeenPower == null ? null : inSeenPower.trim();
    }

    public String getInActiveEnergy() {
        return inActiveEnergy;
    }

    public void setInActiveEnergy(String inActiveEnergy) {
        this.inActiveEnergy = inActiveEnergy == null ? null : inActiveEnergy.trim();
    }

    public String getInReactiveEnergy() {
        return inReactiveEnergy;
    }

    public void setInReactiveEnergy(String inReactiveEnergy) {
        this.inReactiveEnergy = inReactiveEnergy == null ? null : inReactiveEnergy.trim();
    }

    public String getInSeenEnergy() {
        return inSeenEnergy;
    }

    public void setInSeenEnergy(String inSeenEnergy) {
        this.inSeenEnergy = inSeenEnergy == null ? null : inSeenEnergy.trim();
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
            && (this.getLightimei() == null ? other.getLightimei() == null : this.getLightimei().equals(other.getLightimei()))
            && (this.getRecordDatetime() == null ? other.getRecordDatetime() == null : this.getRecordDatetime().equals(other.getRecordDatetime()))
            && (this.getVoltage() == null ? other.getVoltage() == null : this.getVoltage().equals(other.getVoltage()))
            && (this.getElectricty() == null ? other.getElectricty() == null : this.getElectricty().equals(other.getElectricty()))
            && (this.getEnergy() == null ? other.getEnergy() == null : this.getEnergy().equals(other.getEnergy()))
            && (this.getDampness() == null ? other.getDampness() == null : this.getDampness().equals(other.getDampness()))
            && (this.getTemperature() == null ? other.getTemperature() == null : this.getTemperature().equals(other.getTemperature()))
            && (this.getBeam() == null ? other.getBeam() == null : this.getBeam().equals(other.getBeam()))
            && (this.getSignalIntensity() == null ? other.getSignalIntensity() == null : this.getSignalIntensity().equals(other.getSignalIntensity()))
            && (this.getLongitude() == null ? other.getLongitude() == null : this.getLongitude().equals(other.getLongitude()))
            && (this.getLatitude() == null ? other.getLatitude() == null : this.getLatitude().equals(other.getLatitude()))
            && (this.getInElectricity() == null ? other.getInElectricity() == null : this.getInElectricity().equals(other.getInElectricity()))
            && (this.getInVoltage() == null ? other.getInVoltage() == null : this.getInVoltage().equals(other.getInVoltage()))
            && (this.getElecFrequency() == null ? other.getElecFrequency() == null : this.getElecFrequency().equals(other.getElecFrequency()))
            && (this.getInActivePower() == null ? other.getInActivePower() == null : this.getInActivePower().equals(other.getInActivePower()))
            && (this.getInReactivePower() == null ? other.getInReactivePower() == null : this.getInReactivePower().equals(other.getInReactivePower()))
            && (this.getInSeenPower() == null ? other.getInSeenPower() == null : this.getInSeenPower().equals(other.getInSeenPower()))
            && (this.getInActiveEnergy() == null ? other.getInActiveEnergy() == null : this.getInActiveEnergy().equals(other.getInActiveEnergy()))
            && (this.getInReactiveEnergy() == null ? other.getInReactiveEnergy() == null : this.getInReactiveEnergy().equals(other.getInReactiveEnergy()))
            && (this.getInSeenEnergy() == null ? other.getInSeenEnergy() == null : this.getInSeenEnergy().equals(other.getInSeenEnergy()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGmtCreated() == null) ? 0 : getGmtCreated().hashCode());
        result = prime * result + ((getGmtUpdated() == null) ? 0 : getGmtUpdated().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getLightimei() == null) ? 0 : getLightimei().hashCode());
        result = prime * result + ((getRecordDatetime() == null) ? 0 : getRecordDatetime().hashCode());
        result = prime * result + ((getVoltage() == null) ? 0 : getVoltage().hashCode());
        result = prime * result + ((getElectricty() == null) ? 0 : getElectricty().hashCode());
        result = prime * result + ((getEnergy() == null) ? 0 : getEnergy().hashCode());
        result = prime * result + ((getDampness() == null) ? 0 : getDampness().hashCode());
        result = prime * result + ((getTemperature() == null) ? 0 : getTemperature().hashCode());
        result = prime * result + ((getBeam() == null) ? 0 : getBeam().hashCode());
        result = prime * result + ((getSignalIntensity() == null) ? 0 : getSignalIntensity().hashCode());
        result = prime * result + ((getLongitude() == null) ? 0 : getLongitude().hashCode());
        result = prime * result + ((getLatitude() == null) ? 0 : getLatitude().hashCode());
        result = prime * result + ((getInElectricity() == null) ? 0 : getInElectricity().hashCode());
        result = prime * result + ((getInVoltage() == null) ? 0 : getInVoltage().hashCode());
        result = prime * result + ((getElecFrequency() == null) ? 0 : getElecFrequency().hashCode());
        result = prime * result + ((getInActivePower() == null) ? 0 : getInActivePower().hashCode());
        result = prime * result + ((getInReactivePower() == null) ? 0 : getInReactivePower().hashCode());
        result = prime * result + ((getInSeenPower() == null) ? 0 : getInSeenPower().hashCode());
        result = prime * result + ((getInActiveEnergy() == null) ? 0 : getInActiveEnergy().hashCode());
        result = prime * result + ((getInReactiveEnergy() == null) ? 0 : getInReactiveEnergy().hashCode());
        result = prime * result + ((getInSeenEnergy() == null) ? 0 : getInSeenEnergy().hashCode());
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
        sb.append(", lightimei=").append(lightimei);
        sb.append(", recordDatetime=").append(recordDatetime);
        sb.append(", voltage=").append(voltage);
        sb.append(", electricty=").append(electricty);
        sb.append(", energy=").append(energy);
        sb.append(", dampness=").append(dampness);
        sb.append(", temperature=").append(temperature);
        sb.append(", beam=").append(beam);
        sb.append(", signalIntensity=").append(signalIntensity);
        sb.append(", longitude=").append(longitude);
        sb.append(", latitude=").append(latitude);
        sb.append(", inElectricity=").append(inElectricity);
        sb.append(", inVoltage=").append(inVoltage);
        sb.append(", elecFrequency=").append(elecFrequency);
        sb.append(", inActivePower=").append(inActivePower);
        sb.append(", inReactivePower=").append(inReactivePower);
        sb.append(", inSeenPower=").append(inSeenPower);
        sb.append(", inActiveEnergy=").append(inActiveEnergy);
        sb.append(", inReactiveEnergy=").append(inReactiveEnergy);
        sb.append(", inSeenEnergy=").append(inSeenEnergy);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}