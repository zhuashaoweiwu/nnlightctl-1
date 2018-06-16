package com.nnlightctl.request;

import java.util.Date;

public class DepartmentRequest {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
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
        this.addr = addr;
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
        this.mem = mem;
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

    private Long id;

    private String departmentName;

    private Date createTime;

    private String addr;

    private Long nnlightctlInstitutionIdBelong;

    private String mem;

    private Long nnlightctlDepartmentIdParent;

    private Byte departmentLevel;
}