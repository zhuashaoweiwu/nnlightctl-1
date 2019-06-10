package com.nnlightctl.request;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LamppostConditionRequest extends BaseRequest{

    private Long id;

    private List<Long> lamppostIds;

    private Map parameter;

    public Map getParameter() {
        return parameter;
    }

    public void setParameter(Map parameter) {
        this.parameter = parameter;
    }

    public List<Long> getLamppostIds() {
        return lamppostIds;
    }

    public void setLamppostIds(List<Long> lamppostIds) {
        this.lamppostIds = lamppostIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
