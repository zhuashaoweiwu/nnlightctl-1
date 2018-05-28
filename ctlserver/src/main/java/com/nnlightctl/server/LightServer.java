package com.nnlightctl.server;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.Lighting;
import com.nnlightctl.request.LightConditionRequest;
import com.nnlightctl.request.LightRequest;

import java.util.List;

public interface LightServer {
    int addOrUpdateLight(LightRequest request);
    int deleteLight(LightConditionRequest request);
    Tuple.TwoTuple<List<Lighting>, Integer> listLighting(LightConditionRequest request);
    int updateLightBeElebox(LightConditionRequest request);
}
