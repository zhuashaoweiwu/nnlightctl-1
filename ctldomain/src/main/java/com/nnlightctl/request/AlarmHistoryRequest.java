package com.nnlightctl.request;

import java.util.List;
public class AlarmHistoryRequest extends BaseRequest {

    private List<Long> alarmHistoryIds;

    public List<Long> getAlarmHistoryIds() {
        return alarmHistoryIds;
    }

    public void setAlarmHistoryIds(List<Long> alarmHistoryIds) {
        this.alarmHistoryIds = alarmHistoryIds;
    }
}
