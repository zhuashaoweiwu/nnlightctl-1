package com.nnlightctl.po;

import java.io.Serializable;
import java.util.Date;

public class WorkflowerMoveRecord implements Serializable {
    private Long id;

    private Date gmtCreated;

    private Date gmtUpdated;

    private Long nnlightctlWorkOrderId;

    private Long nnlightctlWorkflowerId;

    private Long nnlightctlWorkflowerNodeId;

    private Byte passState;

    private String deniedReson;

    private Byte moveState;

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

    public Long getNnlightctlWorkOrderId() {
        return nnlightctlWorkOrderId;
    }

    public void setNnlightctlWorkOrderId(Long nnlightctlWorkOrderId) {
        this.nnlightctlWorkOrderId = nnlightctlWorkOrderId;
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

    public Byte getPassState() {
        return passState;
    }

    public void setPassState(Byte passState) {
        this.passState = passState;
    }

    public String getDeniedReson() {
        return deniedReson;
    }

    public void setDeniedReson(String deniedReson) {
        this.deniedReson = deniedReson == null ? null : deniedReson.trim();
    }

    public Byte getMoveState() {
        return moveState;
    }

    public void setMoveState(Byte moveState) {
        this.moveState = moveState;
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
        WorkflowerMoveRecord other = (WorkflowerMoveRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGmtCreated() == null ? other.getGmtCreated() == null : this.getGmtCreated().equals(other.getGmtCreated()))
            && (this.getGmtUpdated() == null ? other.getGmtUpdated() == null : this.getGmtUpdated().equals(other.getGmtUpdated()))
            && (this.getNnlightctlWorkOrderId() == null ? other.getNnlightctlWorkOrderId() == null : this.getNnlightctlWorkOrderId().equals(other.getNnlightctlWorkOrderId()))
            && (this.getNnlightctlWorkflowerId() == null ? other.getNnlightctlWorkflowerId() == null : this.getNnlightctlWorkflowerId().equals(other.getNnlightctlWorkflowerId()))
            && (this.getNnlightctlWorkflowerNodeId() == null ? other.getNnlightctlWorkflowerNodeId() == null : this.getNnlightctlWorkflowerNodeId().equals(other.getNnlightctlWorkflowerNodeId()))
            && (this.getPassState() == null ? other.getPassState() == null : this.getPassState().equals(other.getPassState()))
            && (this.getDeniedReson() == null ? other.getDeniedReson() == null : this.getDeniedReson().equals(other.getDeniedReson()))
            && (this.getMoveState() == null ? other.getMoveState() == null : this.getMoveState().equals(other.getMoveState()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGmtCreated() == null) ? 0 : getGmtCreated().hashCode());
        result = prime * result + ((getGmtUpdated() == null) ? 0 : getGmtUpdated().hashCode());
        result = prime * result + ((getNnlightctlWorkOrderId() == null) ? 0 : getNnlightctlWorkOrderId().hashCode());
        result = prime * result + ((getNnlightctlWorkflowerId() == null) ? 0 : getNnlightctlWorkflowerId().hashCode());
        result = prime * result + ((getNnlightctlWorkflowerNodeId() == null) ? 0 : getNnlightctlWorkflowerNodeId().hashCode());
        result = prime * result + ((getPassState() == null) ? 0 : getPassState().hashCode());
        result = prime * result + ((getDeniedReson() == null) ? 0 : getDeniedReson().hashCode());
        result = prime * result + ((getMoveState() == null) ? 0 : getMoveState().hashCode());
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
        sb.append(", nnlightctlWorkOrderId=").append(nnlightctlWorkOrderId);
        sb.append(", nnlightctlWorkflowerId=").append(nnlightctlWorkflowerId);
        sb.append(", nnlightctlWorkflowerNodeId=").append(nnlightctlWorkflowerNodeId);
        sb.append(", passState=").append(passState);
        sb.append(", deniedReson=").append(deniedReson);
        sb.append(", moveState=").append(moveState);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}