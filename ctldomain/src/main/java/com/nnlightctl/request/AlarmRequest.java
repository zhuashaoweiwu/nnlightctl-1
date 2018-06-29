package com.nnlightctl.request;

import java.util.List;
public class AlarmRequest extends BaseRequest{

    private List<Long> alarmIds;

    public List<Long> getAlarmIds() {
        return alarmIds;
    }

    public void setAlarmIds(List<Long> alarmIds) {
        this.alarmIds = alarmIds;
    }

}
