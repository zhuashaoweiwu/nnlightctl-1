package com.nnlightctl.server;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.CentralizeController;
import com.nnlightctl.request.CentralizeControllerConditionRequest;
import com.nnlightctl.request.CentralizeControllerRquester;
import com.nnlightctl.request.deployRequest.DeployCentralizeControllerRequest;
import com.nnlightctl.vo.CentralizeControllerView;

import java.util.List;

public interface CentralizeControllerServer {


    int addOrUpdateCentralizeController(CentralizeControllerRquester request);

    int deleteCentralizeController(CentralizeControllerConditionRequest request);

    CentralizeController selectByPrimaryKey(CentralizeControllerConditionRequest request);

    Tuple.TwoTuple<List<CentralizeControllerView>,Integer> listCentralizeController(CentralizeControllerConditionRequest request);

    Boolean deployCentralizeController(DeployCentralizeControllerRequest request);





}
