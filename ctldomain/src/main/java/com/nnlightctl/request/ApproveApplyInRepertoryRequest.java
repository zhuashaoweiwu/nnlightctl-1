package com.nnlightctl.request;

import java.util.List;

public class ApproveApplyInRepertoryRequest {

   private List<Long> applyInRepertoryIds; // -- 审批操作的入库申请id的集合

    private Integer isApprove;  //-- 是否审批通过 0 - 不通过 1 - 通过

    private String refuseReason;  //-- 不通过原因，前端在审批不通过时才可填写原因

    public List<Long> getApplyInRepertoryIds() {
        return applyInRepertoryIds;
    }

    public void setApplyInRepertoryIds(List<Long> applyInRepertoryIds) {
        this.applyInRepertoryIds = applyInRepertoryIds;
    }

    public Integer getIsApprove() {
        return isApprove;
    }

    public void setIsApprove(Integer isApprove) {
        this.isApprove = isApprove;
    }

    public String getRefuseReason() {
        return refuseReason;
    }

    public void setRefuseReason(String refuseReason) {
        this.refuseReason = refuseReason;
    }
}
