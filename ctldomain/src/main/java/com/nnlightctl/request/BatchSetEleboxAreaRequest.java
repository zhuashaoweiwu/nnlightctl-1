package com.nnlightctl.request;

import java.util.List;

public class BatchSetEleboxAreaRequest {
    private  Long beAreaId; // -- 区域id

    private List<Long> eleboxIds  ; // -- 批量设置的灯具的id的集合

    public Long getBeAreaId() {
        return beAreaId;
    }

    public void setBeAreaId(Long beAreaId) {
        this.beAreaId = beAreaId;
    }

    public List<Long> getEleboxIds() {
        return eleboxIds;
    }

    public void setEleboxIds(List<Long> eleboxIds) {
        this.eleboxIds = eleboxIds;
    }
}
