package com.nnlightctl.request;

import java.util.List;

public class DeleteRepertoryRequest {

    private List<Long> repertoryIds;

    public List<Long> getRepertoryIds() {
        return repertoryIds;
    }

    public void setRepertoryIds(List<Long> repertoryIds) {
        this.repertoryIds = repertoryIds;
    }
}
