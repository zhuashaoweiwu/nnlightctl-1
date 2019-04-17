package com.nnlightctl.vo;

import java.util.Date;
import java.util.List;

public class LightGroupView extends BaseView {

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

    public List<Lighting> getLightingList() {
        return lightingList;
    }

    public void setLightingList(List<Lighting> lightingList) {
        this.lightingList = lightingList;
    }

    public List<LightingGroup> getLightingGroupList() {
        return lightingGroupList;
    }

    public void setLightingGroupList(List<LightingGroup> lightingGroupList) {
        this.lightingGroupList = lightingGroupList;
    }

    private String cGroupName;

    private String mem;

    private List<Lighting> lightingList;

    private List<LightingGroup> lightingGroupList;

    public static class Lighting {
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

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public Date getManufacture() {
            return manufacture;
        }

        public void setManufacture(Date manufacture) {
            this.manufacture = manufacture;
        }

        public Date getUseDate() {
            return useDate;
        }

        public void setUseDate(Date useDate) {
            this.useDate = useDate;
        }

        public String getLamppost() {
            return lamppost;
        }

        public void setLamppost(String lamppost) {
            this.lamppost = lamppost;
        }

        public String getLamphead() {
            return lamphead;
        }

        public void setLamphead(String lamphead) {
            this.lamphead = lamphead;
        }

        public Long getNnlightctlLightingModelId() {
            return nnlightctlLightingModelId;
        }

        public void setNnlightctlLightingModelId(Long nnlightctlLightingModelId) {
            this.nnlightctlLightingModelId = nnlightctlLightingModelId;
        }

        public Long getNnlightctlLightingGisId() {
            return nnlightctlLightingGisId;
        }

        public void setNnlightctlLightingGisId(Long nnlightctlLightingGisId) {
            this.nnlightctlLightingGisId = nnlightctlLightingGisId;
        }

        public String getPropertySerialNumber() {
            return propertySerialNumber;
        }

        public void setPropertySerialNumber(String propertySerialNumber) {
            this.propertySerialNumber = propertySerialNumber;
        }

        public Long getDecay() {
            return decay;
        }

        public void setDecay(Long decay) {
            this.decay = decay;
        }

        public Long getMaxUseTime() {
            return maxUseTime;
        }

        public void setMaxUseTime(Long maxUseTime) {
            this.maxUseTime = maxUseTime;
        }

        public String getMem() {
            return mem;
        }

        public void setMem(String mem) {
            this.mem = mem;
        }

        public Long getNnlightctlEleboxModelLoopId() {
            return nnlightctlEleboxModelLoopId;
        }

        public void setNnlightctlEleboxModelLoopId(Long nnlightctlEleboxModelLoopId) {
            this.nnlightctlEleboxModelLoopId = nnlightctlEleboxModelLoopId;
        }

        public Long getNnlightctlRegionId() {
            return nnlightctlRegionId;
        }

        public void setNnlightctlRegionId(Long nnlightctlRegionId) {
            this.nnlightctlRegionId = nnlightctlRegionId;
        }

        public Long getNnlightctlProjectId() {
            return nnlightctlProjectId;
        }

        public void setNnlightctlProjectId(Long nnlightctlProjectId) {
            this.nnlightctlProjectId = nnlightctlProjectId;
        }

        public Long getNnlightctlEleboxId() {
            return nnlightctlEleboxId;
        }

        public void setNnlightctlEleboxId(Long nnlightctlEleboxId) {
            this.nnlightctlEleboxId = nnlightctlEleboxId;
        }

        private Long id;

        private Date gmtCreated;

        private Date gmtUpdated;

        private String uid;

        private Date manufacture;

        private Date useDate;

        private String lamppost;

        private String lamphead;

        private Long nnlightctlLightingModelId;

        private Long nnlightctlLightingGisId;

        private String propertySerialNumber;

        private Long decay;

        private Long maxUseTime;

        private String mem;

        private Long nnlightctlEleboxModelLoopId;

        private Long nnlightctlRegionId;

        private Long nnlightctlProjectId;

        private Long nnlightctlEleboxId;
    }

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

}
