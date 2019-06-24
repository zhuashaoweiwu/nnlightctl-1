package com.nnlightctl.server;

import com.nnlight.common.Tuple;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.request.LightGroupConditionRequest;
import com.nnlightctl.request.LightGroupRequest;
import com.nnlightctl.vo.LightGroupView;

import java.util.List;
import java.util.Map;

public interface LightGroupServer {
    int createLightGroupByLightIds(LightGroupRequest request);
    int createLightGroupByLightUIDs(LightGroupRequest request);
    int createLightGroupByLightGroup(LightGroupRequest request);

    Tuple.TwoTuple<List<LightGroupView>, Integer> listLightGroup(LightGroupConditionRequest request);


    Tuple.TwoTuple<List<Map<String,Object>>, Integer> listLightInGroup(LightGroupConditionRequest request);


    int batchDeleteLightGroup(List<Long> lightGroupIds);
    int updateLightGroupFromLightId(LightGroupRequest request);
    int updateLightGroupFromLightGroup(LightGroupRequest request);
}
