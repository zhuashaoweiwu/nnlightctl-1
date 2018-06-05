package com.nnlightctl.jdbcdao.impl;

import com.nnlightctl.jdbcdao.LightingGroupMapGroupDao;
import com.nnlightctl.jdbcmapper.LightingGroupMapBatch;
import com.nnlightctl.jdbcmapper.LightingGroupMapGroupBatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LightingGroupMapGroupDaoImpl implements LightingGroupMapGroupDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int addLightingGroupMapGroupMap(Long parentGroupId, Long subGroupId) {
        StringBuilder sql = new StringBuilder();

        sql.append("INSERT INTO nnlightctl_lighting_group_group_map(gmt_created, gmt_updated, nnlightctl_lighting_group_parent_id, nnlightctl_lighting_group_sub_id) " +
                "values (?, ?, ?, ?)");


        return jdbcTemplate.update(sql.toString(), new Object[] {new Date(), new Date(), parentGroupId, subGroupId});
    }

    @Override
    public int batchAddLightingGroupMapGroupMap(Long parentGroupId, List<Long> subGroupIds) {
        StringBuilder sql = new StringBuilder();

        sql.append("INSERT INTO nnlightctl_lighting_group_group_map(gmt_created, gmt_updated, nnlightctl_lighting_group_parent_id, nnlightctl_lighting_group_sub_id) " +
                "values (?, ?, ?, ?)");

        int[] result = jdbcTemplate.batchUpdate(sql.toString(), new LightingGroupMapGroupBatch(parentGroupId, subGroupIds));

        return result.length;
    }

    @Override
    public List<Long> getLightGroupIdsByGroupId(Long parentGroupId) {
        StringBuilder sql = new StringBuilder();

        sql.append("select nnlightctl_lighting_group_sub_id from nnlightctl_lighting_group_group_map where nnlightctl_lighting_group_parent_id = ?");

        return jdbcTemplate.queryForList(sql.toString(), new Object[] {parentGroupId}, Long.class);
    }
}
