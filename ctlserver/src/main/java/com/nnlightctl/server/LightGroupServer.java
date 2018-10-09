package com.nnlightctl.server;

import com.nnlight.common.Tuple;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.request.LightGroupRequest;
import com.nnlightctl.vo.LightGroupView;

import java.util.List;

public interface LightGroupServer {
    int createLightGroupByLightIds(LightGroupRequest request);
    int createLightGroupByLightUIDs(LightGroupRequest request);
    int createLightGroupByLightGroup(LightGroupRequest request);

    Tuple.TwoTuple<List<LightGroupView>, Integer> listLightGroup(LightGroupRequest request);
}
