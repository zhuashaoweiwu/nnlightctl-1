package com.nnlightctl.vo;

import java.util.Date;

public class SwitchTaskInfoView  {

    private Long switchTaskInfoId;

    private Date beginTime;

    private Byte lightPercent;


    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Long getSwitchTaskInfoId() {
        return switchTaskInfoId;
    }

    public void setSwitchTaskInfoId(Long switchTaskInfoId) {
        this.switchTaskInfoId = switchTaskInfoId;
    }


    public Byte getLightPercent() {
        return lightPercent;
    }

    public void setLightPercent(Byte lightPercent) {
        this.lightPercent = lightPercent;
    }
}
