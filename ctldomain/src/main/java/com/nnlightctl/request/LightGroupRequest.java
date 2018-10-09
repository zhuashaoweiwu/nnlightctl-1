package com.nnlightctl.request;

import java.util.ArrayList;
import java.util.List;

public class LightGroupRequest extends BaseRequest{
    public String getcGroupName() {
        return cGroupName;
    }

    public void setcGroupName(String cGroupName) {
        this.cGroupName = cGroupName;
    }

    public String getMem() {
        return mem;
    }

    public void setMem(String mem) {
        this.mem = mem;
    }

    public List<Long> getLightIds() {
        return lightIds;
    }

    public void setLightIds(List<Long> lightIds) {
        this.lightIds = lightIds;
    }

    public List<String> getLightUIDs() {
        return lightUIDs;
    }

    public void setLightUIDs(List<String> lightUIDs) {
        this.lightUIDs = lightUIDs;
    }

    public List<Long> getLightGroupIds() {
        return lightGroupIds;
    }

    public void setLightGroupIds(List<Long> lightGroupIds) {
        this.lightGroupIds = lightGroupIds;
    }

    private String cGroupName;
    private String mem;
    private List<Long> lightIds;
    private List<String> lightUIDs;
    private List<Long> lightGroupIds;

}
