package com.nnlightctl.server.deploy.service;

import com.nnlightctl.request.deployRequest.DeployEleboxModelRequest;

public interface DeployEleboxModelServer {

    int insertEleboxModel(DeployEleboxModelRequest deployEleboxModelRequest);

    int updateEleboxModel(DeployEleboxModelRequest deployEleboxModelRequest);

}
