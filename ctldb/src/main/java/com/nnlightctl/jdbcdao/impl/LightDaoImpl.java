package com.nnlightctl.jdbcdao.impl;

import com.nnlight.common.Tuple;
import com.nnlightctl.jdbcdao.LightDao;
import com.nnlightctl.po.Lighting;
import com.nnlightctl.request.LightConditionRequest;
import com.nnlightctl.vo.LightingView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class LightDaoImpl implements LightDao {

    private static final Logger log = LoggerFactory.getLogger(LightDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public int clearLightBeEleboxBeLoop(List<Long> lightIds) {
        StringBuilder sql = new StringBuilder();

        Map<String, Object> params = new HashMap<>(1);
        params.put("lightIds", lightIds);

        sql.append("update nnlightctl_lighting set nnlightctl_elebox_model_loop_id = NULL, nnlightctl_elebox_id = NULL where " +
                "id in (:lightIds)");

        return namedParameterJdbcTemplate.update(sql.toString(), params);
    }

    @Override
    public Tuple.TwoTuple<List<LightingView>, Integer> listLightingView(LightConditionRequest request) {
        StringBuilder sql = new StringBuilder();
        StringBuilder countSql = new StringBuilder();

        List<Object> params = new ArrayList<>(1);

        sql.append("select l.id, l.gmt_created, l.gmt_updated, l.uid, l.manufacture, l.use_date, l.lamppost, l.lamphead, l.property_serial_number, l.decay, l.max_use_time, l.mem, l.loop_priority, l.fault_tag, g.longitude, g.latitude ");
        countSql.append("select count(*) ");

        sql.append("from nnlightctl_lighting l left join nnlightctl_lighting_gis g ");
        countSql.append("from nnlightctl_lighting l left join nnlightctl_lighting_gis g ");

        if (request.getProjectId() != null) {
            sql.append("on l.nnlightctl_lighting_gis_id = g.id where l.nnlightctl_project_id = ? ");
            countSql.append("on l.nnlightctl_lighting_gis_id = g.id where l.nnlightctl_project_id = ? ");

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
                lightingView.setLoopPriority(resultSet.getByte("loop_priority"));
                lightingView.setFaultTag(resultSet.getByte("fault_tag"));

                return lightingView;
            }
        });

        Tuple.TwoTuple<List<LightingView>, Integer> tuple = new Tuple.TwoTuple<>();
        tuple.setFirst(lightingViewList);
        tuple.setSecond(total);

        return tuple;
    }

    @Override
    public Tuple.TwoTuple<List<LightingView>, Integer> listLoopLightingView(LightConditionRequest request) {
        StringBuilder sql = new StringBuilder();
        StringBuilder countSql = new StringBuilder();

        List<Object> params = new ArrayList<>(1);

        sql.append("select l.id, l.gmt_created, l.gmt_updated, l.uid, l.manufacture, l.use_date, l.lamppost, l.lamphead, l.property_serial_number, l.decay, l.max_use_time, l.mem, l.loop_priority, l.fault_tag, g.longitude, g.latitude ");
        countSql.append("select count(*) ");

        sql.append("from nnlightctl_lighting l left join nnlightctl_lighting_gis g on l.nnlightctl_lighting_gis_id = g.id where 1=1 ");
        countSql.append("from nnlightctl_lighting l left join nnlightctl_lighting_gis g on l.nnlightctl_lighting_gis_id = g.id where 1=1 ");

        if (request.getProjectId() != null) {
            sql.append(" and l.nnlightctl_project_id = ? ");
            countSql.append(" and l.nnlightctl_project_id = ? ");

            params.add(request.getProjectId());
        } else {
            /*sql.append("on l.nnlightctl_lighting_gis_id = g.id ");
            countSql.append("on l.nnlightctl_lighting_gis_id = g.id ");*/
        }
        if (request.getModelLoopId() != null) {
            sql.append("and l.nnlightctl_elebox_model_loop_id = ? ");
            countSql.append("and l.nnlightctl_elebox_model_loop_id = ? ");

            params.add(request.getModelLoopId());
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
                lightingView.setLoopPriority(resultSet.getByte("loop_priority"));
                lightingView.setFaultTag(resultSet.getByte("fault_tag"));

                return lightingView;
            }
        });

        Tuple.TwoTuple<List<LightingView>, Integer> tuple = new Tuple.TwoTuple<>();
        tuple.setFirst(lightingViewList);
        tuple.setSecond(total);

        return tuple;
    }

    @Cacheable("commandCache")
    @Override
    public List<Lighting> getLightingByUUID(String uuid) {
        log.info("通过uuid从数据库中查询灯具");
        StringBuilder sql = new StringBuilder();
        List<Object> params = new ArrayList<>(1);
        sql.append("select id, realtime_uid from nnlightctl_lighting where uid = ?");
        params.add(uuid);
        List<Lighting> lightingList = this.jdbcTemplate.query(sql.toString(), params.toArray(), new RowMapper<Lighting>() {
            @Override
            public Lighting mapRow(ResultSet resultSet, int i) throws SQLException {
                Lighting lighting1 = new Lighting();

                lighting1.setId(resultSet.getLong("id"));
                lighting1.setRealtimeUid(resultSet.getString("realtime_uid"));

                return lighting1;
            }
        });

        return lightingList;
    }
}
