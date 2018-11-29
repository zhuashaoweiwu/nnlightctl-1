package com.nnlightctl.server;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.Lighting;
import com.nnlightctl.po.Scene;
import com.nnlightctl.po.SceneShotcut;
import com.nnlightctl.po.SwitchTask;
import com.nnlightctl.request.*;
import com.nnlightctl.vo.SceneView;

import java.util.List;

public interface SceneServer {
    int addOrUpdateScene(SceneRequest request);
    int getCountSceneShotcutByShotcutName(String shotcutName);
    int getCountSceneShotcutBySceneId(Long sceneId);
    Tuple.TwoTuple<List<Scene>, Integer> listScene(SceneRequest request);

    SceneView getScene(Long id);

    int deleteScene(SceneConditionRequest request);

    int addOrUpdateSceneShotcut(SceneShotcutRequest request);

    int deleteSceneShotcut(SceneShotcutConditionRequest request);

    int getInvokeSceneShotcut(String shotcutName);

    List<SceneShotcut> listSceneShotcut();

    List<Lighting> listLightingsOfScene(Long sceneId);

    List<SwitchTask> listSwitchTaskOfScene(Long scendId);
}
