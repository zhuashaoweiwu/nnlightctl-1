package com.nnlightctl.request;

import java.util.List;

public class PhotoperiodConditionRequest extends BaseRequest{

    private List<Long> photoperiodIds;

    private String equipmentNumber;

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getPhotoperiodIds() {
        return photoperiodIds;
    }

    public void setPhotoperiodIds(List<Long> photoperiodIds) {
        this.photoperiodIds = photoperiodIds;
    }

    public String getEquipmentNumber() {
        return equipmentNumber;
    }

    public void setEquipmentNumber(String equipmentNumber) {
        this.equipmentNumber = equipmentNumber;
    }
}
