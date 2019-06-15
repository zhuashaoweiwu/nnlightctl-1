package com.nnlightctl.request.deployRequest;

import com.nnlightctl.request.BaseRequest;

import java.util.List;

public class DeployExleboxArrangeRequest  extends BaseRequest {

    private Long exleboxId;

    private Long exleboxModelId;

    private List<DeployEleboxModelLoopRequest> LoopRequest;

    public Long getExleboxId() {
        return exleboxId;
    }

    public void setExleboxId(Long exleboxId) {
        this.exleboxId = exleboxId;
    }

    public Long getExleboxModelId() {
        return exleboxModelId;
    }

    public void setExleboxModelId(Long exleboxModelId) {
        this.exleboxModelId = exleboxModelId;
    }

    public List<DeployEleboxModelLoopRequest> getLoopRequest() {
        return LoopRequest;
    }

    public void setLoopRequest(List<DeployEleboxModelLoopRequest> loopRequest) {
        LoopRequest = loopRequest;
    }
}
