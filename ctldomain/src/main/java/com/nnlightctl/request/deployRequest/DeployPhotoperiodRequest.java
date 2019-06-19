package com.nnlightctl.request.deployRequest;


import java.util.List;

public class DeployPhotoperiodRequest {

    private Long eleboxId;


    private List<Long> photoperiodIds;

    public Long getEleboxId() {
        return eleboxId;
    }

    public void setEleboxId(Long eleboxId) {
        this.eleboxId = eleboxId;
    }

    public List<Long> getPhotoperiodIds() {
        return photoperiodIds;
    }

    public void setPhotoperiodIds(List<Long> photoperiodIds) {
        this.photoperiodIds = photoperiodIds;
    }
}
