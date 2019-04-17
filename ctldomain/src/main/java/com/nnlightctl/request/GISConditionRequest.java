package com.nnlightctl.request;

import java.util.List;

public class GISConditionRequest extends BaseRequest {
    public List<Long> getGisIDList() {
        return gisIDList;
    }

    public void setGisIDList(List<Long> gisIDList) {
        this.gisIDList = gisIDList;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    private List<Long> gisIDList;
    private int type;
}
