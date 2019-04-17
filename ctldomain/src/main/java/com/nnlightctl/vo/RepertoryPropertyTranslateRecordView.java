package com.nnlightctl.vo;

import java.util.Date;

public class RepertoryPropertyTranslateRecordView extends BaseView {

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

    public Date getTranslateDate() {
        return translateDate;
    }

    public void setTranslateDate(Date translateDate) {
        this.translateDate = translateDate;
    }

    public Long getSourceRepertyId() {
        return sourceRepertyId;
    }

    public void setSourceRepertyId(Long sourceRepertyId) {
        this.sourceRepertyId = sourceRepertyId;
    }

    public String getSourceRepertyName() {
        return sourceRepertyName;
    }

    public void setSourceRepertyName(String sourceRepertyName) {
        this.sourceRepertyName = sourceRepertyName;
    }

    public Long getTargetRepertyId() {
        return targetRepertyId;
    }

    public void setTargetRepertyId(Long targetRepertyId) {
        this.targetRepertyId = targetRepertyId;
    }

    public String getTargetRepertoryName() {
        return targetRepertoryName;
    }

    public void setTargetRepertoryName(String targetRepertoryName) {
        this.targetRepertoryName = targetRepertoryName;
    }

    public Long getNnlightctlUserIdApply() {
        return nnlightctlUserIdApply;
    }

    public void setNnlightctlUserIdApply(Long nnlightctlUserIdApply) {
        this.nnlightctlUserIdApply = nnlightctlUserIdApply;
    }

    public String getApplierName() {
        return applierName;
    }

    public void setApplierName(String applierName) {
        this.applierName = applierName;
    }

    public Long getNnlightctlUserIdReceive() {
        return nnlightctlUserIdReceive;
    }

    public void setNnlightctlUserIdReceive(Long nnlightctlUserIdReceive) {
        this.nnlightctlUserIdReceive = nnlightctlUserIdReceive;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    private Long nnlightctlPropertyId;

    private String propertyName;    //资产名称

    private Date translateDate;

    private Long sourceRepertyId;

    private String sourceRepertyName;   //源出库仓库名称

    private Long targetRepertyId;

    private String targetRepertoryName; //目标入库仓库名称

    private Long nnlightctlUserIdApply;

    private String applierName;         //转移申请人用户名

    private Long nnlightctlUserIdReceive;

    private String receiverName;        //目标交接人用户名
}
