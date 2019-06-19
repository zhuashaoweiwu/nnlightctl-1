package com.nnlightctl.vo;

public class DeployEleboxView {

    private Long id;

    private String projectName;//项目名称

    private Integer electricityMeterCount;//电表数量

    private Integer centralizeControllerCount;//集中控制器数量

    private Integer modleCount;  //开关模块数量

    private Integer photoperiodCount;//光照技数量

    private String  longitude;//经度

    private String  latitude;//纬度

    private String   mem;//备注

    private String   codeNumber;

    public String getCodeNumber() {
        return codeNumber;
    }

    public void setCodeNumber(String codeNumber) {
        this.codeNumber = codeNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Integer getElectricityMeterCount() {
        return electricityMeterCount;
    }

    public void setElectricityMeterCount(Integer electricityMeterCount) {
        this.electricityMeterCount = electricityMeterCount;
    }

    public Integer getCentralizeControllerCount() {
        return centralizeControllerCount;
    }

    public void setCentralizeControllerCount(Integer centralizeControllerCount) {
        this.centralizeControllerCount = centralizeControllerCount;
    }

    public Integer getModleCount() {
        return modleCount;
    }

    public void setModleCount(Integer modleCount) {
        this.modleCount = modleCount;
    }

    public Integer getPhotoperiodCount() {
        return photoperiodCount;
    }

    public void setPhotoperiodCount(Integer photoperiodCount) {
        this.photoperiodCount = photoperiodCount;
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

    public String getMem() {
        return mem;
    }

    public void setMem(String mem) {
        this.mem = mem;
    }
}
