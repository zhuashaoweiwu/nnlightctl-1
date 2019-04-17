package com.nnlightctl.request;

import java.util.List;

public class SystemParamIdsRequest extends BaseRequest{
    private List<Long> systemParamIds;

    public List<Long> getSystemParamIds() {
        return systemParamIds;
    }

    public void setSystemParamIds(List<Long> systemParamIds) {
        this.systemParamIds = systemParamIds;
    }

}
