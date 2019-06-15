package com.nnlightctl.request.deployRequest;

import com.nnlightctl.request.BaseRequest;

import java.util.List;

public class DeployEleboxModelLoopRequest  extends BaseRequest {

    private String loopCode;

    private String mem;

    private List<Long> lightingList;

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

    public List<Long> getLightingList() {
        return lightingList;
    }

    public void setLightingList(List<Long> lightingList) {
        this.lightingList = lightingList;
    }
}
