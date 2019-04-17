package com.nnlightctl.po;

import java.io.Serializable;
import java.util.Date;

public class Project implements Serializable {
    private Long id;

    private Date gmtCreated;

    private Date gmtUpdated;

    private String codeNumber;

    private String projectName;

    private Byte ctype;

    private Long nnlightctlProjectCountryId;

    private Long nnlightctlProjectProvinceId;

    private Long nnlightctlProjectCityId;

    private Long nnlightctlInstitutionId;

    private String longitude;

    private String latitude;

    private String mem;

    private Byte state;

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

    public String getCodeNumber() {
        return codeNumber;
    }

    public void setCodeNumber(String codeNumber) {
        this.codeNumber = codeNumber == null ? null : codeNumber.trim();
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public Byte getCtype() {
        return ctype;
    }

    public void setCtype(Byte ctype) {
        this.ctype = ctype;
    }

    public Long getNnlightctlProjectCountryId() {
        return nnlightctlProjectCountryId;
    }

    public void setNnlightctlProjectCountryId(Long nnlightctlProjectCountryId) {
        this.nnlightctlProjectCountryId = nnlightctlProjectCountryId;
    }

    public Long getNnlightctlProjectProvinceId() {
        return nnlightctlProjectProvinceId;
    }

    public void setNnlightctlProjectProvinceId(Long nnlightctlProjectProvinceId) {
        this.nnlightctlProjectProvinceId = nnlightctlProjectProvinceId;
    }

    public Long getNnlightctlProjectCityId() {
        return nnlightctlProjectCityId;
    }

    public void setNnlightctlProjectCityId(Long nnlightctlProjectCityId) {
        this.nnlightctlProjectCityId = nnlightctlProjectCityId;
    }

    public Long getNnlightctlInstitutionId() {
        return nnlightctlInstitutionId;
    }

    public void setNnlightctlInstitutionId(Long nnlightctlInstitutionId) {
        this.nnlightctlInstitutionId = nnlightctlInstitutionId;
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

    public String getMem() {
        return mem;
    }

    public void setMem(String mem) {
        this.mem = mem == null ? null : mem.trim();
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
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
        Project other = (Project) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGmtCreated() == null ? other.getGmtCreated() == null : this.getGmtCreated().equals(other.getGmtCreated()))
            && (this.getGmtUpdated() == null ? other.getGmtUpdated() == null : this.getGmtUpdated().equals(other.getGmtUpdated()))
            && (this.getCodeNumber() == null ? other.getCodeNumber() == null : this.getCodeNumber().equals(other.getCodeNumber()))
            && (this.getProjectName() == null ? other.getProjectName() == null : this.getProjectName().equals(other.getProjectName()))
            && (this.getCtype() == null ? other.getCtype() == null : this.getCtype().equals(other.getCtype()))
            && (this.getNnlightctlProjectCountryId() == null ? other.getNnlightctlProjectCountryId() == null : this.getNnlightctlProjectCountryId().equals(other.getNnlightctlProjectCountryId()))
            && (this.getNnlightctlProjectProvinceId() == null ? other.getNnlightctlProjectProvinceId() == null : this.getNnlightctlProjectProvinceId().equals(other.getNnlightctlProjectProvinceId()))
            && (this.getNnlightctlProjectCityId() == null ? other.getNnlightctlProjectCityId() == null : this.getNnlightctlProjectCityId().equals(other.getNnlightctlProjectCityId()))
            && (this.getNnlightctlInstitutionId() == null ? other.getNnlightctlInstitutionId() == null : this.getNnlightctlInstitutionId().equals(other.getNnlightctlInstitutionId()))
            && (this.getLongitude() == null ? other.getLongitude() == null : this.getLongitude().equals(other.getLongitude()))
            && (this.getLatitude() == null ? other.getLatitude() == null : this.getLatitude().equals(other.getLatitude()))
            && (this.getMem() == null ? other.getMem() == null : this.getMem().equals(other.getMem()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGmtCreated() == null) ? 0 : getGmtCreated().hashCode());
        result = prime * result + ((getGmtUpdated() == null) ? 0 : getGmtUpdated().hashCode());
        result = prime * result + ((getCodeNumber() == null) ? 0 : getCodeNumber().hashCode());
        result = prime * result + ((getProjectName() == null) ? 0 : getProjectName().hashCode());
        result = prime * result + ((getCtype() == null) ? 0 : getCtype().hashCode());
        result = prime * result + ((getNnlightctlProjectCountryId() == null) ? 0 : getNnlightctlProjectCountryId().hashCode());
        result = prime * result + ((getNnlightctlProjectProvinceId() == null) ? 0 : getNnlightctlProjectProvinceId().hashCode());
        result = prime * result + ((getNnlightctlProjectCityId() == null) ? 0 : getNnlightctlProjectCityId().hashCode());
        result = prime * result + ((getNnlightctlInstitutionId() == null) ? 0 : getNnlightctlInstitutionId().hashCode());
        result = prime * result + ((getLongitude() == null) ? 0 : getLongitude().hashCode());
        result = prime * result + ((getLatitude() == null) ? 0 : getLatitude().hashCode());
        result = prime * result + ((getMem() == null) ? 0 : getMem().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
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
        sb.append(", codeNumber=").append(codeNumber);
        sb.append(", projectName=").append(projectName);
        sb.append(", ctype=").append(ctype);
        sb.append(", nnlightctlProjectCountryId=").append(nnlightctlProjectCountryId);
        sb.append(", nnlightctlProjectProvinceId=").append(nnlightctlProjectProvinceId);
        sb.append(", nnlightctlProjectCityId=").append(nnlightctlProjectCityId);
        sb.append(", nnlightctlInstitutionId=").append(nnlightctlInstitutionId);
        sb.append(", longitude=").append(longitude);
        sb.append(", latitude=").append(latitude);
        sb.append(", mem=").append(mem);
        sb.append(", state=").append(state);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}