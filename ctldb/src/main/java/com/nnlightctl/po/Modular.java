package com.nnlightctl.po;

import java.io.Serializable;

public class Modular implements Serializable {
    private Long id;

    private String modularModel;

    private String modularName;

    private Integer loopNumber;

    private String communicationMode;

    private Integer maxElectric;

    private String loadElectric;

    private String installationMode;

    private String mem;

    private String equipmentNumber;

    public String getEquipmentNumber() {
        return equipmentNumber;
    }

    public void setEquipmentNumber(String equipmentNumber) {
        this.equipmentNumber = equipmentNumber;
    }

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModularModel() {
        return modularModel;
    }

    public void setModularModel(String modularModel) {
        this.modularModel = modularModel;
    }

    public String getModularName() {
        return modularName;
    }

    public void setModularName(String modularName) {
        this.modularName = modularName;
    }

    public Integer getLoopNumber() {
        return loopNumber;
    }

    public void setLoopNumber(Integer loopNumber) {
        this.loopNumber = loopNumber;
    }

    public String getCommunicationMode() {
        return communicationMode;
    }

    public void setCommunicationMode(String communicationMode) {
        this.communicationMode = communicationMode;
    }

    public Integer getMaxElectric() {
        return maxElectric;
    }

    public void setMaxElectric(Integer maxElectric) {
        this.maxElectric = maxElectric;
    }

    public String getLoadElectric() {
        return loadElectric;
    }

    public void setLoadElectric(String loadElectric) {
        this.loadElectric = loadElectric;
    }

    public String getInstallationMode() {
        return installationMode;
    }

    public void setInstallationMode(String installationMode) {
        this.installationMode = installationMode;
    }

    public String getMem() {
        return mem;
    }

    public void setMem(String mem) {
        this.mem = mem;
    }
}