package com.nnlightctl.jdbcdao.impl;

import com.nnlightctl.jdbcdao.SceneMapSwitchTaskDao;
import com.nnlightctl.jdbcmapper.SceneMapSwitchTaskBatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class SceneMapSwitchTaskDaoImpl implements SceneMapSwitchTaskDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int deleteSceneMap(Long sceneId) {
        StringBuilder sql = new StringBuilder();

        sql.append("delete from nnlightctl_scene_switch_task_map where nnlightctl_scene_id = ?");

        return jdbcTemplate.update(sql.toString(), new Object[] {sceneId});
    }

    @Override
    public int addSceneSwitchTaskMap(Long scendId, Long switchTaskId) {
        StringBuilder sql = new StringBuilder();

        sql.append("insert into nnlightctl_scene_switch_task_map(gmt_created, gmt_updated, nnlightctl_scene_id, nnlightctl_switch_task_id) " +
                "values(?, ?, ?, ?)");

        return jdbcTemplate.update(sql.toString(), new Object[] {new Date(), new Date(), scendId, switchTaskId});
    }

    @Override
    public int batchAddSceneSwitchTaskMap(Long sceneId, List<Long> switchTaskIds) {
        StringBuilder sql = new StringBuilder();

        sql.append("insert into nnlightctl_scene_switch_task_map(gmt_created, gmt_updated, nnlightctl_scene_id, nnlightctl_switch_task_id) " +
                "values(?, ?, ?, ?)");

        return jdbcTemplate.batchUpdate(sql.toString(), new SceneMapSwitchTaskBatch(sceneId, switchTaskIds)).length;
    }

    @Override
    public List<Long> getSwitchTaskIds(Long sceneId) {
        StringBuilder sql = new StringBuilder();

        sql.append("select nnlightctl_switch_task_id from nnlightctl_scene_switch_task_map where nnlightctl_scene_id = ?");

        return jdbcTemplate.queryForList(sql.toString(), new Object[] {sceneId}, Long.class);
    }
}
