package com.nnlightctl.po;

import java.io.Serializable;
import java.util.Date;

public class Righter implements Serializable {
    private Long id;

    private Date gmtCreated;

    private Date gmtUpdated;

    private String codeNumber;

    private String righterName;

    private String url;

    private Byte righterLevel;

    private Long parentRighterId;

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

    public String getCodeNumber() {
        return codeNumber;
    }

    public void setCodeNumber(String codeNumber) {
        this.codeNumber = codeNumber == null ? null : codeNumber.trim();
    }

    public String getRighterName() {
        return righterName;
    }

    public void setRighterName(String righterName) {
        this.righterName = righterName == null ? null : righterName.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Byte getRighterLevel() {
        return righterLevel;
    }

    public void setRighterLevel(Byte righterLevel) {
        this.righterLevel = righterLevel;
    }

    public Long getParentRighterId() {
        return parentRighterId;
    }

    public void setParentRighterId(Long parentRighterId) {
        this.parentRighterId = parentRighterId;
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
        Righter other = (Righter) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGmtCreated() == null ? other.getGmtCreated() == null : this.getGmtCreated().equals(other.getGmtCreated()))
            && (this.getGmtUpdated() == null ? other.getGmtUpdated() == null : this.getGmtUpdated().equals(other.getGmtUpdated()))
            && (this.getCodeNumber() == null ? other.getCodeNumber() == null : this.getCodeNumber().equals(other.getCodeNumber()))
            && (this.getRighterName() == null ? other.getRighterName() == null : this.getRighterName().equals(other.getRighterName()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
            && (this.getRighterLevel() == null ? other.getRighterLevel() == null : this.getRighterLevel().equals(other.getRighterLevel()))
            && (this.getParentRighterId() == null ? other.getParentRighterId() == null : this.getParentRighterId().equals(other.getParentRighterId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGmtCreated() == null) ? 0 : getGmtCreated().hashCode());
        result = prime * result + ((getGmtUpdated() == null) ? 0 : getGmtUpdated().hashCode());
        result = prime * result + ((getCodeNumber() == null) ? 0 : getCodeNumber().hashCode());
        result = prime * result + ((getRighterName() == null) ? 0 : getRighterName().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getRighterLevel() == null) ? 0 : getRighterLevel().hashCode());
        result = prime * result + ((getParentRighterId() == null) ? 0 : getParentRighterId().hashCode());
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
        sb.append(", codeNumber=").append(codeNumber);
        sb.append(", righterName=").append(righterName);
        sb.append(", url=").append(url);
        sb.append(", righterLevel=").append(righterLevel);
        sb.append(", parentRighterId=").append(parentRighterId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}