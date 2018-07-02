package com.nnlightctl.request;

import java.util.ArrayList;
import java.util.List;

public class MapProjectsToInstitutionRequest extends BaseRequest{

    private Long institutionId;

    private List<Long> projectIds=new ArrayList<Long>();

    public Long getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(Long institutionId) {
        this.institutionId = institutionId;
    }

    public List<Long> getProjectIds() {
        return projectIds;
    }

    public void setProjectIds(List<Long> projectIds) {
        this.projectIds = projectIds;
    }
}
