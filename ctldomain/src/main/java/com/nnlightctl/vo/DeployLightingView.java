package com.nnlightctl.vo;

public class DeployLightingView {

    private Long id;
    /**
     * 单灯控制器的型号
     */
    private String lampModel;

    /**
     * 灯具的类型
     */


    private String modelType;

    /**
     * 灯具的imei
     */
    private String equipmentNumber;

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
    private String projectName;

    /**
     * 备注
     */
    private String mem;

    /**
     * 灯具的功率
     */
    private Double staticPower;

    /**
     * 灯具的外键id
     */
    private Long nnlightctlLampModelId;

    /**
     * 灯杆的外键id
     */
    private Long nnlightctlLamppostId;

    /**
     *
     * 所属项目id
     */
    private Long nnlightctlProjectId;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLampModel() {
        return lampModel;
    }

    public void setLampModel(String lampModel) {
        this.lampModel = lampModel;
    }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
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
