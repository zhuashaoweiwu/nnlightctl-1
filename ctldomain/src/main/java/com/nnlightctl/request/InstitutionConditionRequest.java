package com.nnlightctl.request;

import java.util.List;

public class InstitutionConditionRequest extends BaseRequest {
    public List<Long> getInstitutionIds() {
        return institutionIds;
    }

    public void setInstitutionIds(List<Long> institutionIds) {
        this.institutionIds = institutionIds;
    }

    public List<Long> getNewProjectIds() {
        return newProjectIds;
    }

    public void setNewProjectIds(List<Long> newProjectIds) {
        this.newProjectIds = newProjectIds;
    }

    public List<Long> getOldProjectIds() {
        return oldProjectIds;
    }

    public void setOldProjectIds(List<Long> oldProjectIds) {
        this.oldProjectIds = oldProjectIds;
    }

    public Long getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(Long institutionId) {
        this.institutionId = institutionId;
    }

    List<Long> newProjectIds;

    List<Long> oldProjectIds;

    private Long institutionId;

    private List<Long> institutionIds;
}
