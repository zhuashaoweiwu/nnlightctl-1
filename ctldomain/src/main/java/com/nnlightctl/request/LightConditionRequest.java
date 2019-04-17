package com.nnlightctl.request;

import java.util.List;

public class LightConditionRequest extends BaseRequest {
    public List<Long> getDeleteLightIdList() {
        return deleteLightIdList;
    }

    public void setDeleteLightIdList(List<Long> deleteLightIdList) {
        this.deleteLightIdList = deleteLightIdList;
    }

    public Long getEleboxId() {
        return eleboxId;
    }

    public void setEleboxId(Long eleboxId) {
        this.eleboxId = eleboxId;
    }

    public Integer getNotBe() {
        return notBe;
    }

    public void setNotBe(Integer notBe) {
        this.notBe = notBe;
    }

    public List<Long> getLightIdList() {
        return lightIdList;
    }

    public void setLightIdList(List<Long> lightIdList) {
        this.lightIdList = lightIdList;
    }

    public Long getBeEleboxId() {
        return beEleboxId;
    }

    public void setBeEleboxId(Long beEleboxId) {
        this.beEleboxId = beEleboxId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getModelLoopId() {
        return modelLoopId;
    }

    public void setModelLoopId(Long modelLoopId) {
        this.modelLoopId = modelLoopId;
    }

    public String getStartLongitude() {
        return startLongitude;
    }

    public void setStartLongitude(String startLongitude) {
        this.startLongitude = startLongitude;
    }

    public String getStartLatitude() {
        return startLatitude;
    }

    public void setStartLatitude(String startLatitude) {
        this.startLatitude = startLatitude;
    }

    public String getEndLongitude() {
        return endLongitude;
    }

    public void setEndLongitude(String endLongitude) {
        this.endLongitude = endLongitude;
    }

    public String getEndLatitude() {
        return endLatitude;
    }

    public void setEndLatitude(String endLatitude) {
        this.endLatitude = endLatitude;
    }

    public List<Long> getOriginalLightIds() {
        return originalLightIds;
    }

    public void setOriginalLightIds(List<Long> originalLightIds) {
        this.originalLightIds = originalLightIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getLightingCode() {
        return lightingCode;
    }

    public void setLightingCode(String lightingCode) {
        this.lightingCode = lightingCode;
    }

    private String uuid;
    private String lightingCode;

    private Long id;
    private Integer priority;

    private String startLongitude;
    private String startLatitude;
    private String endLongitude;
    private String endLatitude;

    private Long modelLoopId;

    private List<Long> originalLightIds;
    private List<Long> lightIdList;
    private Long beEleboxId;

    private Long eleboxId;
    private Integer notBe;
    private List<Long> deleteLightIdList;

    private Long projectId;
}
