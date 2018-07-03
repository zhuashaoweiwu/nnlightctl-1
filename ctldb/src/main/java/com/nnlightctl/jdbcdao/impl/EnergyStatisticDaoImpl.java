package com.nnlightctl.jdbcdao.impl;

import com.nnlightctl.jdbcdao.EnergyStatisticDao;
import com.nnlightctl.po.EleboxVolEleRecord;
import com.nnlightctl.request.EleboxPowerRequest;
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
public class EnergyStatisticDaoImpl implements EnergyStatisticDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<EleboxVolEleRecord> listEleboxPower(EleboxPowerRequest eleboxPowerRequest){
        //List<EleboxVolEleRecord> eleboxVolEleRecordList = null;
        StringBuilder sql = new StringBuilder();
        List<Object> param = new ArrayList<>(3);
        sql.append("SELECT id ,gmt_created ,gmt_updated ,uid ,realtime_date ,voltage ,electricity ,voltage*electricity as elebox_power from nnlightctl_elebox_vol_ele_record where 1=1 ");

        if (eleboxPowerRequest.getEleboxId() != null) {
            sql.append("and uid = ? ");
            param.add(eleboxPowerRequest.getEleboxId());
        }
        if(eleboxPowerRequest.getStartDate() != null){
            sql.append("and realtime_date >= ? ");
            param.add(eleboxPowerRequest.getStartDate());
        }
        if(eleboxPowerRequest.getEndDate() !=null){
            sql.append("and realtime_date <= ? ");
            param.add(eleboxPowerRequest.getEndDate());
        }

        List<EleboxVolEleRecord> eleboxVolEleRecordList = jdbcTemplate.query(sql.toString(), param.toArray(), new RowMapper<EleboxVolEleRecord>() {
            @Override
            public EleboxVolEleRecord mapRow(ResultSet resultSet, int i) throws SQLException {
                EleboxVolEleRecord eleboxVolEleRecord = new EleboxVolEleRecord();
                eleboxVolEleRecord.setId(resultSet.getLong("id"));
                eleboxVolEleRecord.setEleboxPower(resultSet.getBigDecimal("elebox_power"));
                eleboxVolEleRecord.setElectricity(resultSet.getBigDecimal("electricity"));
                eleboxVolEleRecord.setGmtCreated(resultSet.getDate("gmt_created"));
                eleboxVolEleRecord.setGmtUpdated(resultSet.getDate("gmt_updated"));
                eleboxVolEleRecord.setRealtimeDate(resultSet.getDate("realtime_date"));
                eleboxVolEleRecord.setUid(resultSet.getString("uid"));
                eleboxVolEleRecord.setVoltage(resultSet.getBigDecimal("voltage"));
                return eleboxVolEleRecord;
            }
        });

        return eleboxVolEleRecordList;
    }
}
