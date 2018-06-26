package com.nnlightctl.request;

import java.math.BigDecimal;

public class SystemParamRequest {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeNumber() {
        return codeNumber;
    }

    public void setCodeNumber(String codeNumber) {
        this.codeNumber = codeNumber == null ? null : codeNumber.trim();
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName == null ? null : configName.trim();
    }

    public BigDecimal getConfigValue() {
        return configValue;
    }

    public void setConfigValue(BigDecimal configValue) {
        this.configValue = configValue;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getMem() {
        return mem;
    }

    public void setMem(String mem) {
        this.mem = mem == null ? null : mem.trim();
    }

    private Long id;
    /*系统参数唯一编码*/
    private String codeNumber;
    /*系统参数名称*/
    private String configName;
    /*系统参数值*/
    private BigDecimal configValue;
    /*单位*/
    private String unit;
    /*备注*/
    private String mem;
}
