package com.nnlightctl.server;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.Elebox;
import com.nnlightctl.po.EleboxModel;
import com.nnlightctl.po.EleboxModelLoop;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.request.EleboxAddModelRequest;
import com.nnlightctl.request.EleboxConditionRequest;
import com.nnlightctl.request.EleboxRequest;

import java.util.List;

public interface EleboxServer {
    int insertElebox(EleboxAddModelRequest request);
    int updateElebox(EleboxRequest request);
    int updateEleboxDevice(EleboxConditionRequest request);
    int updateModelLoopSplite(EleboxConditionRequest request);
    int deleteElebox(EleboxConditionRequest request);
    Tuple.TwoTuple<List<Elebox>, Integer> listElebox(BaseRequest request);
    Tuple.TwoTuple<List<EleboxModel>, Integer> listEleboxModel(EleboxConditionRequest request);
    Tuple.TwoTuple<List<EleboxModelLoop>, Integer> listModelLoop(Long modelId);
}
