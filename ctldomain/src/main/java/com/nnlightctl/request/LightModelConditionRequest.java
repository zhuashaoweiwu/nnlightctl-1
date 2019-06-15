package com.nnlightctl.request;

import java.util.List;

public class LightModelConditionRequest extends BaseRequest {
    public List<Long> getDeleteLightModelList() {
        return deleteLightModelList;
    }

    public void setDeleteLightModelList(List<Long> deleteLightModelList) {
        this.deleteLightModelList = deleteLightModelList;
    }


    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    private String modelName;
    private List<Long> deleteLightModelList;

    private String equipmentNumber;



    public String getEquipmentNumber() {
        return equipmentNumber;
    }

    public void setEquipmentNumber(String equipmentNumber) {
        this.equipmentNumber = equipmentNumber;
    }
}
