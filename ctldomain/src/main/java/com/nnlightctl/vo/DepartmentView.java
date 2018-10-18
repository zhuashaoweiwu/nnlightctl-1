package com.nnlightctl.vo;

import java.util.Date;

public class DepartmentView extends BaseView{
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

    private String institutionName;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Date getGmtCreated() {
        return gmtCreated;
    }

    @Override
    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    @Override
    public Date getGmtUpdated() {
        return gmtUpdated;
    }

    @Override
    public void setGmtUpdated(Date gmtUpdated) {
        this.gmtUpdated = gmtUpdated;
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

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }
}
