package com.nnlightctl.request.deployRequest;

import com.nnlightctl.vo.*;

import java.util.List;

public class DeployLighting {

    private List<LightingView> lightingViews;

    private List<LamppostView> lamppostViews;

    private List<LampControllerView> lampControllerViews;

    private List<ProjectView> projectViewList;

    public List<LamppostView> getLamppostViews() {
        return lamppostViews;
    }

    public void setLamppostViews(List<LamppostView> lamppostViews) {
        this.lamppostViews = lamppostViews;
    }

    public List<LightingView> getLightingViews() {
        return lightingViews;
    }

    public void setLightingViews(List<LightingView> lightingViews) {
        this.lightingViews = lightingViews;
    }


    public List<LampControllerView> getLampControllerViews() {
        return lampControllerViews;
    }

    public void setLampControllerViews(List<LampControllerView> lampControllerViews) {
        this.lampControllerViews = lampControllerViews;
    }

    public List<ProjectView> getProjectViewList() {
        return projectViewList;
    }

    public void setProjectViewList(List<ProjectView> projectViewList) {
        this.projectViewList = projectViewList;
    }
}
