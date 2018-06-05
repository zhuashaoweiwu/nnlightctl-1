package com.nnlightctl.jdbcmapper;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class LightingGroupMapBatch implements BatchPreparedStatementSetter {
    private final Long lightGroupId;
    private final List<Long> lightingIds;

    public LightingGroupMapBatch(Long lightGroupId, List<Long> lightingIds) {
        this.lightGroupId = lightGroupId;
        this.lightingIds = lightingIds;
    }

    @Override
    public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
        preparedStatement.setDate(1, new Date(new java.util.Date().getTime()));
        preparedStatement.setDate(2, new Date(new java.util.Date().getTime()));
        preparedStatement.setLong(3, this.lightGroupId);
        preparedStatement.setLong(4, this.lightingIds.get(i));
    }

    @Override
    public int getBatchSize() {
        return this.lightingIds.size();
    }
}
