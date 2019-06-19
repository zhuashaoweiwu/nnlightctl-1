package com.nnlightctl.vo;

public class DeployLightingView {
    /**
     * 单灯控制器的型号
     */
    private String LightingModel;

    /**
     * 灯具的型号
     */
    private String model;

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
    private String project;

    /**
     * 备注
     */
    private String mem;

    /**
     * 灯具的功率
     */
    private Double staticPower;

    public String getLightingModel() {
        return LightingModel;
    }

    public void setLightingModel(String lightingModel) {
        LightingModel = lightingModel;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
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
