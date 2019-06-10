package com.nnlightctl.server;

import com.nnlight.common.Tuple;
import com.nnlightctl.parameter.LampControllerParameter;
import com.nnlightctl.po.LampController;
import com.nnlightctl.request.LampControllerConditionRequest;
import com.nnlightctl.request.LampControllerRequest;
import com.nnlightctl.request.LamppostConditionRequest;
import com.nnlightctl.vo.LampControllerView;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface LampControllerServer {

    int addOrUpdateLampController(LampControllerRequest request);

    int deleteLampController(LampControllerConditionRequest request);

    Tuple.TwoTuple<List<LampControllerView>,Integer> listLampController(LampControllerConditionRequest request);

    List<LampController>  SelectByParameter(LampControllerConditionRequest request);

    LampController selectByIdLampController(LampControllerConditionRequest request);


}
