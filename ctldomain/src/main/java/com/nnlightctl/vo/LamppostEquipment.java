package com.nnlightctl.vo;

public class LamppostEquipment {

    private Long id;

    private String equipmentNumber;

    private Integer lampheadNumber;

    public Integer getLampheadNumber() {
        return lampheadNumber;
    }

    public void setLampheadNumber(Integer lampheadNumber) {
        this.lampheadNumber = lampheadNumber;
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
