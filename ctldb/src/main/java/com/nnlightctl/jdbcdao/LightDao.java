package com.nnlightctl.jdbcdao;

import com.nnlight.common.Tuple;
import com.nnlightctl.request.LightConditionRequest;
import com.nnlightctl.vo.LightingView;

import java.util.List;

public interface LightDao {
    int clearLightBeEleboxBeLoop(Long eleboxId, Long modelLoopId);

    Tuple.TwoTuple<List<LightingView>, Integer> listLightingView(LightConditionRequest request);
}
