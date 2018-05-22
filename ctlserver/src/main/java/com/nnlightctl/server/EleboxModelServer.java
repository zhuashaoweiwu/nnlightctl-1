package com.nnlightctl.server;

import com.nnlightctl.request.EleboxModelConditionRequest;
import com.nnlightctl.request.EleboxModelRequest;

public interface EleboxModelServer {
    int addEleboxModel(EleboxModelRequest request);
    int updateEleboxModel(EleboxModelRequest request);
    int deleteEleboxModel(EleboxModelConditionRequest request);
}
