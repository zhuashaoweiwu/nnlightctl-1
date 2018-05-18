package com.nnlightctl.po;

import java.io.Serializable;
import java.util.Date;

public class Repertory implements Serializable {
    private Long id;

    private Date gmtCreated;

    private Date gmtUpdated;

    private String uid;

    private String repertoryName;

    private String repertoryAddress;

    private String repertoryPhone;

    private String repertoryZipCode;

    private Long nnlightctlUserId;

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

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getRepertoryName() {
        return repertoryName;
    }

    public void setRepertoryName(String repertoryName) {
        this.repertoryName = repertoryName == null ? null : repertoryName.trim();
    }

    public String getRepertoryAddress() {
        return repertoryAddress;
    }

    public void setRepertoryAddress(String repertoryAddress) {
        this.repertoryAddress = repertoryAddress == null ? null : repertoryAddress.trim();
    }

    public String getRepertoryPhone() {
        return repertoryPhone;
    }

    public void setRepertoryPhone(String repertoryPhone) {
        this.repertoryPhone = repertoryPhone == null ? null : repertoryPhone.trim();
    }

    public String getRepertoryZipCode() {
        return repertoryZipCode;
    }

    public void setRepertoryZipCode(String repertoryZipCode) {
        this.repertoryZipCode = repertoryZipCode == null ? null : repertoryZipCode.trim();
    }

    public Long getNnlightctlUserId() {
        return nnlightctlUserId;
    }

    public void setNnlightctlUserId(Long nnlightctlUserId) {
        this.nnlightctlUserId = nnlightctlUserId;
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
        Repertory other = (Repertory) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGmtCreated() == null ? other.getGmtCreated() == null : this.getGmtCreated().equals(other.getGmtCreated()))
            && (this.getGmtUpdated() == null ? other.getGmtUpdated() == null : this.getGmtUpdated().equals(other.getGmtUpdated()))
            && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getRepertoryName() == null ? other.getRepertoryName() == null : this.getRepertoryName().equals(other.getRepertoryName()))
            && (this.getRepertoryAddress() == null ? other.getRepertoryAddress() == null : this.getRepertoryAddress().equals(other.getRepertoryAddress()))
            && (this.getRepertoryPhone() == null ? other.getRepertoryPhone() == null : this.getRepertoryPhone().equals(other.getRepertoryPhone()))
            && (this.getRepertoryZipCode() == null ? other.getRepertoryZipCode() == null : this.getRepertoryZipCode().equals(other.getRepertoryZipCode()))
            && (this.getNnlightctlUserId() == null ? other.getNnlightctlUserId() == null : this.getNnlightctlUserId().equals(other.getNnlightctlUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGmtCreated() == null) ? 0 : getGmtCreated().hashCode());
        result = prime * result + ((getGmtUpdated() == null) ? 0 : getGmtUpdated().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getRepertoryName() == null) ? 0 : getRepertoryName().hashCode());
        result = prime * result + ((getRepertoryAddress() == null) ? 0 : getRepertoryAddress().hashCode());
        result = prime * result + ((getRepertoryPhone() == null) ? 0 : getRepertoryPhone().hashCode());
        result = prime * result + ((getRepertoryZipCode() == null) ? 0 : getRepertoryZipCode().hashCode());
        result = prime * result + ((getNnlightctlUserId() == null) ? 0 : getNnlightctlUserId().hashCode());
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
        sb.append(", uid=").append(uid);
        sb.append(", repertoryName=").append(repertoryName);
        sb.append(", repertoryAddress=").append(repertoryAddress);
        sb.append(", repertoryPhone=").append(repertoryPhone);
        sb.append(", repertoryZipCode=").append(repertoryZipCode);
        sb.append(", nnlightctlUserId=").append(nnlightctlUserId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}