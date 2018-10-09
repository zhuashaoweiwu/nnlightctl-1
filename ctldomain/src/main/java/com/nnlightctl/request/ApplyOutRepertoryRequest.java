package com.nnlightctl.request;

import java.util.Date;

public class ApplyOutRepertoryRequest extends BaseRequest{

    private Date startDate;

    private Date endDate;

    private Long nnlightctlPropertyId;

    private Long outRepertoryId;

    private Long userId;

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

    public Long getNnlightctlPropertyId() {
        return nnlightctlPropertyId;
    }

    public void setNnlightctlPropertyId(Long nnlightctlPropertyId) {
        this.nnlightctlPropertyId = nnlightctlPropertyId;
    }

    public Long getOutRepertoryId() {
        return outRepertoryId;
    }

    public void setOutRepertoryId(Long outRepertoryId) {
        this.outRepertoryId = outRepertoryId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
