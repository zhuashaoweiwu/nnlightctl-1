package com.nnlightctl.request;

import java.util.Date;
import java.util.List;
public class AlarmRequest extends BaseRequest{

    private List<Long> alarmIds;

    private Byte ctype;

    private Byte isUse;

    private String alarmSource;

    private Date alarmTimeStart;  //-- 10-7,报警时间搜索，开始时间

    private Date alarmTimeEnd;  //-- 10-7,报警时间搜索，结束时间

    private Date removeAlarmTimeStart;  //-- 10-7,解除时间搜索，开始时间

    private Date removeAlarmTimeEnd;  //-- 10-7,解除时间搜索，结束时间

    private Integer state;  //-- 10-7,状态搜索

    public static class BatchAlarmRequest {
        public List<AlarmRequest> getAlarmRequestList() {
            return alarmRequestList;
        }

        public void setAlarmRequestList(List<AlarmRequest> alarmRequestList) {
            this.alarmRequestList = alarmRequestList;
        }

        private List<AlarmRequest> alarmRequestList;
    }



    public Byte getCtype() {
        return ctype;
    }

    public void setCtype(Byte ctype) {
        this.ctype = ctype;
    }

    public Byte getIsUse() {
        return isUse;
    }

    public void setIsUse(Byte isUse) {
        this.isUse = isUse;
    }

    public String getAlarmSource() {
        return alarmSource;
    }

    public void setAlarmSource(String alarmSource) {
        this.alarmSource = alarmSource;
    }

    public List<Long> getAlarmIds() {
        return alarmIds;
    }

    public void setAlarmIds(List<Long> alarmIds) {
        this.alarmIds = alarmIds;
    }

    public Date getAlarmTimeStart() {
        return alarmTimeStart;
    }

    public void setAlarmTimeStart(Date alarmTimeStart) {
        this.alarmTimeStart = alarmTimeStart;
    }

    public Date getAlarmTimeEnd() {
        return alarmTimeEnd;
    }

    public void setAlarmTimeEnd(Date alarmTimeEnd) {
        this.alarmTimeEnd = alarmTimeEnd;
    }

    public Date getRemoveAlarmTimeStart() {
        return removeAlarmTimeStart;
    }

    public void setRemoveAlarmTimeStart(Date removeAlarmTimeStart) {
        this.removeAlarmTimeStart = removeAlarmTimeStart;
    }

    public Date getRemoveAlarmTimeEnd() {
        return removeAlarmTimeEnd;
    }

    public void setRemoveAlarmTimeEnd(Date removeAlarmTimeEnd) {
        this.removeAlarmTimeEnd = removeAlarmTimeEnd;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
