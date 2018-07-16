package com.nnlightctl.request;

import java.util.List;

public class WorkFlowerNodeRequest {
    private Long id;    //-- 工作流节点id

    private String workflowerNodeName; //-- 工作流节点名称

    private Byte ctype;  //-- 工作流节点类型

    private Long nnlightctlUserId; // -- 工作流节点审批用户id

    private List<Long> workFlowerNodeIds; // -- 要删除的流程节点id集合
    public Long getId() {
        return id;
    }

    public List<Long> getWorkFlowerNodeIds() {
        return workFlowerNodeIds;
    }

    public void setWorkFlowerNodeIds(List<Long> workFlowerNodeIds) {
        this.workFlowerNodeIds = workFlowerNodeIds;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWorkflowerNodeName() {
        return workflowerNodeName;
    }

    public void setWorkflowerNodeName(String workflowerNodeName) {
        this.workflowerNodeName = workflowerNodeName;
    }

    public Byte getCtype() {
        return ctype;
    }

    public void setCtype(Byte ctype) {
        this.ctype = ctype;
    }

    public Long getNnlightctlUserId() {
        return nnlightctlUserId;
    }

    public void setNnlightctlUserId(Long nnlightctlUserId) {
        this.nnlightctlUserId = nnlightctlUserId;
    }
}
