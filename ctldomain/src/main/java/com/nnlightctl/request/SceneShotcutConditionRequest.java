package com.nnlightctl.request;

import java.util.List;

public class SceneShotcutConditionRequest extends BaseRequest {
    public List<Long> getSceneShotcutIds() {
        return sceneShotcutIds;
    }

    public void setSceneShotcutIds(List<Long> sceneShotcutIds) {
        this.sceneShotcutIds = sceneShotcutIds;
    }

    private List<Long> sceneShotcutIds;
}
