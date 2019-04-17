package com.nnlightctl.request;

public class WorkflowerMoveRecordRequest {
    private  Long workFlowerRecordId;// -- 工作流流转记录id

    private Integer isApproved;//  --  是否通过 0 - 表示不通过   1 - 表示通过

    private String refusedReason;//  -- 不通过原因

    public Long getWorkFlowerRecordId() {
        return workFlowerRecordId;
    }

    public void setWorkFlowerRecordId(Long workFlowerRecordId) {
        this.workFlowerRecordId = workFlowerRecordId;
    }

    public Integer getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(Integer isApproved) {
        this.isApproved = isApproved;
    }

    public String getRefusedReason() {
        return refusedReason;
    }

    public void setRefusedReason(String refusedReason) {
        this.refusedReason = refusedReason;
    }
}
