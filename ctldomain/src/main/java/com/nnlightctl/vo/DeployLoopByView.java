package com.nnlightctl.vo;

import java.util.List;

public class DeployLoopByView {

    private Long id;

    private String loopCode;

    private String mem;

    private List<DeployLoopLightctlByView> lightctlList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoopCode() {
        return loopCode;
    }

    public void setLoopCode(String loopCode) {
        this.loopCode = loopCode;
    }

    public String getMem() {
        return mem;
    }

    public void setMem(String mem) {
        this.mem = mem;
    }

    public List<DeployLoopLightctlByView> getLightctlList() {
        return lightctlList;
    }

    public void setLightctlList(List<DeployLoopLightctlByView> lightctlList) {
        this.lightctlList = lightctlList;
    }
}