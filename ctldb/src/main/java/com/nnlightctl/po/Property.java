package com.nnlightctl.po;

import java.io.Serializable;
import java.util.Date;

public class Property implements Serializable {
    private Long id;

    private Date gmtCreated;

    private Date gmtUpdated;

    private String uid;

    private Date propertyRecordDatetime;

    private Long longitude;

    private Long latitude;

    private Byte ctype;

    private Long price;

    private String commanProperty;

    private Long propertyManagerId;

    private Long nnlightctlPropertyId;

    private Byte state;

    private Long nnlightctlPropertyClassifyCatalogId;

    private String propertyClassifyCatalogDesc;

    private String propertyClassifyCatalogName;

    private Long nnlightctlUserApplierId;

    private Long propertyCount;

    private Byte applyState;

    private Byte inOutState;

    private String reason;

    private Long reasonid;

    private String mem;

    private Long nnlightctlUserId;

    private Long nnlightctlRepertoryId;

    private Long nnlightctlSupplierId;

    private static final long serialVersionUID = 1L;

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
        this.uid = uid == null ? null : uid.trim();
    }

    public Date getPropertyRecordDatetime() {
        return propertyRecordDatetime;
    }

    public void setPropertyRecordDatetime(Date propertyRecordDatetime) {
        this.propertyRecordDatetime = propertyRecordDatetime;
    }

    public Long getLongitude() {
        return longitude;
    }

    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }

    public Long getLatitude() {
        return latitude;
    }

    public void setLatitude(Long latitude) {
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
        this.commanProperty = commanProperty == null ? null : commanProperty.trim();
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
        this.propertyClassifyCatalogDesc = propertyClassifyCatalogDesc == null ? null : propertyClassifyCatalogDesc.trim();
    }

    public String getPropertyClassifyCatalogName() {
        return propertyClassifyCatalogName;
    }

    public void setPropertyClassifyCatalogName(String propertyClassifyCatalogName) {
        this.propertyClassifyCatalogName = propertyClassifyCatalogName == null ? null : propertyClassifyCatalogName.trim();
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
        this.reason = reason == null ? null : reason.trim();
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
        this.mem = mem == null ? null : mem.trim();
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

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Property other = (Property) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGmtCreated() == null ? other.getGmtCreated() == null : this.getGmtCreated().equals(other.getGmtCreated()))
            && (this.getGmtUpdated() == null ? other.getGmtUpdated() == null : this.getGmtUpdated().equals(other.getGmtUpdated()))
            && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getPropertyRecordDatetime() == null ? other.getPropertyRecordDatetime() == null : this.getPropertyRecordDatetime().equals(other.getPropertyRecordDatetime()))
            && (this.getLongitude() == null ? other.getLongitude() == null : this.getLongitude().equals(other.getLongitude()))
            && (this.getLatitude() == null ? other.getLatitude() == null : this.getLatitude().equals(other.getLatitude()))
            && (this.getCtype() == null ? other.getCtype() == null : this.getCtype().equals(other.getCtype()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getCommanProperty() == null ? other.getCommanProperty() == null : this.getCommanProperty().equals(other.getCommanProperty()))
            && (this.getPropertyManagerId() == null ? other.getPropertyManagerId() == null : this.getPropertyManagerId().equals(other.getPropertyManagerId()))
            && (this.getNnlightctlPropertyId() == null ? other.getNnlightctlPropertyId() == null : this.getNnlightctlPropertyId().equals(other.getNnlightctlPropertyId()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getNnlightctlPropertyClassifyCatalogId() == null ? other.getNnlightctlPropertyClassifyCatalogId() == null : this.getNnlightctlPropertyClassifyCatalogId().equals(other.getNnlightctlPropertyClassifyCatalogId()))
            && (this.getPropertyClassifyCatalogDesc() == null ? other.getPropertyClassifyCatalogDesc() == null : this.getPropertyClassifyCatalogDesc().equals(other.getPropertyClassifyCatalogDesc()))
            && (this.getPropertyClassifyCatalogName() == null ? other.getPropertyClassifyCatalogName() == null : this.getPropertyClassifyCatalogName().equals(other.getPropertyClassifyCatalogName()))
            && (this.getNnlightctlUserApplierId() == null ? other.getNnlightctlUserApplierId() == null : this.getNnlightctlUserApplierId().equals(other.getNnlightctlUserApplierId()))
            && (this.getPropertyCount() == null ? other.getPropertyCount() == null : this.getPropertyCount().equals(other.getPropertyCount()))
            && (this.getApplyState() == null ? other.getApplyState() == null : this.getApplyState().equals(other.getApplyState()))
            && (this.getInOutState() == null ? other.getInOutState() == null : this.getInOutState().equals(other.getInOutState()))
            && (this.getReason() == null ? other.getReason() == null : this.getReason().equals(other.getReason()))
            && (this.getReasonid() == null ? other.getReasonid() == null : this.getReasonid().equals(other.getReasonid()))
            && (this.getMem() == null ? other.getMem() == null : this.getMem().equals(other.getMem()))
            && (this.getNnlightctlUserId() == null ? other.getNnlightctlUserId() == null : this.getNnlightctlUserId().equals(other.getNnlightctlUserId()))
            && (this.getNnlightctlRepertoryId() == null ? other.getNnlightctlRepertoryId() == null : this.getNnlightctlRepertoryId().equals(other.getNnlightctlRepertoryId()))
            && (this.getNnlightctlSupplierId() == null ? other.getNnlightctlSupplierId() == null : this.getNnlightctlSupplierId().equals(other.getNnlightctlSupplierId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGmtCreated() == null) ? 0 : getGmtCreated().hashCode());
        result = prime * result + ((getGmtUpdated() == null) ? 0 : getGmtUpdated().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getPropertyRecordDatetime() == null) ? 0 : getPropertyRecordDatetime().hashCode());
        result = prime * result + ((getLongitude() == null) ? 0 : getLongitude().hashCode());
        result = prime * result + ((getLatitude() == null) ? 0 : getLatitude().hashCode());
        result = prime * result + ((getCtype() == null) ? 0 : getCtype().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getCommanProperty() == null) ? 0 : getCommanProperty().hashCode());
        result = prime * result + ((getPropertyManagerId() == null) ? 0 : getPropertyManagerId().hashCode());
        result = prime * result + ((getNnlightctlPropertyId() == null) ? 0 : getNnlightctlPropertyId().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getNnlightctlPropertyClassifyCatalogId() == null) ? 0 : getNnlightctlPropertyClassifyCatalogId().hashCode());
        result = prime * result + ((getPropertyClassifyCatalogDesc() == null) ? 0 : getPropertyClassifyCatalogDesc().hashCode());
        result = prime * result + ((getPropertyClassifyCatalogName() == null) ? 0 : getPropertyClassifyCatalogName().hashCode());
        result = prime * result + ((getNnlightctlUserApplierId() == null) ? 0 : getNnlightctlUserApplierId().hashCode());
        result = prime * result + ((getPropertyCount() == null) ? 0 : getPropertyCount().hashCode());
        result = prime * result + ((getApplyState() == null) ? 0 : getApplyState().hashCode());
        result = prime * result + ((getInOutState() == null) ? 0 : getInOutState().hashCode());
        result = prime * result + ((getReason() == null) ? 0 : getReason().hashCode());
        result = prime * result + ((getReasonid() == null) ? 0 : getReasonid().hashCode());
        result = prime * result + ((getMem() == null) ? 0 : getMem().hashCode());
        result = prime * result + ((getNnlightctlUserId() == null) ? 0 : getNnlightctlUserId().hashCode());
        result = prime * result + ((getNnlightctlRepertoryId() == null) ? 0 : getNnlightctlRepertoryId().hashCode());
        result = prime * result + ((getNnlightctlSupplierId() == null) ? 0 : getNnlightctlSupplierId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", gmtCreated=").append(gmtCreated);
        sb.append(", gmtUpdated=").append(gmtUpdated);
        sb.append(", uid=").append(uid);
        sb.append(", propertyRecordDatetime=").append(propertyRecordDatetime);
        sb.append(", longitude=").append(longitude);
        sb.append(", latitude=").append(latitude);
        sb.append(", ctype=").append(ctype);
        sb.append(", price=").append(price);
        sb.append(", commanProperty=").append(commanProperty);
        sb.append(", propertyManagerId=").append(propertyManagerId);
        sb.append(", nnlightctlPropertyId=").append(nnlightctlPropertyId);
        sb.append(", state=").append(state);
        sb.append(", nnlightctlPropertyClassifyCatalogId=").append(nnlightctlPropertyClassifyCatalogId);
        sb.append(", propertyClassifyCatalogDesc=").append(propertyClassifyCatalogDesc);
        sb.append(", propertyClassifyCatalogName=").append(propertyClassifyCatalogName);
        sb.append(", nnlightctlUserApplierId=").append(nnlightctlUserApplierId);
        sb.append(", propertyCount=").append(propertyCount);
        sb.append(", applyState=").append(applyState);
        sb.append(", inOutState=").append(inOutState);
        sb.append(", reason=").append(reason);
        sb.append(", reasonid=").append(reasonid);
        sb.append(", mem=").append(mem);
        sb.append(", nnlightctlUserId=").append(nnlightctlUserId);
        sb.append(", nnlightctlRepertoryId=").append(nnlightctlRepertoryId);
        sb.append(", nnlightctlSupplierId=").append(nnlightctlSupplierId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}