package com.nnlightctl.vo;

public class RepertoryOutApplyView extends BaseView {

    public String getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
    }

    public Long getNnlightctlPropertyId() {
        return nnlightctlPropertyId;
    }

    public void setNnlightctlPropertyId(Long nnlightctlPropertyId) {
        this.nnlightctlPropertyId = nnlightctlPropertyId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public Long getNnlightctlUserId() {
        return nnlightctlUserId;
    }

    public void setNnlightctlUserId(Long nnlightctlUserId) {
        this.nnlightctlUserId = nnlightctlUserId;
    }

    public String getApplierName() {
        return applierName;
    }

    public void setApplierName(String applierName) {
        this.applierName = applierName;
    }

    public Long getNnlightctlOutRepertoryId() {
        return nnlightctlOutRepertoryId;
    }

    public void setNnlightctlOutRepertoryId(Long nnlightctlOutRepertoryId) {
        this.nnlightctlOutRepertoryId = nnlightctlOutRepertoryId;
    }

    public String getOutRepertoryName() {
        return outRepertoryName;
    }

    public void setOutRepertoryName(String outRepertoryName) {
        this.outRepertoryName = outRepertoryName;
    }

    public Long getNnlightctlRepertoryOutReasonId() {
        return nnlightctlRepertoryOutReasonId;
    }

    public void setNnlightctlRepertoryOutReasonId(Long nnlightctlRepertoryOutReasonId) {
        this.nnlightctlRepertoryOutReasonId = nnlightctlRepertoryOutReasonId;
    }

    public String getOutRepertoryReasonDesc() {
        return outRepertoryReasonDesc;
    }

    public void setOutRepertoryReasonDesc(String outRepertoryReasonDesc) {
        this.outRepertoryReasonDesc = outRepertoryReasonDesc;
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

    private String serialnumber;

    private Long nnlightctlPropertyId;

    private String propertyName;

    private Long nnlightctlUserId;

    private String applierName;

    private Long nnlightctlOutRepertoryId;

    private String outRepertoryName;

    private Long nnlightctlRepertoryOutReasonId;

    private String outRepertoryReasonDesc;

    private Byte applyState;

    private String refuseReason;

}
