package com.nnlightctl.po;

import java.io.Serializable;
import java.util.Date;

public class SceneShotcut implements Serializable {
    private Long id;

    private Date gmtCreated;

    private Date gmtUpdated;

    private String shotcutName;

    private Long nnlightctlSceneId;

    private Byte shotcutSceneState;

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

    public String getShotcutName() {
        return shotcutName;
    }

    public void setShotcutName(String shotcutName) {
        this.shotcutName = shotcutName == null ? null : shotcutName.trim();
    }

    public Long getNnlightctlSceneId() {
        return nnlightctlSceneId;
    }

    public void setNnlightctlSceneId(Long nnlightctlSceneId) {
        this.nnlightctlSceneId = nnlightctlSceneId;
    }

    public Byte getShotcutSceneState() {
        return shotcutSceneState;
    }

    public void setShotcutSceneState(Byte shotcutSceneState) {
        this.shotcutSceneState = shotcutSceneState;
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
        SceneShotcut other = (SceneShotcut) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGmtCreated() == null ? other.getGmtCreated() == null : this.getGmtCreated().equals(other.getGmtCreated()))
            && (this.getGmtUpdated() == null ? other.getGmtUpdated() == null : this.getGmtUpdated().equals(other.getGmtUpdated()))
            && (this.getShotcutName() == null ? other.getShotcutName() == null : this.getShotcutName().equals(other.getShotcutName()))
            && (this.getNnlightctlSceneId() == null ? other.getNnlightctlSceneId() == null : this.getNnlightctlSceneId().equals(other.getNnlightctlSceneId()))
            && (this.getShotcutSceneState() == null ? other.getShotcutSceneState() == null : this.getShotcutSceneState().equals(other.getShotcutSceneState()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGmtCreated() == null) ? 0 : getGmtCreated().hashCode());
        result = prime * result + ((getGmtUpdated() == null) ? 0 : getGmtUpdated().hashCode());
        result = prime * result + ((getShotcutName() == null) ? 0 : getShotcutName().hashCode());
        result = prime * result + ((getNnlightctlSceneId() == null) ? 0 : getNnlightctlSceneId().hashCode());
        result = prime * result + ((getShotcutSceneState() == null) ? 0 : getShotcutSceneState().hashCode());
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
        sb.append(", shotcutName=").append(shotcutName);
        sb.append(", nnlightctlSceneId=").append(nnlightctlSceneId);
        sb.append(", shotcutSceneState=").append(shotcutSceneState);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}