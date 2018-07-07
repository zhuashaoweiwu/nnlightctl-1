package com.nnlightctl.po;

import java.io.Serializable;
import java.util.Date;

public class WorkOrder implements Serializable {
    private Long id;

    private Date gmtCreated;

    private Date gmtUpdated;

    private String serialNumber;

    private Byte classify;

    private Date workCreated;

    private Date workDone;

    private Long nnlightctlWorkflowerId;

    private Byte state;

    private Byte priority;

    private Long nnlightctlRegionId;

    private String address;

    private Long nnlightctlWorkflowerMoveRecordId;

    private Long nnlightctlMaskerId;

    private String content;

    private String attachFilePath;

    private Byte workSource;

    private Long nnlightctlProjectId;

    private static final long serialVersionUID = 1L;

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

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
    }

    public Byte getClassify() {
        return classify;
    }

    public void setClassify(Byte classify) {
        this.classify = classify;
    }

    public Date getWorkCreated() {
        return workCreated;
    }

    public void setWorkCreated(Date workCreated) {
        this.workCreated = workCreated;
    }

    public Date getWorkDone() {
        return workDone;
    }

    public void setWorkDone(Date workDone) {
        this.workDone = workDone;
    }

    public Long getNnlightctlWorkflowerId() {
        return nnlightctlWorkflowerId;
    }

    public void setNnlightctlWorkflowerId(Long nnlightctlWorkflowerId) {
        this.nnlightctlWorkflowerId = nnlightctlWorkflowerId;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
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
        this.address = address == null ? null : address.trim();
    }

    public Long getNnlightctlWorkflowerMoveRecordId() {
        return nnlightctlWorkflowerMoveRecordId;
    }

    public void setNnlightctlWorkflowerMoveRecordId(Long nnlightctlWorkflowerMoveRecordId) {
        this.nnlightctlWorkflowerMoveRecordId = nnlightctlWorkflowerMoveRecordId;
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
        this.content = content == null ? null : content.trim();
    }

    public String getAttachFilePath() {
        return attachFilePath;
    }

    public void setAttachFilePath(String attachFilePath) {
        this.attachFilePath = attachFilePath == null ? null : attachFilePath.trim();
    }

    public Byte getWorkSource() {
        return workSource;
    }

    public void setWorkSource(Byte workSource) {
        this.workSource = workSource;
    }

    public Long getNnlightctlProjectId() {
        return nnlightctlProjectId;
    }

    public void setNnlightctlProjectId(Long nnlightctlProjectId) {
        this.nnlightctlProjectId = nnlightctlProjectId;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        WorkOrder other = (WorkOrder) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGmtCreated() == null ? other.getGmtCreated() == null : this.getGmtCreated().equals(other.getGmtCreated()))
            && (this.getGmtUpdated() == null ? other.getGmtUpdated() == null : this.getGmtUpdated().equals(other.getGmtUpdated()))
            && (this.getSerialNumber() == null ? other.getSerialNumber() == null : this.getSerialNumber().equals(other.getSerialNumber()))
            && (this.getClassify() == null ? other.getClassify() == null : this.getClassify().equals(other.getClassify()))
            && (this.getWorkCreated() == null ? other.getWorkCreated() == null : this.getWorkCreated().equals(other.getWorkCreated()))
            && (this.getWorkDone() == null ? other.getWorkDone() == null : this.getWorkDone().equals(other.getWorkDone()))
            && (this.getNnlightctlWorkflowerId() == null ? other.getNnlightctlWorkflowerId() == null : this.getNnlightctlWorkflowerId().equals(other.getNnlightctlWorkflowerId()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getPriority() == null ? other.getPriority() == null : this.getPriority().equals(other.getPriority()))
            && (this.getNnlightctlRegionId() == null ? other.getNnlightctlRegionId() == null : this.getNnlightctlRegionId().equals(other.getNnlightctlRegionId()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getNnlightctlWorkflowerMoveRecordId() == null ? other.getNnlightctlWorkflowerMoveRecordId() == null : this.getNnlightctlWorkflowerMoveRecordId().equals(other.getNnlightctlWorkflowerMoveRecordId()))
            && (this.getNnlightctlMaskerId() == null ? other.getNnlightctlMaskerId() == null : this.getNnlightctlMaskerId().equals(other.getNnlightctlMaskerId()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getAttachFilePath() == null ? other.getAttachFilePath() == null : this.getAttachFilePath().equals(other.getAttachFilePath()))
            && (this.getWorkSource() == null ? other.getWorkSource() == null : this.getWorkSource().equals(other.getWorkSource()))
            && (this.getNnlightctlProjectId() == null ? other.getNnlightctlProjectId() == null : this.getNnlightctlProjectId().equals(other.getNnlightctlProjectId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGmtCreated() == null) ? 0 : getGmtCreated().hashCode());
        result = prime * result + ((getGmtUpdated() == null) ? 0 : getGmtUpdated().hashCode());
        result = prime * result + ((getSerialNumber() == null) ? 0 : getSerialNumber().hashCode());
        result = prime * result + ((getClassify() == null) ? 0 : getClassify().hashCode());
        result = prime * result + ((getWorkCreated() == null) ? 0 : getWorkCreated().hashCode());
        result = prime * result + ((getWorkDone() == null) ? 0 : getWorkDone().hashCode());
        result = prime * result + ((getNnlightctlWorkflowerId() == null) ? 0 : getNnlightctlWorkflowerId().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getPriority() == null) ? 0 : getPriority().hashCode());
        result = prime * result + ((getNnlightctlRegionId() == null) ? 0 : getNnlightctlRegionId().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getNnlightctlWorkflowerMoveRecordId() == null) ? 0 : getNnlightctlWorkflowerMoveRecordId().hashCode());
        result = prime * result + ((getNnlightctlMaskerId() == null) ? 0 : getNnlightctlMaskerId().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getAttachFilePath() == null) ? 0 : getAttachFilePath().hashCode());
        result = prime * result + ((getWorkSource() == null) ? 0 : getWorkSource().hashCode());
        result = prime * result + ((getNnlightctlProjectId() == null) ? 0 : getNnlightctlProjectId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", gmtCreated=").append(gmtCreated);
        sb.append(", gmtUpdated=").append(gmtUpdated);
        sb.append(", serialNumber=").append(serialNumber);
        sb.append(", classify=").append(classify);
        sb.append(", workCreated=").append(workCreated);
        sb.append(", workDone=").append(workDone);
        sb.append(", nnlightctlWorkflowerId=").append(nnlightctlWorkflowerId);
        sb.append(", state=").append(state);
        sb.append(", priority=").append(priority);
        sb.append(", nnlightctlRegionId=").append(nnlightctlRegionId);
        sb.append(", address=").append(address);
        sb.append(", nnlightctlWorkflowerMoveRecordId=").append(nnlightctlWorkflowerMoveRecordId);
        sb.append(", nnlightctlMaskerId=").append(nnlightctlMaskerId);
        sb.append(", content=").append(content);
        sb.append(", attachFilePath=").append(attachFilePath);
        sb.append(", workSource=").append(workSource);
        sb.append(", nnlightctlProjectId=").append(nnlightctlProjectId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}