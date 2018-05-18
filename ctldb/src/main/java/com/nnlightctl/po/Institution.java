package com.nnlightctl.po;

import java.io.Serializable;
import java.util.Date;

public class Institution implements Serializable {
    private Long id;

    private Date gmtCreated;

    private Date gmtUpdated;

    private String institutionName;

    private Date createTime;

    private String addr;

    private String mem;

    private Long nnlightctlInstitutionIdParent;

    private Byte institutionLevel;

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

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName == null ? null : institutionName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    public String getMem() {
        return mem;
    }

    public void setMem(String mem) {
        this.mem = mem == null ? null : mem.trim();
    }

    public Long getNnlightctlInstitutionIdParent() {
        return nnlightctlInstitutionIdParent;
    }

    public void setNnlightctlInstitutionIdParent(Long nnlightctlInstitutionIdParent) {
        this.nnlightctlInstitutionIdParent = nnlightctlInstitutionIdParent;
    }

    public Byte getInstitutionLevel() {
        return institutionLevel;
    }

    public void setInstitutionLevel(Byte institutionLevel) {
        this.institutionLevel = institutionLevel;
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
        Institution other = (Institution) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGmtCreated() == null ? other.getGmtCreated() == null : this.getGmtCreated().equals(other.getGmtCreated()))
            && (this.getGmtUpdated() == null ? other.getGmtUpdated() == null : this.getGmtUpdated().equals(other.getGmtUpdated()))
            && (this.getInstitutionName() == null ? other.getInstitutionName() == null : this.getInstitutionName().equals(other.getInstitutionName()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getAddr() == null ? other.getAddr() == null : this.getAddr().equals(other.getAddr()))
            && (this.getMem() == null ? other.getMem() == null : this.getMem().equals(other.getMem()))
            && (this.getNnlightctlInstitutionIdParent() == null ? other.getNnlightctlInstitutionIdParent() == null : this.getNnlightctlInstitutionIdParent().equals(other.getNnlightctlInstitutionIdParent()))
            && (this.getInstitutionLevel() == null ? other.getInstitutionLevel() == null : this.getInstitutionLevel().equals(other.getInstitutionLevel()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGmtCreated() == null) ? 0 : getGmtCreated().hashCode());
        result = prime * result + ((getGmtUpdated() == null) ? 0 : getGmtUpdated().hashCode());
        result = prime * result + ((getInstitutionName() == null) ? 0 : getInstitutionName().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getAddr() == null) ? 0 : getAddr().hashCode());
        result = prime * result + ((getMem() == null) ? 0 : getMem().hashCode());
        result = prime * result + ((getNnlightctlInstitutionIdParent() == null) ? 0 : getNnlightctlInstitutionIdParent().hashCode());
        result = prime * result + ((getInstitutionLevel() == null) ? 0 : getInstitutionLevel().hashCode());
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
        sb.append(", institutionName=").append(institutionName);
        sb.append(", createTime=").append(createTime);
        sb.append(", addr=").append(addr);
        sb.append(", mem=").append(mem);
        sb.append(", nnlightctlInstitutionIdParent=").append(nnlightctlInstitutionIdParent);
        sb.append(", institutionLevel=").append(institutionLevel);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}