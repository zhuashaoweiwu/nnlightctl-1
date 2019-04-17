package com.nnlightctl.jdbcdao.impl;

import com.nnlightctl.jdbcdao.SceneMapLightingGroupDao;
import com.nnlightctl.jdbcmapper.SceneMapLightingGroupBatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class SceneMapLightingGroupDaoImpl implements SceneMapLightingGroupDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int deleteSceneMap(Long sceneId) {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from nnlightctl_scene_lightgroup_map where nnlightctl_scene_id = ?");
        return jdbcTemplate.update(sql.toString(), new Object[] {sceneId});
    }

    @Override
    public int addSceneLightingGroupMap(Long scendId, Long lightingGroupId) {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into nnlightctl_scene_lightgroup_map(gmt_created, gmt_updated, nnlightctl_scene_id, nnlightctl_lighting_group_id) " +
                "values(?, ?, ?, ?)");

        return jdbcTemplate.update(sql.toString(), new Object[] {new Date(), new Date(), scendId, lightingGroupId});
    }

    @Override
    public int batchAddSceneLightingGroupMap(Long sceneId, List<Long> lightingGroupIds) {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into nnlightctl_scene_lightgroup_map(gmt_created, gmt_updated, nnlightctl_scene_id, nnlightctl_lighting_group_id) " +
                "values(?, ?, ?, ?)");

        int[] result = jdbcTemplate.batchUpdate(sql.toString(), new SceneMapLightingGroupBatch(sceneId, lightingGroupIds));

        return result.length;
    }

    @Override
    public List<Long> getLightingGroupIds(Long sceneId) {
        StringBuilder sql = new StringBuilder();

        sql.append("select nnlightctl_lighting_group_id from nnlightctl_scene_lightgroup_map where nnlightctl_scene_id = ?");

        return jdbcTemplate.queryForList(sql.toString(), new Object[] {sceneId}, Long.class);
    }
}
