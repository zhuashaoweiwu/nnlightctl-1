package com.nnlightctl.request;

import java.util.Date;

public class ApplyInRepertoryRequest extends BaseRequest{

    private Date startDate;

    private Date endDate;

    private Long nnlightctlRepertoryId;

    private Long nnlightctlPropertyClassifyCatalogId;

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

    public Long getNnlightctlRepertoryId() {
        return nnlightctlRepertoryId;
    }

    public void setNnlightctlRepertoryId(Long nnlightctlRepertoryId) {
        this.nnlightctlRepertoryId = nnlightctlRepertoryId;
    }

    public Long getNnlightctlPropertyClassifyCatalogId() {
        return nnlightctlPropertyClassifyCatalogId;
    }

    public void setNnlightctlPropertyClassifyCatalogId(Long nnlightctlPropertyClassifyCatalogId) {
        this.nnlightctlPropertyClassifyCatalogId = nnlightctlPropertyClassifyCatalogId;
    }
}
