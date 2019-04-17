package com.nnlightctl.vo;

import java.util.Date;

public class WorkFlowerNodeMapView {

    private Long id;

    private Date gmtCreated;

    private Date gmtUpdated;

    private Long nnlightctlWorkflowerId;

    private Long nnlightctlWorkflowerNodeId;

    private Long orderNumber;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public Date getGmtUpdated() {
        return gmtUpdated;
    }

    public void setGmtUpdated(Date gmtUpdated) {
        this.gmtUpdated = gmtUpdated;
    }

    public Long getNnlightctlWorkflowerId() {
        return nnlightctlWorkflowerId;
    }

    public void setNnlightctlWorkflowerId(Long nnlightctlWorkflowerId) {
        this.nnlightctlWorkflowerId = nnlightctlWorkflowerId;
    }

    public Long getNnlightctlWorkflowerNodeId() {
        return nnlightctlWorkflowerNodeId;
    }

    public void setNnlightctlWorkflowerNodeId(Long nnlightctlWorkflowerNodeId) {
        this.nnlightctlWorkflowerNodeId = nnlightctlWorkflowerNodeId;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }
}
