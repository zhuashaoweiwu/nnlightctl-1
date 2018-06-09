package com.nnlightctl.jdbcmapper;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class SceneMapSwitchTaskBatch implements BatchPreparedStatementSetter {
    private Long sceneId;
    private List<Long> switchTaskIds;

    public SceneMapSwitchTaskBatch(Long sceneId, List<Long> switchTaskIds) {
        this.sceneId = sceneId;
        this.switchTaskIds = switchTaskIds;
    }

    @Override
    public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
        preparedStatement.setDate(1, new Date(new java.util.Date().getTime()));
        preparedStatement.setDate(2, new Date(new java.util.Date().getTime()));
        preparedStatement.setLong(3, this.sceneId);
        preparedStatement.setLong(4, this.switchTaskIds.get(i));
    }

    @Override
    public int getBatchSize() {
        return this.switchTaskIds.size();
    }
}
