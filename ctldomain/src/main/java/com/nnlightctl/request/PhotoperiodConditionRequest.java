package com.nnlightctl.request;

import java.util.List;

public class PhotoperiodConditionRequest extends BaseRequest{
    private List<Long> photoperiodIds;

    public List<Long> getPhotoperiodIds() {
        return photoperiodIds;
    }

    public void setPhotoperiodIds(List<Long> photoperiodIds) {
        this.photoperiodIds = photoperiodIds;
    }
}
