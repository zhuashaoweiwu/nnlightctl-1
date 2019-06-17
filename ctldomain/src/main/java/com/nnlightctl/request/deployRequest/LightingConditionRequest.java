package com.nnlightctl.request.deployRequest;

import com.nnlightctl.request.BaseRequest;

import java.util.List;

public class LightingConditionRequest extends BaseRequest {

    private Long id;

    private List<Long> lightingControllerIds;

    private String lampName;

    private String lampModel;

    private Integer deployState;

    public Integer getDeployState() {
        return deployState;
    }

    public void setDeployState(Integer deployState) {
        this.deployState = deployState;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    private  String uid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getLightingControllerIds() {
        return lightingControllerIds;
    }

    public void setLightingControllerIds(List<Long> lightingControllerIds) {
        this.lightingControllerIds = lightingControllerIds;
    }

    public String getLampName() {
        return lampName;
    }

    public void setLampName(String lampName) {
        this.lampName = lampName;
    }

    public String getLampModel() {
        return lampModel;
    }

    public void setLampModel(String lampModel) {
        this.lampModel = lampModel;
    }
}
