package com.nnlightctl.jdbcdao.impl;

import com.nnlightctl.jdbcdao.LightingGroupMapDao;
import com.nnlightctl.jdbcmapper.LightingGroupMapBatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class LightingGroupMapDaoImpl implements LightingGroupMapDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int addLightingGroupMap(Long lightingGroupId, Long lightingId) {
        StringBuilder sql = new StringBuilder();

        sql.append("INSERT INTO nnlightctl_lighting_group_map(gmt_created, gmt_updated, nnlightctl_lighting_group_id, nnlightctl_lighting_id) " +
                "values (?, ?, ?, ?)");


        return jdbcTemplate.update(sql.toString(), new Object[] {new Date(), new Date(), lightingGroupId, lightingId});
    }

    @Override
    public int batchAddLightingGroupMap(Long lightingGroupId, List<Long> lightIds) {
        StringBuilder sql = new StringBuilder();

        sql.append("INSERT INTO nnlightctl_lighting_group_map(gmt_created, gmt_updated, nnlightctl_lighting_group_id, nnlightctl_lighting_id) " +
                "values (?, ?, ?, ?)");

        int[] result = jdbcTemplate.batchUpdate(sql.toString(), new LightingGroupMapBatch(lightingGroupId, lightIds));

        return result.length;
    }

    @Override
    public List<Long> getLightingIdsByGroupId(Long lightingGroupId) {
        StringBuilder sql = new StringBuilder();

        sql.append("select nnlightctl_lighting_id from nnlightctl_lighting_group_map where nnlightctl_lighting_group_id = ?");

        return jdbcTemplate.queryForList(sql.toString(), new Object[] {lightingGroupId}, Long.class);
    }
}
