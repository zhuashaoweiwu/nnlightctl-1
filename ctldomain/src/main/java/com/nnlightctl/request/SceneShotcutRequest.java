package com.nnlightctl.request;

import javax.validation.constraints.NotNull;

public class SceneShotcutRequest {
    public String getShotcutName() {
        return shotcutName;
    }

    public void setShotcutName(String shotcutName) {
        this.shotcutName = shotcutName;
    }

    public Long getNnlightctlSceneId() {
        return nnlightctlSceneId;
    }

    public void setNnlightctlSceneId(Long nnlightctlSceneId) {
        this.nnlightctlSceneId = nnlightctlSceneId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Long id;

    @NotNull(message = "快捷键名称不能为空！")
    private String shotcutName;

    private Long nnlightctlSceneId;
}
