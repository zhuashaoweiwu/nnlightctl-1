package com.nnlightctl.request;

import java.util.Date;

public class PropertyRequest {
   private Long id;  //-- 要修改的资产id

    private  String uid; // -- 资产唯一编码

    private Date propertyRecordDatetime; //-- 资产登记日期

    private String longitude; //-- 经度

    private String latitude; // -- 纬度

    private Byte ctype;  //-- 资产类型

    private Long price; // -- 资产价格

    private String commanProperty;  //-- 资产通用属性

    private Long propertyManagerId;  //-- 资产管理者id

    private Long nnlightctlPropertyId; // -- 父资产id

    private Byte state; // -- 状态，0 - 报废； 1 - 完好

    private Long nnlightctlPropertyClassifyCatalogId;  //-- 资产目录id

    private String propertyClassifyCatalogDesc;  //-- 资产目录描述

    private String propertyClassifyCatalogName; // -- 资产目录名称

    private Long nnlightctlUserApplierId; //-- 申请者

    private Long propertyCount; //-- 资产数量

    private Byte applyState; //-- 申请状态，0 - 待审批 ；1 - 领料中；

    private Byte inOutState; //-- 出入库， 0 - 出库； 1  - 入库。

    private String reason; //-- 原因

    private Long reasonid; //-- 原因id

    private String mem; //-- 备注

    private Long nnlightctlUserId; //-- 审批人id

    private Long nnlightctlRepertoryId; //-- 所属仓库id

    private Long nnlightctlSupplierId; //-- 供应商id

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Date getPropertyRecordDatetime() {
        return propertyRecordDatetime;
    }

    public void setPropertyRecordDatetime(Date propertyRecordDatetime) {
        this.propertyRecordDatetime = propertyRecordDatetime;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Byte getCtype() {
        return ctype;
    }

    public void setCtype(Byte ctype) {
        this.ctype = ctype;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getCommanProperty() {
        return commanProperty;
    }

    public void setCommanProperty(String commanProperty) {
        this.commanProperty = commanProperty;
    }

    public Long getPropertyManagerId() {
        return propertyManagerId;
    }

    public void setPropertyManagerId(Long propertyManagerId) {
        this.propertyManagerId = propertyManagerId;
    }

    public Long getNnlightctlPropertyId() {
        return nnlightctlPropertyId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNnlightctlPropertyId(Long nnlightctlPropertyId) {
        this.nnlightctlPropertyId = nnlightctlPropertyId;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
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

    public String getPropertyClassifyCatalogName() {
        return propertyClassifyCatalogName;
    }

    public void setPropertyClassifyCatalogName(String propertyClassifyCatalogName) {
        this.propertyClassifyCatalogName = propertyClassifyCatalogName;
    }

    public Long getNnlightctlUserApplierId() {
        return nnlightctlUserApplierId;
    }

    public void setNnlightctlUserApplierId(Long nnlightctlUserApplierId) {
        this.nnlightctlUserApplierId = nnlightctlUserApplierId;
    }

    public Long getPropertyCount() {
        return propertyCount;
    }

    public void setPropertyCount(Long propertyCount) {
        this.propertyCount = propertyCount;
    }

    public Byte getApplyState() {
        return applyState;
    }

    public void setApplyState(Byte applyState) {
        this.applyState = applyState;
    }

    public Byte getInOutState() {
        return inOutState;
    }

    public void setInOutState(Byte inOutState) {
        this.inOutState = inOutState;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Long getReasonid() {
        return reasonid;
    }

    public void setReasonid(Long reasonid) {
        this.reasonid = reasonid;
    }

    public String getMem() {
        return mem;
    }

    public void setMem(String mem) {
        this.mem = mem;
    }

    public Long getNnlightctlUserId() {
        return nnlightctlUserId;
    }

    public void setNnlightctlUserId(Long nnlightctlUserId) {
        this.nnlightctlUserId = nnlightctlUserId;
    }

    public Long getNnlightctlRepertoryId() {
        return nnlightctlRepertoryId;
    }

    public void setNnlightctlRepertoryId(Long nnlightctlRepertoryId) {
        this.nnlightctlRepertoryId = nnlightctlRepertoryId;
    }

    public Long getNnlightctlSupplierId() {
        return nnlightctlSupplierId;
    }

    public void setNnlightctlSupplierId(Long nnlightctlSupplierId) {
        this.nnlightctlSupplierId = nnlightctlSupplierId;
    }
}
