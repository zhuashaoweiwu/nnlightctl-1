package com.nnlightctl.request;

public class ModbusRequest {
    public String getNetway() {
        return netway;
    }

    public void setNetway(String netway) {
        this.netway = netway;
    }

    public Integer getDirectiveType() {
        return directiveType;
    }

    public void setDirectiveType(Integer directiveType) {
        this.directiveType = directiveType;
    }

    private String netway;
    private Integer directiveType;
}
