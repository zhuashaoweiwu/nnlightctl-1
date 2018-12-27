package com.nnlightctl.net;

public class ModBusResponse {
    public String getOriginalPackageInfoHex() {
        return originalPackageInfoHex;
    }

    public void setOriginalPackageInfoHex(String originalPackageInfoHex) {
        this.originalPackageInfoHex = originalPackageInfoHex;
    }

    //16进制原始报文信息
    private String originalPackageInfoHex;
}
