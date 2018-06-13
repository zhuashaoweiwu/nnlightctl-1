package com.nnlightctl.request;

import java.util.List;

public class AreaConditionRequest extends BaseRequest {
    public List<Long> getAreaIdList() {
        return areaIdList;
    }

    public void setAreaIdList(List<Long> areaIdList) {
        this.areaIdList = areaIdList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Long id;
    private List<Long> areaIdList;
}
