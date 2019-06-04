package com.nnlightctl.request;

import java.util.List;

public class LamppostConditionRequest extends BaseRequest{

    private List<Long> lamppostIds;

    public List<Long> getLamppostIds() {
        return lamppostIds;
    }

    public void setLamppostIds(List<Long> lamppostIds) {
        this.lamppostIds = lamppostIds;
    }
}
