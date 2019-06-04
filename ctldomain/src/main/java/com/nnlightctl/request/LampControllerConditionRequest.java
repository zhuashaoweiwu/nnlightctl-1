package com.nnlightctl.request;


import java.util.List;

public class LampControllerConditionRequest extends BaseRequest{

    private List<Long> centralizeIds;

    public List<Long> getCentralizeIds() {
        return centralizeIds;
    }

    public void setCentralizeIds(List<Long> centralizeIds) {
        this.centralizeIds = centralizeIds;
    }
}
