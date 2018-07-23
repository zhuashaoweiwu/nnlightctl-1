package com.nnlightctl.request;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public class WorkOrderRequest {
    private Long id;    //-- 工单id

    private String serialNumber; // -- 编号

    private Byte classify; // -- 分类

    private Long nnlightctlWorkflowerId; // -- 工作流id

    private Byte priority; // -- 优先级

    private Long nnlightctlRegionId;  //-- 区域id

    private String address;  //-- 地址

    private Long nnlightctlMaskerId;  //-- 工单执行人id

    private String content;  //-- 工单内容

    private MultipartFile attachFilePath; // -- 附件

    private String path;

    private Date date;//  -- 日期

    private Integer timeType;//  -- 时间类型，0 - 月统计 1 - 年统计

    private Long workOrderId;// -- 待认领的工单id

    private Long taskerId;//  -- 任务执行人id，前端通过列表选择任务执行人

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getTimeType() {
        return timeType;
    }

    public void setTimeType(Integer timeType) {
        this.timeType = timeType;
    }

    public Long getWorkOrderId() {
        return workOrderId;
    }

    public void setWorkOrderId(Long workOrderId) {
        this.workOrderId = workOrderId;
    }

    public Long getTaskerId() {
        return taskerId;
    }

    public void setTaskerId(Long taskerId) {
        this.taskerId = taskerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MultipartFile getAttachFilePath() {
        return attachFilePath;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setAttachFilePath(MultipartFile attachFilePath) {
        this.attachFilePath = attachFilePath;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Byte getClassify() {
        return classify;
    }

    public void setClassify(Byte classify) {
        this.classify = classify;
    }

    public Long getNnlightctlWorkflowerId() {
        return nnlightctlWorkflowerId;
    }

    public void setNnlightctlWorkflowerId(Long nnlightctlWorkflowerId) {
        this.nnlightctlWorkflowerId = nnlightctlWorkflowerId;
    }

    public Byte getPriority() {
        return priority;
    }

    public void setPriority(Byte priority) {
        this.priority = priority;
    }

    public Long getNnlightctlRegionId() {
        return nnlightctlRegionId;
    }

    public void setNnlightctlRegionId(Long nnlightctlRegionId) {
        this.nnlightctlRegionId = nnlightctlRegionId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getNnlightctlMaskerId() {
        return nnlightctlMaskerId;
    }

    public void setNnlightctlMaskerId(Long nnlightctlMaskerId) {
        this.nnlightctlMaskerId = nnlightctlMaskerId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
