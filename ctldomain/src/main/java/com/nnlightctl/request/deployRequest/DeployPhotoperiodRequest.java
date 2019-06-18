package com.nnlightctl.request.deployRequest;

import com.nnlightctl.request.PhotoperiodRequest;

import java.util.List;

public class DeployPhotoperiodRequest {

    private Long eleboxId;


    private List<PhotoperiodRequest> photoperiodRequestList;

    public Long getEleboxId() {
        return eleboxId;
    }

    public void setEleboxId(Long eleboxId) {
        this.eleboxId = eleboxId;
    }

    public List<PhotoperiodRequest> getPhotoperiodRequestList() {
        return photoperiodRequestList;
    }

    public void setPhotoperiodRequestList(List<PhotoperiodRequest> photoperiodRequestList) {
        this.photoperiodRequestList = photoperiodRequestList;
    }
}
