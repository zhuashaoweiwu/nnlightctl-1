package com.nnlightctl.request;

import javax.validation.constraints.Min;
import java.util.List;

public class EleboxAddModelRequest {
    public List<EleboxModelRequest> getDeviceList() {
        return deviceList;
    }

    public void setDeviceList(List<EleboxModelRequest> deviceList) {
        this.deviceList = deviceList;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    private List<EleboxModelRequest> deviceList;
    private int count;
}
