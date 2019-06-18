package com.nnlightctl.request.deployRequest;

import com.nnlightctl.request.BaseRequest;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

public class DeployExleboxArrangeRequest  extends BaseRequest {

    private Long exleboxId;

    private List<Long> exleboxModelIds;//开关

    private List<Long> electricityMeterIds;//电表

    private List<Long> photoperiodIds;//光照计

    private List<Long> centralizeControllerIds;//集中控制器


    private List<DeployEleboxModelLoopRequest> modelLoopRequests;

    private List<DeployEleboxModelLoopRequest> controllerRequests;


    public List<DeployEleboxModelLoopRequest> getModelLoopRequests() {
        return modelLoopRequests;
    }

    public void setModelLoopRequests(List<DeployEleboxModelLoopRequest> modelLoopRequests) {
        this.modelLoopRequests = modelLoopRequests;
    }

    public List<DeployEleboxModelLoopRequest> getControllerRequests() {
        return controllerRequests;
    }

    public void setControllerRequests(List<DeployEleboxModelLoopRequest> controllerRequests) {
        this.controllerRequests = controllerRequests;
    }

    public List<Long> getExleboxModelIds() {
        return exleboxModelIds;
    }

    public void setExleboxModelIds(List<Long> exleboxModelIds) {
        this.exleboxModelIds = exleboxModelIds;
    }

    public List<Long> getElectricityMeterIds() {
        return electricityMeterIds;
    }

    public void setElectricityMeterIds(List<Long> electricityMeterIds) {
        this.electricityMeterIds = electricityMeterIds;
    }

    public List<Long> getPhotoperiodIds() {
        return photoperiodIds;
    }

    public void setPhotoperiodIds(List<Long> photoperiodIds) {
        this.photoperiodIds = photoperiodIds;
    }

    public List<Long> getCentralizeControllerIds() {
        return centralizeControllerIds;
    }

    public void setCentralizeControllerIds(List<Long> centralizeControllerIds) {
        this.centralizeControllerIds = centralizeControllerIds;
    }

    public Long getExleboxId() {
        return exleboxId;
    }

    public void setExleboxId(Long exleboxId) {
        this.exleboxId = exleboxId;
    }

}
