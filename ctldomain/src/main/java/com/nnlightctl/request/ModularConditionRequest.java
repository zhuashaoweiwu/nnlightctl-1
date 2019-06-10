package com.nnlightctl.request;

import java.util.List;

public class ModularConditionRequest {

    private List<Long> modularIds;

    private Long id;

    private String modularModel;

    private String modularName;

    private Integer loopNumber;

    private String communicationMode;

    private Integer maxElectric;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getModularIds() {
        return modularIds;
    }

    public void setModularIds(List<Long> modularIds) {
        this.modularIds = modularIds;
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
}
