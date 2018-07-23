package com.nnlightctl.jdbcmapper;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class WorkflowerNodeMapBatch implements BatchPreparedStatementSetter {

    private List<Long> workFlowerNodeIds;

    private Long WorkFlowerId;

    public WorkflowerNodeMapBatch(Long WorkFlowerId, List<Long> workFlowerNodeIds) {
        this.WorkFlowerId = WorkFlowerId;
        this.workFlowerNodeIds = workFlowerNodeIds;
    }
    @Override
    public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
        preparedStatement.setDate(1, new Date(new java.util.Date().getTime()));
        preparedStatement.setDate(2, new Date(new java.util.Date().getTime()));
        preparedStatement.setLong(3, this.WorkFlowerId);
        preparedStatement.setLong(4, this.workFlowerNodeIds.get(i));
        preparedStatement.setLong(5,workFlowerNodeIds.get(i));
    }
    @Override
    public int getBatchSize() {
        return this.workFlowerNodeIds.size();
    }
}
