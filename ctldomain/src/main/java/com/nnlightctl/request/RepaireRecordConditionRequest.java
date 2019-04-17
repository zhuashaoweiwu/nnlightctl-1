package com.nnlightctl.request;

import java.util.Date;
import java.util.List;

public class RepaireRecordConditionRequest {
    public List<Long> getRepairRecordIds() {
        return repairRecordIds;
    }

    public void setRepairRecordIds(List<Long> repairRecordIds) {
        this.repairRecordIds = repairRecordIds;
    }

    public Date getCommitDate() {
        return commitDate;
    }

    public void setCommitDate(Date commitDate) {
        this.commitDate = commitDate;
    }

    private List<Long> repairRecordIds;
    private Date commitDate;
}
