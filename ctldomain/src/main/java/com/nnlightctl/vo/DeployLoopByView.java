package com.nnlightctl.vo;

import java.util.List;

public class DeployLoopByView {

    private Long id;

    private String loopCode;

    private String mem;

    private Long exleboxModelId;

    private List<DeployLoopLightctlByView> lightingList;

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

    public List<DeployLoopLightctlByView> getLightingList() {
        return lightingList;
    }

    public void setLightingList(List<DeployLoopLightctlByView> lightingList) {
        this.lightingList = lightingList;
    }

    public Long getExleboxModelId() {
        return exleboxModelId;
    }

    public void setExleboxModelId(Long exleboxModelId) {
        this.exleboxModelId = exleboxModelId;
    }
}
