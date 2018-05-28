package com.nnlightctl.server;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.LightingModel;
import com.nnlightctl.request.LightModelConditionRequest;
import com.nnlightctl.request.LightModelRequest;

import java.util.List;

public interface LightModelServer {
    int addOrUpdateLightModel(LightModelRequest request);
    int deleteLightModel(LightModelConditionRequest request);
    Tuple.TwoTuple<List<LightingModel>, Integer> listLightModel(LightModelConditionRequest request);
}
