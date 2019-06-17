package com.nnlightctl.request.deployRequest;

import com.nnlightctl.request.ElectricityMeterRequest;

import java.util.List;

public class DeployElectricityMeter {

    private Long eleboxId;

    private List<ElectricityMeterRequest> meterRequestList;

    public Long getEleboxId() {
        return eleboxId;
    }

    public void setEleboxId(Long eleboxId) {
        this.eleboxId = eleboxId;
    }

    public List<ElectricityMeterRequest> getMeterRequestList() {
        return meterRequestList;
    }

    public void setMeterRequestList(List<ElectricityMeterRequest> meterRequestList) {
        this.meterRequestList = meterRequestList;
    }
}
