package com.nnlightctl.vo;

import java.util.Date;

public class RepertoryInApplyView extends BaseView {

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

    public String getPropertyClassifyCatalogDesc() {
        return propertyClassifyCatalogDesc;
    }

    public void setPropertyClassifyCatalogDesc(String propertyClassifyCatalogDesc) {
        this.propertyClassifyCatalogDesc = propertyClassifyCatalogDesc;
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

    public String getRefuseReason() {
        return refuseReason;
    }

    public void setRefuseReason(String refuseReason) {
        this.refuseReason = refuseReason;
    }

    public String getSupplierDesc() {
        return supplierDesc;
    }

    public void setSupplierDesc(String supplierDesc) {
        this.supplierDesc = supplierDesc;
    }

    public String getRepertoryInReason() {
        return repertoryInReason;
    }

    public void setRepertoryInReason(String repertoryInReason) {
        this.repertoryInReason = repertoryInReason;
    }

    public String getRepertoryName() {
        return repertoryName;
    }

    public void setRepertoryName(String repertoryName) {
        this.repertoryName = repertoryName;
    }

    public String getUserApplyName() {
        return userApplyName;
    }

    public void setUserApplyName(String userApplyName) {
        this.userApplyName = userApplyName;
    }

    private String serialnumber;

    private Date inRepertoryDate;

    private Long nnlightctlPropertyClassifyCatalogId;

    private String propertyClassifyCatalogDesc;

    private Long nnlightctlSupplier;

    private String supplierDesc;    //供应商名称

    private String propertyName;

    private String propertyUid;

    private Long propertyCount;

    private Long nnlightctlRepertoryInReasonId;

    private String repertoryInReason;   //入库理由

    private Long nnlightctlRepertoryId;

    private String repertoryName;   //入库仓库名称

    private Long nnlightctlUserApplyId;

    private String userApplyName;   //入库申请人名称

    private Byte applyState;

    private String refuseReason;

}
