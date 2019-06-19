package com.nnlightctl.request.deployRequest;

public class DeployLightingRequest {
    /**
     * 单灯控制器的型号
     */
    private Long lampControllerId;

    private String lampModel;

    /**
     * 灯具的型号
     */
    private Long nnlightctlLampModelId;

    private String ModelType;

    /**
     * 灯具的imei
     */
    private String equipmentNumber;


    private Long nnlightctlLamppostId;

    /**
     * 灯杆的型号
     */
    private String lamppostModel;

    /**
     * 灯头数
     */
    private int lamppostNumber;

    /**
     * 项目
     */
    private Long nnlightctlProjectId;

    private String projectName;

    /**
     * 备注
     */
    private String mem;

    /**
     * 灯具的功率
     */
    private Double staticPower;

    public String getModelType() {
        return ModelType;
    }

    public void setModelType(String modelType) {
        ModelType = modelType;
    }

    public String getLampModel() {
        return lampModel;
    }

    public void setLampModel(String lampModel) {
        this.lampModel = lampModel;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Long getLampControllerId() {
        return lampControllerId;
    }

    public void setLampControllerId(Long lampControllerId) {
        this.lampControllerId = lampControllerId;
    }

    public Long getNnlightctlLampModelId() {
        return nnlightctlLampModelId;
    }

    public void setNnlightctlLampModelId(Long nnlightctlLampModelId) {
        this.nnlightctlLampModelId = nnlightctlLampModelId;
    }

    public Long getNnlightctlLamppostId() {
        return nnlightctlLamppostId;
    }

    public void setNnlightctlLamppostId(Long nnlightctlLamppostId) {
        this.nnlightctlLamppostId = nnlightctlLamppostId;
    }

    public Long getNnlightctlProjectId() {
        return nnlightctlProjectId;
    }

    public void setNnlightctlProjectId(Long nnlightctlProjectId) {
        this.nnlightctlProjectId = nnlightctlProjectId;
    }


    public String getEquipmentNumber() {
        return equipmentNumber;
    }

    public void setEquipmentNumber(String equipmentNumber) {
        this.equipmentNumber = equipmentNumber;
    }

    public String getLamppostModel() {
        return lamppostModel;
    }

    public void setLamppostModel(String lamppostModel) {
        this.lamppostModel = lamppostModel;
    }

    public int getLamppostNumber() {
        return lamppostNumber;
    }

    public void setLamppostNumber(int lamppostNumber) {
        this.lamppostNumber = lamppostNumber;
    }


    public String getMem() {
        return mem;
    }

    public void setMem(String mem) {
        this.mem = mem;
    }

    public Double getStaticPower() {
        return staticPower;
    }

    public void setStaticPower(Double staticPower) {
        this.staticPower = staticPower;
    }
}
