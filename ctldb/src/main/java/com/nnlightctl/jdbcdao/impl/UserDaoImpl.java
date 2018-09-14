package com.nnlightctl.jdbcdao.impl;

import com.nnlightctl.jdbcdao.UserDao;
import com.nnlightctl.po.UserOperationLog;
import com.nnlightctl.vo.AlarmAndAlarmConfigView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<UserOperationLog> listUserOpLog(Long id){
        StringBuilder sql = new StringBuilder();
        List<Object> param = new ArrayList<>(1);
        sql.append("SELECT a.id ,a.gmt_created ,a.gmt_updated ,a.nnlightctl_user_id ,a.operation_type ,a.operation_time ,a.operation_desc from nnlightctl_user_operation_log a ");
        if(id != null){
            sql.append("where a.nnlightctl_user_id = ?");
            param.add(id);
        }
        List<UserOperationLog> userOperationLog = jdbcTemplate.query(sql.toString(), param.toArray(), new RowMapper<UserOperationLog>() {
            @Override
            public UserOperationLog mapRow(ResultSet resultSet, int i) throws SQLException {
                UserOperationLog userOperationLog = new UserOperationLog();
                userOperationLog.setGmtCreated(resultSet.getDate("gmt_created"));
                userOperationLog.setGmtUpdated(resultSet.getDate("gmt_updated"));
                userOperationLog.setId(resultSet.getLong("id"));
                userOperationLog.setNnlightctlUserId(resultSet.getLong("nnlightctl_user_id"));
                userOperationLog.setOperationDesc(resultSet.getString("operation_desc"));
                userOperationLog.setOperationTime(resultSet.getDate("operation_time"));
                userOperationLog.setOperationType(resultSet.getByte("operation_type"));
                return userOperationLog;
            }
        });
        return userOperationLog;

    }

}
