package com.nnlightctl.jdbcdao;

import com.nnlight.common.Tuple;
import com.nnlightctl.net.CommandData;
import com.nnlightctl.po.Lighting;
import com.nnlightctl.request.LightConditionRequest;
import com.nnlightctl.vo.LightingView;

import java.util.List;

public interface LightDao {
    int clearLightBeEleboxBeLoop(List<Long> lightIds);

    Tuple.TwoTuple<List<LightingView>, Integer> listLightingView(LightConditionRequest request);

    Tuple.TwoTuple<List<LightingView>, Integer> listLoopLightingView(LightConditionRequest request);

    List<Lighting> getLightingByUUID(String uuid);
}
