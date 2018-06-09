package com.nnlightctl.jdbcdao;

import java.util.List;

public interface SceneMapLightingGroupDao {
    int deleteSceneMap(Long sceneId);
    int addSceneLightingGroupMap(Long scendId, Long lightingGroupId);
    int batchAddSceneLightingGroupMap(Long sceneId, List<Long>lightingGroupIds);
    List<Long> getLightingGroupIds(Long sceneId);
}
