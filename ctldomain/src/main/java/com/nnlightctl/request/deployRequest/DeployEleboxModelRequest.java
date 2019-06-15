package com.nnlightctl.request.deployRequest;

import com.nnlightctl.request.BaseRequest;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class DeployEleboxModelRequest  extends BaseRequest {

    private Long id;

    private Long nnlightctlEleboxId;

    private Date gmtCreated;

    private Date gmtUpdated;

    private String uid;

    @NotNull(message = "模块编码不能为空！")
    private String modelCode;

    @NotNull(message = "模块名称不能为空！")
    private String modelName;

    private String modelType;

    @NotNull(message = "回路数量不能为空！")
    private Byte loopCount;

    private String CommunicationMethods;// 通讯方式

    private String maxElectric;//单回路最大电流

    private String loadElectric;//最大负载电流

    private String InstallationMethods;//安装方式

    private String mem;//备注


    public Long getNnlightctlEleboxId() {
        return nnlightctlEleboxId;
    }

    public void setNnlightctlEleboxId(Long nnlightctlEleboxId) {
        this.nnlightctlEleboxId = nnlightctlEleboxId;
    }

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
        this.uid = uid;
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }

    public Byte getLoopCount() {
        return loopCount;
    }

    public void setLoopCount(Byte loopCount) {
        this.loopCount = loopCount;
    }

    public String getCommunicationMethods() {
        return CommunicationMethods;
    }

    public void setCommunicationMethods(String communicationMethods) {
        CommunicationMethods = communicationMethods;
    }

    public String getMaxElectric() {
        return maxElectric;
    }

    public void setMaxElectric(String maxElectric) {
        this.maxElectric = maxElectric;
    }

    public String getLoadElectric() {
        return loadElectric;
    }

    public void setLoadElectric(String loadElectric) {
        this.loadElectric = loadElectric;
    }

    public String getInstallationMethods() {
        return InstallationMethods;
    }

    public void setInstallationMethods(String installationMethods) {
        InstallationMethods = installationMethods;
    }

    public String getMem() {
        return mem;
    }

    public void setMem(String mem) {
        this.mem = mem;
    }
}
