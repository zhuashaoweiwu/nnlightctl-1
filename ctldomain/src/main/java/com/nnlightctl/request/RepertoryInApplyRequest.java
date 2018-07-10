package com.nnlightctl.request;

import java.util.Date;
import java.util.List;

public class RepertoryInApplyRequest {

    private List<Long> applyInRepertoryIds;

    private Long id;

    private Date gmtCreated;

    private Date gmtUpdated;

    private String serialnumber;

    private Date inRepertoryDate;

    private Long nnlightctlPropertyClassifyCatalogId;

    private Long nnlightctlSupplier;

    private String propertyName;

    private String propertyUid;

    private Long propertyCount;

    private Long nnlightctlRepertoryInReasonId;

    private Long nnlightctlRepertoryId;

    private Long nnlightctlUserApplyId;

    private Byte applyState;

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

    public String getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
    }

    public Date getInRepertoryDate() {
        return inRepertoryDate;
    }

    public void setInRepertoryDate(Date inRepertoryDate) {
        this.inRepertoryDate = inRepertoryDate;
    }

    public Long getNnlightctlPropertyClassifyCatalogId() {
        return nnlightctlPropertyClassifyCatalogId;
    }

    public void setNnlightctlPropertyClassifyCatalogId(Long nnlightctlPropertyClassifyCatalogId) {
        this.nnlightctlPropertyClassifyCatalogId = nnlightctlPropertyClassifyCatalogId;
    }

    public Long getNnlightctlSupplier() {
        return nnlightctlSupplier;
    }

    public void setNnlightctlSupplier(Long nnlightctlSupplier) {
        this.nnlightctlSupplier = nnlightctlSupplier;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyUid() {
        return propertyUid;
    }

    public void setPropertyUid(String propertyUid) {
        this.propertyUid = propertyUid;
    }

    public Long getPropertyCount() {
        return propertyCount;
    }

    public void setPropertyCount(Long propertyCount) {
        this.propertyCount = propertyCount;
    }

    public Long getNnlightctlRepertoryInReasonId() {
        return nnlightctlRepertoryInReasonId;
    }

    public void setNnlightctlRepertoryInReasonId(Long nnlightctlRepertoryInReasonId) {
        this.nnlightctlRepertoryInReasonId = nnlightctlRepertoryInReasonId;
    }

    public Long getNnlightctlRepertoryId() {
        return nnlightctlRepertoryId;
    }

    public void setNnlightctlRepertoryId(Long nnlightctlRepertoryId) {
        this.nnlightctlRepertoryId = nnlightctlRepertoryId;
    }

    public Long getNnlightctlUserApplyId() {
        return nnlightctlUserApplyId;
    }

    public void setNnlightctlUserApplyId(Long nnlightctlUserApplyId) {
        this.nnlightctlUserApplyId = nnlightctlUserApplyId;
    }

    public Byte getApplyState() {
        return applyState;
    }

    public void setApplyState(Byte applyState) {
        this.applyState = applyState;
    }

    public List<Long> getApplyInRepertoryIds() {
        return applyInRepertoryIds;
    }

    public void setApplyInRepertoryIds(List<Long> applyInRepertoryIds) {
        this.applyInRepertoryIds = applyInRepertoryIds;
    }
}
