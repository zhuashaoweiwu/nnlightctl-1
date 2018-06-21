package com.nnlightctl.jdbcdao.impl;

import com.nnlight.common.Tuple;
import com.nnlightctl.jdbcdao.LightDao;
import com.nnlightctl.request.LightConditionRequest;
import com.nnlightctl.vo.LightingView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LightDaoImpl implements LightDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int clearLightBeEleboxBeLoop(Long eleboxId, Long modelLoopId) {
        StringBuilder sql = new StringBuilder();

        sql.append("update nnlightctl_lighting set nnlightctl_elebox_model_loop_id = NULL, nnlightctl_elebox_id = NULL where " +
                "nnlightctl_elebox_model_loop_id = ? and nnlightctl_elebox_id = ?");

        return jdbcTemplate.update(sql.toString(), new Object[] {modelLoopId, eleboxId});
    }

    @Override
    public Tuple.TwoTuple<List<LightingView>, Integer> listLightingView(LightConditionRequest request) {
        StringBuilder sql = new StringBuilder();
        StringBuilder countSql = new StringBuilder();

        List<Object> params = new ArrayList<>(1);

        sql.append("select l.id, l.gmt_created, l.gmt_updated, l.uid, l.manufacture, l.use_date, l.lamppost, l.lamphead, l.property_serial_number, l.decay, l.max_use_time, l.mem, g.longitude, g.latitude ");
        countSql.append("select count(*) ");

        sql.append("from nnlightctl_lighting l left join nnlightctl_lighting_gis g ");
        countSql.append("from nnlightctl_lighting l left join nnlightctl_lighting_gis g ");

        if (request.getProjectId() != null) {
            sql.append("on l.nnlightctl_lighting_gis_id = g.id and l.nnlightctl_project_id = ?");
            countSql.append("on l.nnlightctl_lighting_gis_id = g.id and l.nnlightctl_project_id = ?");

            params.add(request.getProjectId());
        } else {
            sql.append("on l.nnlightctl_lighting_gis_id = g.id ");
            countSql.append("on l.nnlightctl_lighting_gis_id = g.id ");
        }

        int total = jdbcTemplate.queryForObject(countSql.toString(), params.toArray(), Integer.class);

        sql.append("order by id DESC ");

        if (request.getPageSize() > 0 && request.getPageNumber() > 0) {
            sql.append("limit ?, ?");
            params.add((request.getPageNumber() - 1) * request.getPageSize());
            params.add(request.getPageSize());
        }

        List<LightingView> lightingViewList = jdbcTemplate.query(sql.toString(), params.toArray(), new RowMapper<LightingView>() {
            @Override
            public LightingView mapRow(ResultSet resultSet, int i) throws SQLException {
                LightingView lightingView = new LightingView();

                lightingView.setId(resultSet.getLong("id"));
                lightingView.setGmtCreated(resultSet.getDate("gmt_created"));
                lightingView.setGmtUpdated(resultSet.getDate("gmt_updated"));
                lightingView.setUid(resultSet.getString("uid"));
                lightingView.setManufacture(resultSet.getDate("manufacture"));
                lightingView.setUseDate(resultSet.getDate("use_date"));
                lightingView.setLamppost(resultSet.getString("lamppost"));
                lightingView.setLamphead(resultSet.getString("lamphead"));
                lightingView.setPropertySerialNumber(resultSet.getString("property_serial_number"));
                lightingView.setDecay(resultSet.getBigDecimal("decay"));
                lightingView.setMaxUseTime(resultSet.getLong("max_use_time"));
                lightingView.setMem(resultSet.getString("mem"));
                lightingView.setLongitude(resultSet.getString("longitude"));
                lightingView.setLatitude(resultSet.getString("latitude"));

                return lightingView;
            }
        });

        Tuple.TwoTuple<List<LightingView>, Integer> tuple = new Tuple.TwoTuple<>();
        tuple.setFirst(lightingViewList);
        tuple.setSecond(total);

        return tuple;
    }
}
