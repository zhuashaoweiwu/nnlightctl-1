package com.nnlightctl.request;

import java.util.Date;
import java.util.List;
public class LightingVolEleRecordRequest extends BaseRequest{

    private List<Long> lightIds;  //-- 选择的灯具的id集合

    private Date startDate;  //-- 开始时间

    private Date endDate;  //-- 结束时间

    public List<Long> getLightIds() {
        return lightIds;
    }

    public void setLightIds(List<Long> lightIds) {
        this.lightIds = lightIds;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
