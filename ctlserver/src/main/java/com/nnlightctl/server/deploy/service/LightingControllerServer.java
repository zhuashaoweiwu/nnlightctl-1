package com.nnlightctl.server.deploy.service;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.Lighting;
import com.nnlightctl.request.LightRequest;
import com.nnlightctl.request.deployRequest.DeployLighting;
import com.nnlightctl.request.deployRequest.LightingConditionRequest;


import java.util.List;

public interface LightingControllerServer {

    int addOrUpdateLightingController(LightRequest Request);

    int deteleLightingController(LightingConditionRequest request);

    Tuple.TwoTuple<List<Lighting>,Integer> listLightingController(LightingConditionRequest request);

    Lighting selectLightingController(LightingConditionRequest request);

    DeployLighting selectLightDeploy();
}
