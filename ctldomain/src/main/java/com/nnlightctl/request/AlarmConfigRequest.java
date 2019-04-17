package com.nnlightctl.request;

public class AlarmConfigRequest extends BaseRequest{

    private Byte alarmConfigLevel;

    private Byte isNoticeMap;

    private Byte isNoticeSms;

    private Byte isNoticeEmail;

    private Byte isNoticeWeixin;

    public Byte getAlarmConfigLevel() {
        return alarmConfigLevel;
    }

    public void setAlarmConfigLevel(Byte alarmConfigLevel) {
        this.alarmConfigLevel = alarmConfigLevel;
    }

    public Byte getIsNoticeMap() {
        return isNoticeMap;
    }

    public void setIsNoticeMap(Byte isNoticeMap) {
        this.isNoticeMap = isNoticeMap;
    }

    public Byte getIsNoticeSms() {
        return isNoticeSms;
    }

    public void setIsNoticeSms(Byte isNoticeSms) {
        this.isNoticeSms = isNoticeSms;
    }

    public Byte getIsNoticeEmail() {
        return isNoticeEmail;
    }

    public void setIsNoticeEmail(Byte isNoticeEmail) {
        this.isNoticeEmail = isNoticeEmail;
    }

    public Byte getIsNoticeWeixin() {
        return isNoticeWeixin;
    }

    public void setIsNoticeWeixin(Byte isNoticeWeixin) {
        this.isNoticeWeixin = isNoticeWeixin;
    }
}
