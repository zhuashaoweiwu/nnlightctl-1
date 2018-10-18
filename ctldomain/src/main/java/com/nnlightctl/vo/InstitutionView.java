package com.nnlightctl.vo;

import java.util.Date;

public class InstitutionView extends BaseView{
    private Long id;

    private Date gmtCreated;

    private Date gmtUpdated;

    private String institutionName;

    private Date createTime;

    private String addr;

    private String mem;

    private Long nnlightctlInstitutionIdParent;

    private Byte institutionLevel;

    private String parentName;

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

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
}
