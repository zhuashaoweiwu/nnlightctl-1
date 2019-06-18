package com.nnlightctl.server.deploy.service;

import com.nnlightctl.request.deployRequest.DeployEleboxRequest;
import com.nnlightctl.request.deployRequest.DeployExleboxArrangeRequest;

public interface DeployEleboxServer {

    int insertElebox(DeployEleboxRequest request);

    int updateElebox(DeployEleboxRequest request);

    Boolean deployExleboxArrange(DeployExleboxArrangeRequest request) throws  RuntimeException;


}
