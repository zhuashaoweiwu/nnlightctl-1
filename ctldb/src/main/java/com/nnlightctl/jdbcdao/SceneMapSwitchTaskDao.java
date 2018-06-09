package com.nnlightctl.jdbcdao;

import java.util.List;

public interface SceneMapSwitchTaskDao {
    int deleteSceneMap(Long sceneId);
    int addSceneSwitchTaskMap(Long scendId, Long switchTaskId);
    int batchAddSceneSwitchTaskMap(Long sceneId, List<Long> switchTaskIds);
    List<Long> getSwitchTaskIds(Long sceneId);
}
