package com.nnlightctl.jdbcmapper;

import com.nnlightctl.po.Righter;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RighterRowMapper implements RowMapper<Righter> {
    @Override
    public Righter mapRow(ResultSet resultSet, int i) throws SQLException {
        Righter righter = new Righter();

        righter.setRighterName(resultSet.getString("righter_name"));
        righter.setUrl(resultSet.getString("url"));
        righter.setRighterLevel(resultSet.getByte("righter_level"));
        righter.setParentRighterId(resultSet.getLong("parent_righter_id"));
        righter.setId(resultSet.getLong("id"));

        return righter;
    }
}
