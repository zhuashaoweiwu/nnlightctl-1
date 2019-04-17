package com.nnlightctl.po;

import java.io.Serializable;
import java.util.Date;

public class Department implements Serializable {
    private Long id;

    private Date gmtCreated;

    private Date gmtUpdated;

    private String departmentName;

    private Date createTime;

    private String addr;

    private Long nnlightctlInstitutionIdBelong;

    private String mem;

    private Long nnlightctlDepartmentIdParent;

    private Byte departmentLevel;

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

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
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

    public Long getNnlightctlInstitutionIdBelong() {
        return nnlightctlInstitutionIdBelong;
    }

    public void setNnlightctlInstitutionIdBelong(Long nnlightctlInstitutionIdBelong) {
        this.nnlightctlInstitutionIdBelong = nnlightctlInstitutionIdBelong;
    }

    public String getMem() {
        return mem;
    }

    public void setMem(String mem) {
        this.mem = mem == null ? null : mem.trim();
    }

    public Long getNnlightctlDepartmentIdParent() {
        return nnlightctlDepartmentIdParent;
    }

    public void setNnlightctlDepartmentIdParent(Long nnlightctlDepartmentIdParent) {
        this.nnlightctlDepartmentIdParent = nnlightctlDepartmentIdParent;
    }

    public Byte getDepartmentLevel() {
        return departmentLevel;
    }

    public void setDepartmentLevel(Byte departmentLevel) {
        this.departmentLevel = departmentLevel;
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
        Department other = (Department) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGmtCreated() == null ? other.getGmtCreated() == null : this.getGmtCreated().equals(other.getGmtCreated()))
            && (this.getGmtUpdated() == null ? other.getGmtUpdated() == null : this.getGmtUpdated().equals(other.getGmtUpdated()))
            && (this.getDepartmentName() == null ? other.getDepartmentName() == null : this.getDepartmentName().equals(other.getDepartmentName()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getAddr() == null ? other.getAddr() == null : this.getAddr().equals(other.getAddr()))
            && (this.getNnlightctlInstitutionIdBelong() == null ? other.getNnlightctlInstitutionIdBelong() == null : this.getNnlightctlInstitutionIdBelong().equals(other.getNnlightctlInstitutionIdBelong()))
            && (this.getMem() == null ? other.getMem() == null : this.getMem().equals(other.getMem()))
            && (this.getNnlightctlDepartmentIdParent() == null ? other.getNnlightctlDepartmentIdParent() == null : this.getNnlightctlDepartmentIdParent().equals(other.getNnlightctlDepartmentIdParent()))
            && (this.getDepartmentLevel() == null ? other.getDepartmentLevel() == null : this.getDepartmentLevel().equals(other.getDepartmentLevel()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGmtCreated() == null) ? 0 : getGmtCreated().hashCode());
        result = prime * result + ((getGmtUpdated() == null) ? 0 : getGmtUpdated().hashCode());
        result = prime * result + ((getDepartmentName() == null) ? 0 : getDepartmentName().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getAddr() == null) ? 0 : getAddr().hashCode());
        result = prime * result + ((getNnlightctlInstitutionIdBelong() == null) ? 0 : getNnlightctlInstitutionIdBelong().hashCode());
        result = prime * result + ((getMem() == null) ? 0 : getMem().hashCode());
        result = prime * result + ((getNnlightctlDepartmentIdParent() == null) ? 0 : getNnlightctlDepartmentIdParent().hashCode());
        result = prime * result + ((getDepartmentLevel() == null) ? 0 : getDepartmentLevel().hashCode());
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
        sb.append(", departmentName=").append(departmentName);
        sb.append(", createTime=").append(createTime);
        sb.append(", addr=").append(addr);
        sb.append(", nnlightctlInstitutionIdBelong=").append(nnlightctlInstitutionIdBelong);
        sb.append(", mem=").append(mem);
        sb.append(", nnlightctlDepartmentIdParent=").append(nnlightctlDepartmentIdParent);
        sb.append(", departmentLevel=").append(departmentLevel);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}