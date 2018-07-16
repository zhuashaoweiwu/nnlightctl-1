package com.nnlightctl.vo;

import com.nnlightctl.request.BaseRequest;

public class ListEleboxEnergyStatisticView extends BaseRequest{

    private Long total;

    private String uid;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
