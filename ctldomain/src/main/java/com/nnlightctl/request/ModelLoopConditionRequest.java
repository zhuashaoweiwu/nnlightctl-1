package com.nnlightctl.request;

import java.util.List;

public class ModelLoopConditionRequest extends BaseRequest {
    public List<Long> getModelLoopIds() {
        return modelLoopIds;
    }

    public void setModelLoopIds(List<Long> modelLoopIds) {
        this.modelLoopIds = modelLoopIds;
    }

    private List<Long> modelLoopIds;
}
