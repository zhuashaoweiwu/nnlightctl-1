package com.nnlightctl.request;

import java.util.Date;

public class WorkOrderHistoryRequest extends BaseRequest{

    private Date startTime;

    private Date endTime;

    private Long nnlightctlMaskerId;

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getNnlightctlMaskerId() {
        return nnlightctlMaskerId;
    }

    public void setNnlightctlMaskerId(Long nnlightctlMaskerId) {
        this.nnlightctlMaskerId = nnlightctlMaskerId;
    }
}
