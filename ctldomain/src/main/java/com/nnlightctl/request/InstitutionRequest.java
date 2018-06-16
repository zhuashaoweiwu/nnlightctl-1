package com.nnlightctl.request;

import java.util.Date;

public class InstitutionRequest {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
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

    public String getMem() {
        return mem;
    }

    public void setMem(String mem) {
        this.mem = mem;
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

    private Long id;

    private String institutionName;

    private Date createTime;

    private String addr;

    private String mem;

    private Long nnlightctlInstitutionIdParent;

    private Byte institutionLevel;
}