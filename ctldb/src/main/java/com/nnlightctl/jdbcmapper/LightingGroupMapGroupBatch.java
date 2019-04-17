package com.nnlightctl.jdbcmapper;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class LightingGroupMapGroupBatch implements BatchPreparedStatementSetter {
    private Long parentLightingGroupId;
    private List<Long> subLightingGroupIds;

    public LightingGroupMapGroupBatch(Long parentLightingGroupId, List<Long> subLightingGroupIds) {
        this.parentLightingGroupId = parentLightingGroupId;
        this.subLightingGroupIds = subLightingGroupIds;
    }

    @Override
    public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
        preparedStatement.setDate(1, new Date(new java.util.Date().getTime()));
        preparedStatement.setDate(2, new Date(new java.util.Date().getTime()));
        preparedStatement.setLong(3, this.parentLightingGroupId);
        preparedStatement.setLong(4, this.subLightingGroupIds.get(i));
    }

    @Override
    public int getBatchSize() {
        return subLightingGroupIds.size();
    }
}
