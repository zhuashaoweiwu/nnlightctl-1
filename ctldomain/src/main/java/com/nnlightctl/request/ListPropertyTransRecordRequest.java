package com.nnlightctl.request;

import java.util.Date;

public class ListPropertyTransRecordRequest extends BaseRequest {

    private Date startDate;

    private Date endDate;

    private Long sourceRepertyId;

    private Long targetRepertyId;

    private Long nnlightctlUserIdApply;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getSourceRepertyId() {
        return sourceRepertyId;
    }

    public void setSourceRepertyId(Long sourceRepertyId) {
        this.sourceRepertyId = sourceRepertyId;
    }

    public Long getTargetRepertyId() {
        return targetRepertyId;
    }

    public void setTargetRepertyId(Long targetRepertyId) {
        this.targetRepertyId = targetRepertyId;
    }

    public Long getNnlightctlUserIdApply() {
        return nnlightctlUserIdApply;
    }

    public void setNnlightctlUserIdApply(Long nnlightctlUserIdApply) {
        this.nnlightctlUserIdApply = nnlightctlUserIdApply;
    }
}
