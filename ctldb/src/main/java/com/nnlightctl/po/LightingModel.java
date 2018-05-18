package com.nnlightctl.po;

import java.io.Serializable;
import java.util.Date;

public class LightingModel implements Serializable {
    private Long id;

    private Date gmtCreated;

    private Date gmtUpdated;

    private String modelName;

    private Long ratedVoltage;

    private Long ratedElectric;

    private Long ratedPower;

    private Byte ledCount;

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

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName == null ? null : modelName.trim();
    }

    public Long getRatedVoltage() {
        return ratedVoltage;
    }

    public void setRatedVoltage(Long ratedVoltage) {
        this.ratedVoltage = ratedVoltage;
    }

    public Long getRatedElectric() {
        return ratedElectric;
    }

    public void setRatedElectric(Long ratedElectric) {
        this.ratedElectric = ratedElectric;
    }

    public Long getRatedPower() {
        return ratedPower;
    }

    public void setRatedPower(Long ratedPower) {
        this.ratedPower = ratedPower;
    }

    public Byte getLedCount() {
        return ledCount;
    }

    public void setLedCount(Byte ledCount) {
        this.ledCount = ledCount;
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
        LightingModel other = (LightingModel) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGmtCreated() == null ? other.getGmtCreated() == null : this.getGmtCreated().equals(other.getGmtCreated()))
            && (this.getGmtUpdated() == null ? other.getGmtUpdated() == null : this.getGmtUpdated().equals(other.getGmtUpdated()))
            && (this.getModelName() == null ? other.getModelName() == null : this.getModelName().equals(other.getModelName()))
            && (this.getRatedVoltage() == null ? other.getRatedVoltage() == null : this.getRatedVoltage().equals(other.getRatedVoltage()))
            && (this.getRatedElectric() == null ? other.getRatedElectric() == null : this.getRatedElectric().equals(other.getRatedElectric()))
            && (this.getRatedPower() == null ? other.getRatedPower() == null : this.getRatedPower().equals(other.getRatedPower()))
            && (this.getLedCount() == null ? other.getLedCount() == null : this.getLedCount().equals(other.getLedCount()))
            && (this.getMem() == null ? other.getMem() == null : this.getMem().equals(other.getMem()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGmtCreated() == null) ? 0 : getGmtCreated().hashCode());
        result = prime * result + ((getGmtUpdated() == null) ? 0 : getGmtUpdated().hashCode());
        result = prime * result + ((getModelName() == null) ? 0 : getModelName().hashCode());
        result = prime * result + ((getRatedVoltage() == null) ? 0 : getRatedVoltage().hashCode());
        result = prime * result + ((getRatedElectric() == null) ? 0 : getRatedElectric().hashCode());
        result = prime * result + ((getRatedPower() == null) ? 0 : getRatedPower().hashCode());
        result = prime * result + ((getLedCount() == null) ? 0 : getLedCount().hashCode());
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
        sb.append(", modelName=").append(modelName);
        sb.append(", ratedVoltage=").append(ratedVoltage);
        sb.append(", ratedElectric=").append(ratedElectric);
        sb.append(", ratedPower=").append(ratedPower);
        sb.append(", ledCount=").append(ledCount);
        sb.append(", mem=").append(mem);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}