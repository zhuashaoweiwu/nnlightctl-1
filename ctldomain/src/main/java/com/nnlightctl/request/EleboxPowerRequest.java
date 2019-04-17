package com.nnlightctl.request;

import java.util.Date;

public class EleboxPowerRequest {
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    private Long eleboxId;

    private Date startDate;

    private Date endDate;

    private String uid;

    public Long getEleboxId() {
        return eleboxId;
    }

    public void setEleboxId(Long eleboxId) {
        this.eleboxId = eleboxId;
    }

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
}

