package com.nnlightctl.jdbcdao.impl;

import com.nnlightctl.jdbcdao.LoginDao;
import com.nnlightctl.po.Righter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LoginDaoImpl implements LoginDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Righter> getRightersByLoginName(String loginName) {
        StringBuilder sql = new StringBuilder();

        sql.append("select r.id, r.righter_name, r.url, r.righter_level, r.parent_righter_id from nnlightctl_user u, nnlightctl_user_righter_map m, nnlightctl_righter r ");
        sql.append("where u.login_name = ? and u.id = m.nnlightctl_user_id and m.nnlightctl_righter_id = r.id");

        List<Object> params = new ArrayList<>(1);
        params.add(loginName);

        return jdbcTemplate.query(sql.toString(), params.toArray(), new RowMapper<Righter>() {
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
        });
    }
}
