package com.nnlightctl.request;

import java.util.List;

public class SwitchTaskConditionRequest extends BaseRequest {
    public List<Long> getSwitchTaskIds() {
        return switchTaskIds;
    }

    public void setSwitchTaskIds(List<Long> switchTaskIds) {
        this.switchTaskIds = switchTaskIds;
    }

    private List<Long> switchTaskIds;
}
