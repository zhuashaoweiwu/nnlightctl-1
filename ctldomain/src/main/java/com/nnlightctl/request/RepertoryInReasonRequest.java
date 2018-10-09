package com.nnlightctl.request;

import javax.validation.constraints.NotNull;
import java.util.List;

public class RepertoryInReasonRequest {

    private Long id; // -- 入库原因id,新增时不传该值
    @NotNull(message = "入库原因编码不能为空！")
    private String codeNumber;  //-- 入库原因编码
    @NotNull(message = "入库原因描述不能为空！")
    private String reasonDesc;  //-- 入库原因描述

   private List<Long> repertoryInReasonIds;

    public List<Long> getRepertoryInReasonIds() {
        return repertoryInReasonIds;
    }

    public void setRepertoryInReasonIds(List<Long> repertoryInReasonIds) {
        this.repertoryInReasonIds = repertoryInReasonIds;
    }

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
