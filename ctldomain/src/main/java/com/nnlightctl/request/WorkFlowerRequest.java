package com.nnlightctl.request;

import java.util.List;

public class WorkFlowerRequest {
   private Long id;  //-- 工作流id

    private String workflowerName;  //-- 工作流名称

    private String mem;  //-- 备注

    private List<Long> workFlowerNodeIds; // -- 工作流包含节点，节点在工作流中的序号按照节点在该集合中的序号排序

    private List<Long> workFlowerIds;

    private Long workFlowerId;//  -- 工作流id

    private Integer isEnable;//  -- 是否启用 0 - 不启用  1 - 启用

    public Long getWorkFlowerId() {
        return workFlowerId;
    }

    public void setWorkFlowerId(Long workFlowerId) {
        this.workFlowerId = workFlowerId;
    }

    public Integer getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }

    public List<Long> getWorkFlowerIds() {
        return workFlowerIds;
    }

    public void setWorkFlowerIds(List<Long> workFlowerIds) {
        this.workFlowerIds = workFlowerIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWorkflowerName() {
        return workflowerName;
    }

    public void setWorkflowerName(String workflowerName) {
        this.workflowerName = workflowerName;
    }

    public String getMem() {
        return mem;
    }

    public void setMem(String mem) {
        this.mem = mem;
    }

    public List<Long> getWorkFlowerNodeIds() {
        return workFlowerNodeIds;
    }

    public void setWorkFlowerNodeIds(List<Long> workFlowerNodeIds) {
        this.workFlowerNodeIds = workFlowerNodeIds;
    }
}
