package com.nnlightctl.po;

import java.util.Date;

public class SwitchTaskInfo {

    public SwitchTaskInfo() {
    }

    public SwitchTaskInfo(Date beginTime,  Long switchTaskId,Byte lightPercent) {
        this.lightPercent = lightPercent;
        this.beginTime = beginTime;
        this.switchTaskId = switchTaskId;
        this.createDate = new Date();
        this.lastUpdateDate = new Date();
    }

    public SwitchTaskInfo(Long id ,Date beginTime, Long switchTaskId,Byte lightPercent) {
        this.id = id;
        this.beginTime = beginTime;
        this.switchTaskId = switchTaskId;
        this.lightPercent = lightPercent;
        this.lastUpdateDate = new Date();
    }



    private Long id;

    private Date beginTime;

    private Byte lightPercent;

    private Long switchTaskId;

    private Date createDate;

    private Date lastUpdateDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Byte getLightPercent() {
        return lightPercent;
    }

    public void setLightPercent(Byte lightPercent) {
        this.lightPercent = lightPercent;
    }

    public Long getSwitchTaskId() {
        return switchTaskId;
    }

    public void setSwitchTaskId(Long switchTaskId) {
        this.switchTaskId = switchTaskId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}