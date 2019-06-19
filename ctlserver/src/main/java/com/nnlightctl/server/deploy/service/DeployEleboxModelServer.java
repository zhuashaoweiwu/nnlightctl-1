package com.nnlightctl.server.deploy.service;

import com.nnlight.common.Tuple;
import com.nnlightctl.request.deployRequest.DeployEleboxModelRequest;
import com.nnlightctl.request.deployRequest.DeployEleboxRequest;
import com.nnlightctl.vo.DeployEleboxView;

import java.util.List;

public interface DeployEleboxModelServer {

    int insertEleboxModel(DeployEleboxModelRequest deployEleboxModelRequest);

    int updateEleboxModel(DeployEleboxModelRequest deployEleboxModelRequest);

    Tuple.TwoTuple<List<DeployEleboxView>,Integer> deployEleboxList(DeployEleboxRequest request);

}
