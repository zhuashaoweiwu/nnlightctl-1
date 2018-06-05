package com.nnlightctl.jdbcdao;

import java.util.List;

public interface LightingGroupMapGroupDao {
    int addLightingGroupMapGroupMap(Long parentGroupId, Long subGroupId);
    int batchAddLightingGroupMapGroupMap(Long parentGroupId, List<Long> subGroupIds);
    List<Long> getLightGroupIdsByGroupId(Long parentGroupId);
}
