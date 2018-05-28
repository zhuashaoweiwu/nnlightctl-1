package com.nnlightctl.request;

import java.util.List;

public class LightModelConditionRequest extends BaseRequest {
    public List<Long> getDeleteLightModelList() {
        return deleteLightModelList;
    }

    public void setDeleteLightModelList(List<Long> deleteLightModelList) {
        this.deleteLightModelList = deleteLightModelList;
    }

    private List<Long> deleteLightModelList;
}
