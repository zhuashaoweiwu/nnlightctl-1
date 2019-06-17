package com.nnlightctl.request;

import java.util.List;

public class EleboxConditionRequest extends BaseRequest {
    public List<Long> getDeleteModelIdList() {
        return deleteModelIdList;
    }

    public void setDeleteModelIdList(List<Long> deleteModelIdList) {
        this.deleteModelIdList = deleteModelIdList;
    }

    public List<Long> getAddModelIdList() {
        return addModelIdList;
    }

    public void setAddModelIdList(List<Long> addModelIdList) {
        this.addModelIdList = addModelIdList;
    }

    public Long getBeSplitId() {
        return beSplitId;
    }

    public void setBeSplitId(Long beSplitId) {
        this.beSplitId = beSplitId;
    }

    public List<ModelLoopRequest> getSplitModelLoopList() {
        return splitModelLoopList;
    }

    public void setSplitModelLoopList(List<ModelLoopRequest> splitModelLoopList) {
        this.splitModelLoopList = splitModelLoopList;
    }

    public List<Long> getEleboxIdList() {
        return eleboxIdList;
    }

    public void setEleboxIdList(List<Long> eleboxIdList) {
        this.eleboxIdList = eleboxIdList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getEleboxId() {
        return eleboxId;
    }

    public void setEleboxId(Long eleboxId) {
        this.eleboxId = eleboxId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCodeNumber() {
        return codeNumber;
    }

    public void setCodeNumber(String codeNumber) {
        this.codeNumber = codeNumber;
    }

    public String getEleboxName() {
        return eleboxName;
    }

    public void setEleboxName(String eleboxName) {
        this.eleboxName = eleboxName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    private String uid;

    private String codeNumber;

    private Long eleboxId;

    private String eleboxName;

    private String modelName;

    private Long id;

    private List<Long> eleboxIdList;

    private Long beSplitId;
    private List<ModelLoopRequest> splitModelLoopList;

    private List<Long> deleteModelIdList;
    private List<Long> addModelIdList;

    private Long projectId;

    private String equipmentNumber;

    private String eleboxMode;



    public String getEleboxMode() {
        return eleboxMode;
    }

    public void setEleboxMode(String eleboxMode) {
        this.eleboxMode = eleboxMode;
    }



    public String getEquipmentNumber() {
        return equipmentNumber;
    }

    public void setEquipmentNumber(String equipmentNumber) {
        this.equipmentNumber = equipmentNumber;
    }
}
