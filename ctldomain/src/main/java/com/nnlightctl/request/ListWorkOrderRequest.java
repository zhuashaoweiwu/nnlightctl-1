package com.nnlightctl.request;

public class ListWorkOrderRequest extends BaseRequest {

    private Byte state;

    private Long nnlightctlWorkflowerId;

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Long getNnlightctlWorkflowerId() {
        return nnlightctlWorkflowerId;
    }

    public void setNnlightctlWorkflowerId(Long nnlightctlWorkflowerId) {
        this.nnlightctlWorkflowerId = nnlightctlWorkflowerId;
    }
}
