package com.nnlightctl.request;

import java.util.List;

public class CentralizeControllerConditionRequest extends BaseRequest{


    private List<Long> centralizeControllerIds;

    private Long id;

    private String equipmentNumber;

    private String centralizeModel;

    private String centralizeName;

    private int deployFlag;

    private Long eleboxId;

    public int getDeployFlag() {
        return deployFlag;
    }

    public void setDeployFlag(int deployFlag) {
        this.deployFlag = deployFlag;
    }

    public Long getEleboxId() {
        return eleboxId;
    }

    public void setEleboxId(Long eleboxId) {
        this.eleboxId = eleboxId;
    }

    public String getCentralizeModel() {
        return centralizeModel;
    }

    public void setCentralizeModel(String centralizeModel) {
        this.centralizeModel = centralizeModel;
    }

    public String getCentralizeName() {
        return centralizeName;
    }

    public void setCentralizeName(String centralizeName) {
        this.centralizeName = centralizeName;
    }

    public List<Long> getCentralizeControllerIds() {
        return centralizeControllerIds;
    }

    public void setCentralizeControllerIds(List<Long> centralizeControllerIds) {
        this.centralizeControllerIds = centralizeControllerIds;
    }

    public String getEquipmentNumber() {
        return equipmentNumber;
    }

    public void setEquipmentNumber(String equipmentNumber) {
        this.equipmentNumber = equipmentNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
