package com.nnlightctl.request;

import java.util.List;

public class DeleteRepairRecordRequest {

   private List<Long> repairRecordIds;

    public List<Long> getRepairRecordIds() {
        return repairRecordIds;
    }

    public void setRepairRecordIds(List<Long> repairRecordIds) {
        this.repairRecordIds = repairRecordIds;
    }
}
