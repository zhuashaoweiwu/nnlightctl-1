package com.nnlightctl.request;

import java.util.List;

public class LightGroupConditionRequest extends BaseRequest {
    public String getcGroupName() {
        return cGroupName;
    }

    public void setcGroupName(String cGroupName) {
        this.cGroupName = cGroupName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getLightGroupIdArray() {
        return lightGroupIdArray;
    }

    public void setLightGroupIdArray(List<Long> lightGroupIdArray) {
        this.lightGroupIdArray = lightGroupIdArray;
    }

    private List<Long> lightGroupIdArray;

    private Long id;

    private String cGroupName;

    private Long groupId;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
}
