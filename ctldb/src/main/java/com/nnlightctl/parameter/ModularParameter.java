package com.nnlightctl.parameter;

public class ModularParameter {

    private String modularModel;

    private String modularName;

    private Integer loopNumber;

    private String communicationMode;

    private Integer maxElectric;

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
}
