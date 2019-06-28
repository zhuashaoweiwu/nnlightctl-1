package com.nnlightctl.request;

import org.hibernate.validator.constraints.NotEmpty;

public class ProjectRequest extends BaseRequest {

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getMem() {
        return mem;
    }

    public void setMem(String mem) {
        this.mem = mem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
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

    public void setNnlightctlProjectCityId(Long nnlightctrlProjectCityId) {
        this.nnlightctlProjectCityId = nnlightctrlProjectCityId;
    }

    private Long id;
    private Long nnlightctlProjectCountryId;
    private Long nnlightctlProjectProvinceId;
    private Long nnlightctlProjectCityId;
    private String longitude;
    private String latitude;
    private int state;
    private int type;
    @NotEmpty(message = "项目名称不能为空！")
    private String projectName;
    @NotEmpty(message = "项目编号不能为空！")
    private String projectCode;
    private String mem;
}
