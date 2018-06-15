package com.nnlightctl.request;

import java.util.List;

public class InstitutionConditionRequest extends BaseRequest {
    public List<Long> getInstitutionIds() {
        return institutionIds;
    }

    public void setInstitutionIds(List<Long> institutionIds) {
        this.institutionIds = institutionIds;
    }

    private List<Long> institutionIds;
}
