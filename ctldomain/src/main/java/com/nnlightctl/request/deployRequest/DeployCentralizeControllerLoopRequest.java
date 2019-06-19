package com.nnlightctl.request.deployRequest;

import java.util.List;

public class DeployCentralizeControllerLoopRequest {

    private String loopCode;

    private String mem;

    private String centralizeModel;

    private String centralizeName;

    private List<Long> lightingList;





    public String getCentralizeModel() {
        return centralizeModel;
    }

    public void setCentralizeModel(String centralizeModel) {
        this.centralizeModel = centralizeModel;
    }

    public String getCentralizeName() {
        return centralizeName;
    }

    public void setCentralizeName(String centralizeName) {
        this.centralizeName = centralizeName;
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

    public List<Long> getLightingList() {
        return lightingList;
    }

    public void setLightingList(List<Long> lightingList) {
        this.lightingList = lightingList;
    }
}
