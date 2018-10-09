package com.nnlightctl.request;

import java.util.List;

public class SwitchTaskConditionRequest extends BaseRequest {
    public List<Long> getSwitchTaskIds() {
        return switchTaskIds;
    }

    public void setSwitchTaskIds(List<Long> switchTaskIds) {
        this.switchTaskIds = switchTaskIds;
    }

    public String getSwitchName() {
        return switchName;
    }

    public void setSwitchName(String switchName) {
        this.switchName = switchName;
    }

    private List<Long> switchTaskIds;

    private String switchName;
}
