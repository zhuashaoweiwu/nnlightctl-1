package com.nnlightctl.vo;

public class ListDeviceDamageCountByMonthView extends BaseView{

    private String month;

    private Long monthCount;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Long getMonthCount() {
        return monthCount;
    }

    public void setMonthCount(Long monthCount) {
        this.monthCount = monthCount;
    }
}
