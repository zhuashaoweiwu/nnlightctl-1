package com.nnlightctl.request;

import java.util.List;

public class TransferPropertyRequest {

    private List<Long> propertyIds; //  -- 要转移的资产id的集合

    private Long newRepertoryId; // -- 资产转移到新仓库的id

    public List<Long> getPropertyIds() {
        return propertyIds;
    }

    public void setPropertyIds(List<Long> propertyIds) {
        this.propertyIds = propertyIds;
    }

    public Long getNewRepertoryId() {
        return newRepertoryId;
    }

    public void setNewRepertoryId(Long newRepertoryId) {
        this.newRepertoryId = newRepertoryId;
    }
}
