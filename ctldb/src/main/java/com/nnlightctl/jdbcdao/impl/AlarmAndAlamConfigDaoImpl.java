package com.nnlightctl.jdbcdao.impl;

import com.nnlightctl.vo.AlarmAndAlarmConfigView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.nnlightctl.jdbcdao.AlarmAndAlarmConfigDao;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AlarmAndAlamConfigDaoImpl implements AlarmAndAlarmConfigDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<AlarmAndAlarmConfigView> getAlarm(Long id) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Object> param = new ArrayList<>(1);
        stringBuilder.append("SELECT a.alarm_count,a.alarm_level,a.alarm_source,a.alarm_time,a.code_number,a.ctype,a.gmt_created,a.gmt_updated,a.id,a.msg,a.nnlightctl_alarm_config_id,a.remove_alarm_time,a.state , ");
        stringBuilder.append(" b.is_notice_map,b.is_notice_sms ");
        stringBuilder.append("from nnlightctl_alarm a LEFT JOIN nnlightctl_alarm_config b ON a.nnlightctl_alarm_config_id= b.id ");

        if (id != null) {
            stringBuilder.append("where a.id = ?");
            param.add(id);
        }
        List<AlarmAndAlarmConfigView> lightingViewList = jdbcTemplate.query(stringBuilder.toString(), param.toArray(), new RowMapper<AlarmAndAlarmConfigView>() {
            @Override
            public AlarmAndAlarmConfigView mapRow(ResultSet resultSet, int i) throws SQLException {
                AlarmAndAlarmConfigView alarmAndAlarmConfigView = new AlarmAndAlarmConfigView();
                alarmAndAlarmConfigView.setId(resultSet.getLong("id"));
                alarmAndAlarmConfigView.setAlarmCount(resultSet.getLong("alarm_count"));
                alarmAndAlarmConfigView.setAlarmLevel(resultSet.getByte("alarm_level"));
                alarmAndAlarmConfigView.setAlarmSource(resultSet.getString("alarm_source"));
                alarmAndAlarmConfigView.setAlarmTime(resultSet.getDate("alarm_time"));
                alarmAndAlarmConfigView.setCodeNumber(resultSet.getString("code_number"));
                alarmAndAlarmConfigView.setCtype(resultSet.getByte("ctype"));
                alarmAndAlarmConfigView.setGmtCreated(resultSet.getDate("gmt_created"));
                alarmAndAlarmConfigView.setGmtUpdated(resultSet.getDate("gmt_updated"));
                alarmAndAlarmConfigView.setMsg(resultSet.getString("msg"));
                alarmAndAlarmConfigView.setNnlightctlAlarmConfigId(resultSet.getLong("nnlightctl_alarm_config_id"));
                alarmAndAlarmConfigView.setRemoveAlarmTime(resultSet.getDate("remove_alarm_time"));
                alarmAndAlarmConfigView.setState(resultSet.getByte("state"));
                alarmAndAlarmConfigView.setIsNoticeMap(resultSet.getByte("is_notice_map"));
                alarmAndAlarmConfigView.setIsNoticeSms(resultSet.getByte("is_notice_sms"));
               return alarmAndAlarmConfigView;
            }
        });
        return lightingViewList;
    }

}
