package com.nnlightctl.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Elebox implements Serializable {
    private Long id;

    private Date gmtCreated;

    private Date gmtUpdated;

    private String uid;

    private String networkAddr;

    private String realtimeUid;

    private String codeNumber;

    private Date manufacture;

    private String longitude;

    private String latitude;

    private Date useDate;

    private BigDecimal ratedVoltage;

    private BigDecimal ratedElectricty;

    private BigDecimal powerRating;

    private Long maxUseTime;

    private String spd;

    private String modbusEm;

    private String mainSwitch;

    private Long nnlightctlEleboxGisId;

    private Long nnlightctlRegionId;

    private Long nnlightctlProjectId;

    private String eleboxModel; //控制柜型号

    private String eleboxName; //控制柜名称

    private String materialQuality;//材质

    private String eleboxColors;//外观颜色

    private String eleboxSize;//尺寸

    private String mem;//备注


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

    public String getNetworkAddr() {
        return networkAddr;
    }

    public void setNetworkAddr(String networkAddr) {
        this.networkAddr = networkAddr == null ? null : networkAddr.trim();
    }

    public String getRealtimeUid() {
        return realtimeUid;
    }

    public void setRealtimeUid(String realtimeUid) {
        this.realtimeUid = realtimeUid == null ? null : realtimeUid.trim();
    }

    public String getCodeNumber() {
        return codeNumber;
    }

    public void setCodeNumber(String codeNumber) {
        this.codeNumber = codeNumber == null ? null : codeNumber.trim();
    }

    public Date getManufacture() {
        return manufacture;
    }

    public void setManufacture(Date manufacture) {
        this.manufacture = manufacture;
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

    public Date getUseDate() {
        return useDate;
    }

    public void setUseDate(Date useDate) {
        this.useDate = useDate;
    }

    public BigDecimal getRatedVoltage() {
        return ratedVoltage;
    }

    public void setRatedVoltage(BigDecimal ratedVoltage) {
        this.ratedVoltage = ratedVoltage;
    }

    public BigDecimal getRatedElectricty() {
        return ratedElectricty;
    }

    public void setRatedElectricty(BigDecimal ratedElectricty) {
        this.ratedElectricty = ratedElectricty;
    }

    public BigDecimal getPowerRating() {
        return powerRating;
    }

    public void setPowerRating(BigDecimal powerRating) {
        this.powerRating = powerRating;
    }

    public Long getMaxUseTime() {
        return maxUseTime;
    }

    public void setMaxUseTime(Long maxUseTime) {
        this.maxUseTime = maxUseTime;
    }

    public String getSpd() {
        return spd;
    }

    public void setSpd(String spd) {
        this.spd = spd == null ? null : spd.trim();
    }

    public String getModbusEm() {
        return modbusEm;
    }

    public void setModbusEm(String modbusEm) {
        this.modbusEm = modbusEm == null ? null : modbusEm.trim();
    }

    public String getMainSwitch() {
        return mainSwitch;
    }

    public void setMainSwitch(String mainSwitch) {
        this.mainSwitch = mainSwitch == null ? null : mainSwitch.trim();
    }

    public Long getNnlightctlEleboxGisId() {
        return nnlightctlEleboxGisId;
    }

    public void setNnlightctlEleboxGisId(Long nnlightctlEleboxGisId) {
        this.nnlightctlEleboxGisId = nnlightctlEleboxGisId;
    }

    public Long getNnlightctlRegionId() {
        return nnlightctlRegionId;
    }

    public void setNnlightctlRegionId(Long nnlightctlRegionId) {
        this.nnlightctlRegionId = nnlightctlRegionId;
    }

    public Long getNnlightctlProjectId() {
        return nnlightctlProjectId;
    }

    public void setNnlightctlProjectId(Long nnlightctlProjectId) {
        this.nnlightctlProjectId = nnlightctlProjectId;
    }


    public String getEleboxModel() {
        return eleboxModel;
    }

    public void setEleboxModel(String eleboxModel) {
        this.eleboxModel = eleboxModel;
    }

    public String getEleboxName() {
        return eleboxName;
    }

    public void setEleboxName(String eleboxName) {
        this.eleboxName = eleboxName;
    }

    public String getMaterialQuality() {
        return materialQuality;
    }

    public void setMaterialQuality(String materialQuality) {
        this.materialQuality = materialQuality;
    }

    public String getEleboxColors() {
        return eleboxColors;
    }

    public void setEleboxColors(String eleboxColors) {
        this.eleboxColors = eleboxColors;
    }

    public String getEleboxSize() {
        return eleboxSize;
    }

    public void setEleboxSize(String eleboxSize) {
        this.eleboxSize = eleboxSize;
    }

    public String getMem() {
        return mem;
    }

    public void setMem(String mem) {
        this.mem = mem;
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
        Elebox other = (Elebox) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGmtCreated() == null ? other.getGmtCreated() == null : this.getGmtCreated().equals(other.getGmtCreated()))
            && (this.getGmtUpdated() == null ? other.getGmtUpdated() == null : this.getGmtUpdated().equals(other.getGmtUpdated()))
            && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getNetworkAddr() == null ? other.getNetworkAddr() == null : this.getNetworkAddr().equals(other.getNetworkAddr()))
            && (this.getRealtimeUid() == null ? other.getRealtimeUid() == null : this.getRealtimeUid().equals(other.getRealtimeUid()))
            && (this.getCodeNumber() == null ? other.getCodeNumber() == null : this.getCodeNumber().equals(other.getCodeNumber()))
            && (this.getManufacture() == null ? other.getManufacture() == null : this.getManufacture().equals(other.getManufacture()))
            && (this.getLongitude() == null ? other.getLongitude() == null : this.getLongitude().equals(other.getLongitude()))
            && (this.getLatitude() == null ? other.getLatitude() == null : this.getLatitude().equals(other.getLatitude()))
            && (this.getUseDate() == null ? other.getUseDate() == null : this.getUseDate().equals(other.getUseDate()))
            && (this.getRatedVoltage() == null ? other.getRatedVoltage() == null : this.getRatedVoltage().equals(other.getRatedVoltage()))
            && (this.getRatedElectricty() == null ? other.getRatedElectricty() == null : this.getRatedElectricty().equals(other.getRatedElectricty()))
            && (this.getPowerRating() == null ? other.getPowerRating() == null : this.getPowerRating().equals(other.getPowerRating()))
            && (this.getMaxUseTime() == null ? other.getMaxUseTime() == null : this.getMaxUseTime().equals(other.getMaxUseTime()))
            && (this.getSpd() == null ? other.getSpd() == null : this.getSpd().equals(other.getSpd()))
            && (this.getModbusEm() == null ? other.getModbusEm() == null : this.getModbusEm().equals(other.getModbusEm()))
            && (this.getMainSwitch() == null ? other.getMainSwitch() == null : this.getMainSwitch().equals(other.getMainSwitch()))
            && (this.getNnlightctlEleboxGisId() == null ? other.getNnlightctlEleboxGisId() == null : this.getNnlightctlEleboxGisId().equals(other.getNnlightctlEleboxGisId()))
            && (this.getNnlightctlRegionId() == null ? other.getNnlightctlRegionId() == null : this.getNnlightctlRegionId().equals(other.getNnlightctlRegionId()))
            && (this.getNnlightctlProjectId() == null ? other.getNnlightctlProjectId() == null : this.getNnlightctlProjectId().equals(other.getNnlightctlProjectId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGmtCreated() == null) ? 0 : getGmtCreated().hashCode());
        result = prime * result + ((getGmtUpdated() == null) ? 0 : getGmtUpdated().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getNetworkAddr() == null) ? 0 : getNetworkAddr().hashCode());
        result = prime * result + ((getRealtimeUid() == null) ? 0 : getRealtimeUid().hashCode());
        result = prime * result + ((getCodeNumber() == null) ? 0 : getCodeNumber().hashCode());
        result = prime * result + ((getManufacture() == null) ? 0 : getManufacture().hashCode());
        result = prime * result + ((getLongitude() == null) ? 0 : getLongitude().hashCode());
        result = prime * result + ((getLatitude() == null) ? 0 : getLatitude().hashCode());
        result = prime * result + ((getUseDate() == null) ? 0 : getUseDate().hashCode());
        result = prime * result + ((getRatedVoltage() == null) ? 0 : getRatedVoltage().hashCode());
        result = prime * result + ((getRatedElectricty() == null) ? 0 : getRatedElectricty().hashCode());
        result = prime * result + ((getPowerRating() == null) ? 0 : getPowerRating().hashCode());
        result = prime * result + ((getMaxUseTime() == null) ? 0 : getMaxUseTime().hashCode());
        result = prime * result + ((getSpd() == null) ? 0 : getSpd().hashCode());
        result = prime * result + ((getModbusEm() == null) ? 0 : getModbusEm().hashCode());
        result = prime * result + ((getMainSwitch() == null) ? 0 : getMainSwitch().hashCode());
        result = prime * result + ((getNnlightctlEleboxGisId() == null) ? 0 : getNnlightctlEleboxGisId().hashCode());
        result = prime * result + ((getNnlightctlRegionId() == null) ? 0 : getNnlightctlRegionId().hashCode());
        result = prime * result + ((getNnlightctlProjectId() == null) ? 0 : getNnlightctlProjectId().hashCode());
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
        sb.append(", networkAddr=").append(networkAddr);
        sb.append(", realtimeUid=").append(realtimeUid);
        sb.append(", codeNumber=").append(codeNumber);
        sb.append(", manufacture=").append(manufacture);
        sb.append(", longitude=").append(longitude);
        sb.append(", latitude=").append(latitude);
        sb.append(", useDate=").append(useDate);
        sb.append(", ratedVoltage=").append(ratedVoltage);
        sb.append(", ratedElectricty=").append(ratedElectricty);
        sb.append(", powerRating=").append(powerRating);
        sb.append(", maxUseTime=").append(maxUseTime);
        sb.append(", spd=").append(spd);
        sb.append(", modbusEm=").append(modbusEm);
        sb.append(", mainSwitch=").append(mainSwitch);
        sb.append(", nnlightctlEleboxGisId=").append(nnlightctlEleboxGisId);
        sb.append(", nnlightctlRegionId=").append(nnlightctlRegionId);
        sb.append(", nnlightctlProjectId=").append(nnlightctlProjectId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}