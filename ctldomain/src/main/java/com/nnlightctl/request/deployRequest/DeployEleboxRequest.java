package com.nnlightctl.request.deployRequest;

import com.nnlightctl.request.BaseRequest;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

public class DeployEleboxRequest extends BaseRequest {

    private Long id;

    private String network_addr;

    private String uid;

    private Date gmtUpdated;

    private Date gmtCreated;

    @NotEmpty(message = "模块编码不可为空！")
    private String codeNumber;

    private String longitude;

    private String latitude;

    private Long nnlightctlEleboxGisId;

    private Long nnlightctlRegionId;

    private Long nnlightctlProjectId;

    private String eleboxModel; //控制柜型号

    private String eleboxName; //控制柜名称

    private String materialQuality;//材质

    private String eleboxColors;//外观颜色

    private String eleboxSize;//尺寸

    private String mem;//备注

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

    public String getNetwork_addr() {
        return network_addr;
    }

    public void setNetwork_addr(String network_addr) {
        this.network_addr = network_addr;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Date getGmtUpdated() {
        return gmtUpdated;
    }

    public void setGmtUpdated(Date gmtUpdated) {
        this.gmtUpdated = gmtUpdated;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public String getCodeNumber() {
        return codeNumber;
    }

    public void setCodeNumber(String codeNumber) {
        this.uid        = codeNumber;
        this.codeNumber = codeNumber;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
