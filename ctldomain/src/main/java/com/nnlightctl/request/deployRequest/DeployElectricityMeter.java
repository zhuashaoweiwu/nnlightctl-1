package com.nnlightctl.request.deployRequest;

import com.nnlightctl.request.ElectricityMeterRequest;

import java.util.List;

public class DeployElectricityMeter {

    private Long eleboxId;

    private List<Long> electricityMeterIds;

    public Long getEleboxId() {
        return eleboxId;
    }

    public void setEleboxId(Long eleboxId) {
        this.eleboxId = eleboxId;
    }

    public List<Long> getElectricityMeterIds() {
        return electricityMeterIds;
    }

    public void setElectricityMeterIds(List<Long> electricityMeterIds) {
        this.electricityMeterIds = electricityMeterIds;
    }
}
