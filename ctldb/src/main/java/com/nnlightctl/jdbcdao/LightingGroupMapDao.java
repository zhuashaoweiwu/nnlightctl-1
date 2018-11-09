package com.nnlightctl.jdbcdao;

import java.util.List;

public interface LightingGroupMapDao {
    int addLightingGroupMap(Long lightingGroupId, Long lightingId);
    int batchAddLightingGroupMap(Long lightingGroupId, List<Long> lightIds);
    List<Long> getLightingIdsByGroupId(Long lightingGroupId);
    int batchDeleteLightingGroupMap(Long lightingGroupId);
}
