package com.nnlightctl.vo;

import java.util.Date;

public class ProjectsToInstitutionView extends BaseView{

    private String institutionName;

    private Date createTime;

    private String addr;

    private String mem;

    private Long nnlightctlInstitutionIdParent;

    private Byte institutionLevel;

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

    private Byte state;


    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getMem() {
        return mem;
    }

    public void setMem(String mem) {
        this.mem = mem;
    }

    public Long getNnlightctlInstitutionIdParent() {
        return nnlightctlInstitutionIdParent;
    }

    public void setNnlightctlInstitutionIdParent(Long nnlightctlInstitutionIdParent) {
        this.nnlightctlInstitutionIdParent = nnlightctlInstitutionIdParent;
    }

    public Byte getInstitutionLevel() {
        return institutionLevel;
    }

    public void setInstitutionLevel(Byte institutionLevel) {
        this.institutionLevel = institutionLevel;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Date getGmtCreated() {
        return gmtCreated;
    }

    @Override
    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    @Override
    public Date getGmtUpdated() {
        return gmtUpdated;
    }

    @Override
    public void setGmtUpdated(Date gmtUpdated) {
        this.gmtUpdated = gmtUpdated;
    }

    public String getCodeNumber() {
        return codeNumber;
    }

    public void setCodeNumber(String codeNumber) {
        this.codeNumber = codeNumber;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
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
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }
}
