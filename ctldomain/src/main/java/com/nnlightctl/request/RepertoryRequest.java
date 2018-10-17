package com.nnlightctl.request;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class RepertoryRequest {

    private Long id;

    private Date gmtCreated;

    private Date gmtUpdated;
    @NotBlank(message = "仓库UID不能为空！")
    private String uid;

    private String repertoryName;

    private String repertoryAddress;

    private String repertoryPhone;

    private String repertoryZipCode;
    @NotNull(message = "仓库管理员ID不能为空！")
    private Long nnlightctlUserId;

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
        this.uid = uid;
    }

    public String getRepertoryName() {
        return repertoryName;
    }

    public void setRepertoryName(String repertoryName) {
        this.repertoryName = repertoryName;
    }

    public String getRepertoryAddress() {
        return repertoryAddress;
    }

    public void setRepertoryAddress(String repertoryAddress) {
        this.repertoryAddress = repertoryAddress;
    }

    public String getRepertoryPhone() {
        return repertoryPhone;
    }

    public void setRepertoryPhone(String repertoryPhone) {
        this.repertoryPhone = repertoryPhone;
    }

    public String getRepertoryZipCode() {
        return repertoryZipCode;
    }

    public void setRepertoryZipCode(String repertoryZipCode) {
        this.repertoryZipCode = repertoryZipCode;
    }

    public Long getNnlightctlUserId() {
        return nnlightctlUserId;
    }

    public void setNnlightctlUserId(Long nnlightctlUserId) {
        this.nnlightctlUserId = nnlightctlUserId;
    }
}
