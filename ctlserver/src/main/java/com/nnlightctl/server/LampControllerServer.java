package com.nnlightctl.server;

import com.nnlight.common.Tuple;
import com.nnlightctl.parameter.LampControllerParameter;
import com.nnlightctl.po.LampController;
import com.nnlightctl.po.Lamppost;
import com.nnlightctl.po.Lighting;
import com.nnlightctl.po.LightingExample;
import com.nnlightctl.request.LampControllerConditionRequest;
import com.nnlightctl.request.LampControllerRequest;
import com.nnlightctl.request.LamppostConditionRequest;
import com.nnlightctl.request.LightConditionRequest;
import com.nnlightctl.request.deployRequest.DeployLightingRequest;
import com.nnlightctl.vo.DeployLightingView;
import com.nnlightctl.vo.LampControllerView;
import com.nnlightctl.vo.LightingView;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface LampControllerServer {

    int addOrUpdateLampController(LampControllerRequest request);

    int deleteLampController(LampControllerConditionRequest request);

    Tuple.TwoTuple<List<LampControllerView>,Integer> listLampController(LampControllerConditionRequest request);

    List<LampController>  SelectByParameter(LampControllerConditionRequest request);

    LampController selectByIdLampController(LampControllerConditionRequest request);

    List<String> queryLightingByLoop(Long loopId);

    Tuple.TwoTuple<List<DeployLightingView>,Integer> selectByExampleDeployLighting(LampControllerConditionRequest example);

    int deployUpdateLighting(LampControllerRequest request);

    List<LampController> selectByLampModel(LampControllerRequest request);

    List<DeployLightingView> selectByIdDeployLighting(LampControllerRequest request);

    int deleteDeployLighting(LampControllerConditionRequest request);


    Boolean updateShowDeployLighting(DeployLightingRequest request);

    List<Map<String,Object>> queryLightingUnLoop();

    Tuple.TwoTuple<List<Map<String,Object>>, Integer>  queryLightingByProject(LightConditionRequest request);

    Lamppost lamppostByLampcontrollerId(LampControllerRequest request);




}
