package com.nnlightctl.jdbcdao.impl;

import com.nnlightctl.jdbcdao.LightDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LightDaoImpl implements LightDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int clearLightBeEleboxBeLoop(Long eleboxId, Long modelLoopId) {
        StringBuilder sql = new StringBuilder();

        sql.append("update nnlightctl_lighting set nnlightctl_elebox_model_loop_id = NULL, nnlightctl_elebox_id = NULL where " +
                "nnlightctl_elebox_model_loop_id = ? and nnlightctl_elebox_id = ?");

        return jdbcTemplate.update(sql.toString(), new Object[] {modelLoopId, eleboxId});
    }
}
