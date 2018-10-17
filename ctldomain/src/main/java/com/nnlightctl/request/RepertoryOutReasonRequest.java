package com.nnlightctl.request;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.List;

public class RepertoryOutReasonRequest {
    private Long id;  //-- 出库原因id
    @NotBlank(message = "出库原因编码不能为空！")
    private String codeNumber; // -- 出库原因编码
    @NotBlank(message = "出库原因描述不能为空！")
    private String reason;  //-- 出库原因描述

    private List<Long> repertoryOutReasonIds;

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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<Long> getRepertoryOutReasonIds() {
        return repertoryOutReasonIds;
    }

    public void setRepertoryOutReasonIds(List<Long> repertoryOutReasonIds) {
        this.repertoryOutReasonIds = repertoryOutReasonIds;
    }
}
