package com.nnlightctl.jdbcmapper;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserMapRightersBatch implements BatchPreparedStatementSetter {
    private Integer userId;  //-- 用户id

    private List<Integer> righterIds; // -- 菜单id集合

    public UserMapRightersBatch(Integer userId, List<Integer> righterIds) {
        this.userId = userId;
        this.righterIds = righterIds;
    }

    @Override
    public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
        preparedStatement.setDate(1, new Date(new java.util.Date().getTime()));
        preparedStatement.setDate(2, new Date(new java.util.Date().getTime()));
        preparedStatement.setInt(3,this.userId);
        preparedStatement.setInt(4, this.righterIds.get(i));
    }
    @Override
    public int getBatchSize() {
        return this.righterIds.size();
    }
}
