package com.nnlightctl.request;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

public class InstitutionRequest extends BaseRequest{
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

    @NotBlank(message = "机构名称不可为空!")
    private String institutionName;

    private Date createTime;

    private String addr;

    private String mem;

    private Long nnlightctlInstitutionIdParent;

    private Byte institutionLevel;
}
