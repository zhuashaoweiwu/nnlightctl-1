package com.nnlightctl.request.deployRequest;

import com.nnlightctl.request.CentralizeControllerRquester;

import java.util.List;

public class DeployCentralizeControllerRequest {

    private Long eleBoxId;

    private Long eleboxCentralizeControllerId;

    private List<DeployCentralizeControllerLoopRequest> loopRequests;

    public List<DeployCentralizeControllerLoopRequest> getLoopRequests() {
        return loopRequests;
    }

    public void setLoopRequests(List<DeployCentralizeControllerLoopRequest> loopRequests) {
        this.loopRequests = loopRequests;
    }

    public Long getEleBoxId() {
        return eleBoxId;
    }

    public void setEleBoxId(Long eleBoxId) {
        this.eleBoxId = eleBoxId;
    }

    public Long getEleboxCentralizeControllerId() {
        return eleboxCentralizeControllerId;
    }

    public void setEleboxCentralizeControllerId(Long eleboxCentralizeControllerId) {
        this.eleboxCentralizeControllerId = eleboxCentralizeControllerId;
    }


}
