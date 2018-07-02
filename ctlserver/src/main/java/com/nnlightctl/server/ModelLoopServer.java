package com.nnlightctl.server;

import com.nnlightctl.po.EleboxModelLoop;
import com.nnlightctl.request.ModelLoopConditionRequest;
import com.nnlightctl.request.ModelLoopRequest;
import java.util.List;
public interface ModelLoopServer {
    int addOrUpdateModelLoop(ModelLoopRequest request);
    int deleteModelLoop(ModelLoopConditionRequest request);
    List<EleboxModelLoop> listEleboxLoop(Long EleboxId);
}
