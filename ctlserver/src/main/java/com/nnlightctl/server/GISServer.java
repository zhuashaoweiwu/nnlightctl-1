package com.nnlightctl.server;

import com.nnlight.common.Tuple;
import com.nnlightctl.request.GISConditionRequest;
import com.nnlightctl.request.GISRequest;
import com.nnlightctl.vo.GISView;

import java.util.List;

public interface GISServer {
    int addOrUpdateGIS(GISRequest request);
    int deleteGIS(GISConditionRequest request);

    Tuple.TwoTuple<List<GISView>, Integer> listGIS(GISConditionRequest request);
}
