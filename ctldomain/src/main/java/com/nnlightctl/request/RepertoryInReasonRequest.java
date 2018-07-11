package com.nnlightctl.request;

public class RepertoryInReasonRequest {

    private Long id; // -- 入库原因id,新增时不传该值

    private String codeNumber;  //-- 入库原因编码

    private String reasonDesc;  //-- 入库原因描述

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeNumber() {
        return codeNumber;
    }

    public void setCodeNumber(String codeNumber) {
        this.codeNumber = codeNumber;
    }

    public String getReasonDesc() {
        return reasonDesc;
    }

    public void setReasonDesc(String reasonDesc) {
        this.reasonDesc = reasonDesc;
    }
}
