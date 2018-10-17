package com.nnlightctl.request;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.List;

public class SceneRequest extends BaseRequest{
    public String getSceneName() {
        return sceneName;
    }

    public void setSceneName(String sceneName) {
        this.sceneName = sceneName;
    }

    public String getSceneDesc() {
        return sceneDesc;
    }

    public void setSceneDesc(String sceneDesc) {
        this.sceneDesc = sceneDesc;
    }

    public List<Long> getLightingGroupIds() {
        return lightingGroupIds;
    }

    public void setLightingGroupIds(List<Long> lightingGroupIds) {
        this.lightingGroupIds = lightingGroupIds;
    }

    public List<Long> getSwitchTaskIds() {
        return switchTaskIds;
    }

    public void setSwitchTaskIds(List<Long> switchTaskIds) {
        this.switchTaskIds = switchTaskIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Long id;
    @NotBlank(message = "场景模式名称不能为空！")
    private String sceneName;

    private String sceneDesc;

    private List<Long> lightingGroupIds;

    private List<Long> switchTaskIds;
}
