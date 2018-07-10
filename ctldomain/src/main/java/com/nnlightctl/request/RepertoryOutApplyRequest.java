package com.nnlightctl.request;

import java.util.Date;
import java.util.List;

public class RepertoryOutApplyRequest {

    List<Long> applyOutRepertoryIds;

    private Long id;

    private Date gmtCreated;

    private Date gmtUpdated;

    private String serialnumber;

    private Long nnlightctlPropertyId;

    private Long nnlightctlUserId;

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

    public Long getNnlightctlPropertyId() {
        return nnlightctlPropertyId;
    }

    public void setNnlightctlPropertyId(Long nnlightctlPropertyId) {
        this.nnlightctlPropertyId = nnlightctlPropertyId;
    }

    public Long getNnlightctlUserId() {
        return nnlightctlUserId;
    }

    public void setNnlightctlUserId(Long nnlightctlUserId) {
        this.nnlightctlUserId = nnlightctlUserId;
    }

    public Byte getApplyState() {
        return applyState;
    }

    public void setApplyState(Byte applyState) {
        this.applyState = applyState;
    }

    public List<Long> getApplyOutRepertoryIds() {
        return applyOutRepertoryIds;
    }

    public void setApplyOutRepertoryIds(List<Long> applyOutRepertoryIds) {
        this.applyOutRepertoryIds = applyOutRepertoryIds;
    }
}
