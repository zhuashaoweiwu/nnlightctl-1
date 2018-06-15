package com.nnlightctl.request;

import java.util.List;

public class DepartmentConditionRequest extends BaseRequest {
    public List<Long> getDepartmentIds() {
        return departmentIds;
    }

    public void setDepartmentIds(List<Long> departmentIds) {
        this.departmentIds = departmentIds;
    }

    private List<Long> departmentIds;
}
