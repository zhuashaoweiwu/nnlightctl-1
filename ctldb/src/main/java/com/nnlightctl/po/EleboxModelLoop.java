package com.nnlightctl.po;

import java.io.Serializable;
import java.util.Date;

public class EleboxModelLoop implements Serializable {
    private Long id;

    private Date gmtCreated;

    private Date gmtUpdated;

    private Long voltage;

    private Long electricity;

    private Byte lightCount;

    private Byte state;

    private Long nnlightctlEleboxModelId;

    private String loopCode;

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

    public Long getVoltage() {
        return voltage;
    }

    public void setVoltage(Long voltage) {
        this.voltage = voltage;
    }

    public Long getElectricity() {
        return electricity;
    }

    public void setElectricity(Long electricity) {
        this.electricity = electricity;
    }

    public Byte getLightCount() {
        return lightCount;
    }

    public void setLightCount(Byte lightCount) {
        this.lightCount = lightCount;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Long getNnlightctlEleboxModelId() {
        return nnlightctlEleboxModelId;
    }

    public void setNnlightctlEleboxModelId(Long nnlightctlEleboxModelId) {
        this.nnlightctlEleboxModelId = nnlightctlEleboxModelId;
    }

    public String getLoopCode() {
        return loopCode;
    }

    public void setLoopCode(String loopCode) {
        this.loopCode = loopCode == null ? null : loopCode.trim();
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
        EleboxModelLoop other = (EleboxModelLoop) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGmtCreated() == null ? other.getGmtCreated() == null : this.getGmtCreated().equals(other.getGmtCreated()))
            && (this.getGmtUpdated() == null ? other.getGmtUpdated() == null : this.getGmtUpdated().equals(other.getGmtUpdated()))
            && (this.getVoltage() == null ? other.getVoltage() == null : this.getVoltage().equals(other.getVoltage()))
            && (this.getElectricity() == null ? other.getElectricity() == null : this.getElectricity().equals(other.getElectricity()))
            && (this.getLightCount() == null ? other.getLightCount() == null : this.getLightCount().equals(other.getLightCount()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getNnlightctlEleboxModelId() == null ? other.getNnlightctlEleboxModelId() == null : this.getNnlightctlEleboxModelId().equals(other.getNnlightctlEleboxModelId()))
            && (this.getLoopCode() == null ? other.getLoopCode() == null : this.getLoopCode().equals(other.getLoopCode()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGmtCreated() == null) ? 0 : getGmtCreated().hashCode());
        result = prime * result + ((getGmtUpdated() == null) ? 0 : getGmtUpdated().hashCode());
        result = prime * result + ((getVoltage() == null) ? 0 : getVoltage().hashCode());
        result = prime * result + ((getElectricity() == null) ? 0 : getElectricity().hashCode());
        result = prime * result + ((getLightCount() == null) ? 0 : getLightCount().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getNnlightctlEleboxModelId() == null) ? 0 : getNnlightctlEleboxModelId().hashCode());
        result = prime * result + ((getLoopCode() == null) ? 0 : getLoopCode().hashCode());
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
        sb.append(", voltage=").append(voltage);
        sb.append(", electricity=").append(electricity);
        sb.append(", lightCount=").append(lightCount);
        sb.append(", state=").append(state);
        sb.append(", nnlightctlEleboxModelId=").append(nnlightctlEleboxModelId);
        sb.append(", loopCode=").append(loopCode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}