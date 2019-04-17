package com.nnlightctl.request;

import java.util.Date;

public class SignalLogRequest extends BaseRequest{

    private String uuid;// -- uuid查询，支持模糊查询

    private Date startDate;// -- 搜索开始时间

    private Date endDate;// -- 搜索结束时间

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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
