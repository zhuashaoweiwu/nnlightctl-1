package com.nnlightctl.request;

import java.util.List;

public class SceneConditionRequest extends BaseRequest {
    public List<Long> getSceneIds() {
        return sceneIds;
    }

    public void setSceneIds(List<Long> sceneIds) {
        this.sceneIds = sceneIds;
    }

    private List<Long> sceneIds;
}
