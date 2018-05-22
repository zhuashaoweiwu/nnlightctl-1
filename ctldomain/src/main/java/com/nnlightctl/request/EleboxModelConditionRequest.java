package com.nnlightctl.request;

import java.util.List;

public class EleboxModelConditionRequest extends BaseRequest {
    public List<Long> getEleboxModelIdList() {
        return eleboxModelIdList;
    }

    public void setEleboxModelIdList(List<Long> eleboxModelIdList) {
        this.eleboxModelIdList = eleboxModelIdList;
    }

    private List<Long> eleboxModelIdList;
}
