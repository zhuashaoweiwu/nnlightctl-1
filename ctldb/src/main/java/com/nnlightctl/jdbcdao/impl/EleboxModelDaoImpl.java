package com.nnlightctl.jdbcdao.impl;

import com.nnlightctl.jdbcdao.EleboxModelDao;
import com.nnlightctl.po.EleboxModel;
import com.nnlightctl.po.EleboxModelLoop;
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
public class EleboxModelDaoImpl  implements EleboxModelDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

   public  List<EleboxModel> listEleboxModel(Long EleboxId){
       StringBuilder stringBuilder = new StringBuilder();
       List<Object> param = new ArrayList<>(1);
       stringBuilder.append("SELECT id from nnlightctl_elebox_model ");
       if (EleboxId != null) {
           stringBuilder.append(" where nnlightctl_elebox_id = ? ");
           param.add(EleboxId);
       }
       List<EleboxModel> eleboxModelList = jdbcTemplate.query(stringBuilder.toString(), param.toArray(), new RowMapper<EleboxModel>() {
           @Override
           public EleboxModel mapRow(ResultSet resultSet, int i) throws SQLException {
               EleboxModel EleboxModel = new EleboxModel();
               EleboxModel.setId(resultSet.getLong("id"));
               return EleboxModel;
           }
       });
        return eleboxModelList;
    }

     public List<EleboxModelLoop> listEleboxModelLoop(Long EleboxModelLoopId){
        StringBuilder stringBuilder = new StringBuilder();
        List<Object> param = new ArrayList<>(1);
        stringBuilder.append("SELECT id,gmt_created,gmt_updated,voltage,electricity,light_count,state,loop_code,nnlightctl_elebox_model_id from nnlightctl_elebox_model_loop ");
        if (EleboxModelLoopId != null) {
            stringBuilder.append(" where nnlightctl_elebox_model_id = ? ");
            param.add(EleboxModelLoopId);
        }
        List<EleboxModelLoop> EleboxModelLoopList = jdbcTemplate.query(stringBuilder.toString(), param.toArray(), new RowMapper<EleboxModelLoop>() {
            @Override
            public EleboxModelLoop mapRow(ResultSet resultSet, int i) throws SQLException {
                EleboxModelLoop eleboxModelLoop = new EleboxModelLoop();
                eleboxModelLoop.setId(resultSet.getLong("id"));
                eleboxModelLoop.setElectricity(resultSet.getBigDecimal("electricity"));
                eleboxModelLoop.setGmtCreated(resultSet.getDate("gmt_created"));
                eleboxModelLoop.setGmtUpdated(resultSet.getDate("gmt_updated"));
                eleboxModelLoop.setLightCount(resultSet.getByte("light_count"));
                eleboxModelLoop.setLoopCode(resultSet.getString("loop_code"));
                eleboxModelLoop.setNnlightctlEleboxModelId(resultSet.getLong("nnlightctl_elebox_model_id"));
                eleboxModelLoop.setState(resultSet.getByte("state"));
                eleboxModelLoop.setVoltage(resultSet.getBigDecimal("voltage"));
                return eleboxModelLoop;
            }
        });
        return EleboxModelLoopList;
    }
}
