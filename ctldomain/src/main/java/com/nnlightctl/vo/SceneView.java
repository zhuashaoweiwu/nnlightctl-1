package com.nnlightctl.vo;

import java.util.Date;
import java.util.List;

public class SceneView extends BaseView {
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

    public List<LightingGroup> getLightingGroups() {
        return lightingGroups;
    }

    public void setLightingGroups(List<LightingGroup> lightingGroups) {
        this.lightingGroups = lightingGroups;
    }

    public List<SwitchTask> getSwitchTasks() {
        return switchTasks;
    }

    public void setSwitchTasks(List<SwitchTask> switchTasks) {
        this.switchTasks = switchTasks;
    }

    private String sceneName;

    private String sceneDesc;

    private List<LightingGroup> lightingGroups;

    private List<SwitchTask> switchTasks;

    public static class LightingGroup {
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Date getGmtCreated() {
            return gmtCreated;
        }

        public void setGmtCreated(Date gmtCreated) {
            this.gmtCreated = gmtCreated;
        }

        public Date getGmtUpdated() {
            return gmtUpdated;
        }

        public void setGmtUpdated(Date gmtUpdated) {
            this.gmtUpdated = gmtUpdated;
        }

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

        private Long id;

        private Date gmtCreated;

        private Date gmtUpdated;

        private String cGroupName;

        private String mem;
    }

    public static class SwitchTask {
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Date getGmtCreated() {
            return gmtCreated;
        }

        public void setGmtCreated(Date gmtCreated) {
            this.gmtCreated = gmtCreated;
        }

        public Date getGmtUpdated() {
            return gmtUpdated;
        }

        public void setGmtUpdated(Date gmtUpdated) {
            this.gmtUpdated = gmtUpdated;
        }

        public String getSwitchName() {
            return switchName;
        }

        public void setSwitchName(String switchName) {
            this.switchName = switchName;
        }

        public Date getStartTime() {
            return startTime;
        }

        public void setStartTime(Date startTime) {
            this.startTime = startTime;
        }

        public Date getEndTime() {
            return endTime;
        }

        public void setEndTime(Date endTime) {
            this.endTime = endTime;
        }

        public Byte getIsLighton() {
            return isLighton;
        }

        public void setIsLighton(Byte isLighton) {
            this.isLighton = isLighton;
        }

        public Byte getIsUsebeam() {
            return isUsebeam;
        }

        public void setIsUsebeam(Byte isUsebeam) {
            this.isUsebeam = isUsebeam;
        }

        public Byte getPeriod() {
            return period;
        }

        public void setPeriod(Byte period) {
            this.period = period;
        }

        public Byte getLightPercent() {
            return lightPercent;
        }

        public void setLightPercent(Byte lightPercent) {
            this.lightPercent = lightPercent;
        }

        private Long id;

        private Date gmtCreated;

        private Date gmtUpdated;

        private String switchName;

        private Date startTime;

        private Date endTime;

        private Byte isLighton;

        private Byte isUsebeam;

        private Byte period;

        private Byte lightPercent;
    }
}
