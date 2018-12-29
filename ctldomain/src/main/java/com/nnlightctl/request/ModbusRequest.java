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

    public String getHexModbusDirective() {
        return hexModbusDirective;
    }

    public void setHexModbusDirective(String hexModbusDirective) {
        this.hexModbusDirective = hexModbusDirective;
    }

    private String hexModbusDirective;
    private String netway;
    private Integer directiveType;
}
