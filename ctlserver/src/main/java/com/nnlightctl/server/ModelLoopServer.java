package com.nnlightctl.server;

import com.nnlightctl.request.ModelLoopConditionRequest;
import com.nnlightctl.request.ModelLoopRequest;

public interface ModelLoopServer {
    int addOrUpdateModelLoop(ModelLoopRequest request);
    int deleteModelLoop(ModelLoopConditionRequest request);
}
