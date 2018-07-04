package com.nnlightctl.request;

import java.util.Date;

public class RepairRecordRequest {
    private Long id;

    private Date gmtCreated;

    private Date gmtUpdated;

    private Long nnlightctlEleboxId;

    private Long nnlightctlPropertyClassifyCatalogId;

    private String propertyName;

    private Long propertyCount;

    private Date faultDate;

    private Date createDate;

    private Long nnlightctlUserId;

    private Byte isCommit;

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

    public Long getNnlightctlEleboxId() {
        return nnlightctlEleboxId;
    }

    public void setNnlightctlEleboxId(Long nnlightctlEleboxId) {
        this.nnlightctlEleboxId = nnlightctlEleboxId;
    }

    public Long getNnlightctlPropertyClassifyCatalogId() {
        return nnlightctlPropertyClassifyCatalogId;
    }

    public void setNnlightctlPropertyClassifyCatalogId(Long nnlightctlPropertyClassifyCatalogId) {
        this.nnlightctlPropertyClassifyCatalogId = nnlightctlPropertyClassifyCatalogId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public Long getPropertyCount() {
        return propertyCount;
    }

    public void setPropertyCount(Long propertyCount) {
        this.propertyCount = propertyCount;
    }

    public Date getFaultDate() {
        return faultDate;
    }

    public void setFaultDate(Date faultDate) {
        this.faultDate = faultDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getNnlightctlUserId() {
        return nnlightctlUserId;
    }

    public void setNnlightctlUserId(Long nnlightctlUserId) {
        this.nnlightctlUserId = nnlightctlUserId;
    }

    public Byte getIsCommit() {
        return isCommit;
    }

    public void setIsCommit(Byte isCommit) {
        this.isCommit = isCommit;
    }
}
