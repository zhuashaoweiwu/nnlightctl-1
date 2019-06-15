package com.nnlightctl.request;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LamppostConditionRequest extends BaseRequest{

    private Long id;

    private List<Long> lamppostIds;

    private String equipmentNumber;

    private String lamppostModel;

    public String getLamppostModel() {
        return lamppostModel;
    }

    public void setLamppostModel(String lamppostModel) {
        this.lamppostModel = lamppostModel;
    }

    private String lampostName;

    public String getLampostName() {
        return lampostName;
    }

    public void setLampostName(String lampostName) {
        this.lampostName = lampostName;
    }

    public List<Long> getLamppostIds() {
        return lamppostIds;
    }

    public void setLamppostIds(List<Long> lamppostIds) {
        this.lamppostIds = lamppostIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEquipmentNumber() {
        return equipmentNumber;
    }

    public void setEquipmentNumber(String equipmentNumber) {
        this.equipmentNumber = equipmentNumber;
    }
}
