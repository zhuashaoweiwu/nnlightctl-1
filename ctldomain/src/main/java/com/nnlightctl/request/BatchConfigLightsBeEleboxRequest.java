package com.nnlightctl.request;

import java.util.List;

public class BatchConfigLightsBeEleboxRequest {
    private List<Long> lightIds;  //-- 批量设置的灯具的id的集合

    private Long beEleboxId;    //-- 所属控制柜id

    private  Long modelLoopId;   //-- 所属控制柜下回路id

    public List<Long> getLightIds() {
        return lightIds;
    }

    public void setLightIds(List<Long> lightIds) {
        this.lightIds = lightIds;
    }

    public Long getBeEleboxId() {
        return beEleboxId;
    }

    public void setBeEleboxId(Long beEleboxId) {
        this.beEleboxId = beEleboxId;
    }

    public Long getModelLoopId() {
        return modelLoopId;
    }

    public void setModelLoopId(Long modelLoopId) {
        this.modelLoopId = modelLoopId;
    }
}
