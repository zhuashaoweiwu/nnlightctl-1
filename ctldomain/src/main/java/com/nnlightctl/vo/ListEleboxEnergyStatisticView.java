package com.nnlightctl.vo;

import com.nnlightctl.request.BaseRequest;

import java.math.BigDecimal;

public class ListEleboxEnergyStatisticView{

    private BigDecimal total;

    private String uid;

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
