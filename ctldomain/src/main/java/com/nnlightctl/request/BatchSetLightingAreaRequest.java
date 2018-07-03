package com.nnlightctl.request;

import java.util.List;

public class BatchSetLightingAreaRequest {


    private Long beAreaId;// -- 区域id

    private List<Long> lightIds;//  -- 批量设置的灯具的id的集合

    public Long getBeAreaId() {
        return beAreaId;
    }

    public void setBeAreaId(Long beAreaId) {
        this.beAreaId = beAreaId;
    }

    public List<Long> getLightIds() {
        return lightIds;
    }

    public void setLightIds(List<Long> lightIds) {
        this.lightIds = lightIds;
    }
}
