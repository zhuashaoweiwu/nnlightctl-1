package com.nnlightctl.request;

import java.util.List;

public class DeleteMaskerRequest {

    private List<Long> maskerIds; //-- 要删除的工单执行联系人id的集合

    public List<Long> getMaskerIds() {
        return maskerIds;
    }

    public void setMaskerIds(List<Long> maskerIds) {
        this.maskerIds = maskerIds;
    }
}
