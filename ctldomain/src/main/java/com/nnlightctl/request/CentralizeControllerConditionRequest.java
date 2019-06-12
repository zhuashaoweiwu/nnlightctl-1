package com.nnlightctl.request;

import java.util.List;

public class CentralizeControllerConditionRequest extends BaseRequest{


    private List<Long> centralizeControllerIds;

    private Long id;


    private String equipmentNumber;

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
