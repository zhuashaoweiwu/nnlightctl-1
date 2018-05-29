package com.nnlightctl.request;

import java.util.List;

public class AreaConditionRequest extends BaseRequest {
    public List<Long> getAreaIdList() {
        return areaIdList;
    }

    public void setAreaIdList(List<Long> areaIdList) {
        this.areaIdList = areaIdList;
    }

    private List<Long> areaIdList;
}
