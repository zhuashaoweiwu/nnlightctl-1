package com.nnlightctl.request;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class SwitchTaskRequest {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSwitchName() {
        return switchName;
    }

    public void setSwitchName(String switchName) {
        this.switchName = switchName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Byte getIsLighton() {
        return isLighton;
    }

    public void setIsLighton(Byte isLighton) {
        this.isLighton = isLighton;
    }

    public Byte getIsUsebeam() {
        return isUsebeam;
    }

    public void setIsUsebeam(Byte isUsebeam) {
        this.isUsebeam = isUsebeam;
    }

    public Byte getPeriod() {
        return period;
    }

    public void setPeriod(Byte period) {
        this.period = period;
    }

    public Byte getLightPercent() {
        return lightPercent;
    }

    public void setLightPercent(Byte lightPercent) {
        this.lightPercent = lightPercent;
    }

    private Long id;

    @NotBlank(message = "名称不能为空！")
    private String switchName;

    private Date startTime;

    private Date endTime;

    private Byte isLighton;

    private Byte isUsebeam;

    @NotNull(message = "周期不能为空！")
    private Byte period;

    private Byte lightPercent;
}
