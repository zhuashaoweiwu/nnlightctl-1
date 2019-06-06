package com.nnlightctl.server;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.LampController;
import com.nnlightctl.request.LampControllerConditionRequest;
import com.nnlightctl.request.LampControllerRequest;
import com.nnlightctl.vo.LampControllerView;

import java.util.List;


public interface LampControllerServer {

    int addOrUpdateLampController(LampControllerRequest request);

    int deleteLampController(LampControllerConditionRequest request);

    Tuple.TwoTuple<List<LampControllerView>,Integer> listLampController();

    LampController LampControllerById();


}
