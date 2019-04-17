package com.nnlightctl.server;

import com.nnlightctl.po.EleboxModel;
import com.nnlightctl.request.EleboxModelConditionRequest;
import com.nnlightctl.request.EleboxModelRequest;

public interface EleboxModelServer {
    int addEleboxModel(EleboxModelRequest request);
    int updateEleboxModel(EleboxModelRequest request);
    int deleteEleboxModel(EleboxModelConditionRequest request);
    String getEleboxRealtimeUUIDByModelUUID(String modelUUID);
    String getEleboxRealtimeUUIDByModelId(Long modelId);
    String getEleboxRealtimeUUIDByLoopId(Long loopId);
    EleboxModel getEleboxModelById(Long id);
}
