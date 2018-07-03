package com.nnlightctl.jdbcdao.impl;

import com.nnlightctl.jdbcdao.EleboxDao;
import com.nnlightctl.request.BatchSetEleboxAreaRequest;
import com.nnlightctl.request.BatchSetLightingAreaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;;import java.util.HashMap;
import java.util.Map;

@Repository
public class EleboxDaoImpl implements EleboxDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public int batchSetEleboxArea(BatchSetEleboxAreaRequest batchSetEleboxAreaRequest){
        StringBuilder sql = new StringBuilder();

        Map<String, Object> params = new HashMap<>(1);
        params.put("eleboxIds", batchSetEleboxAreaRequest.getEleboxIds());

        sql.append("update nnlightctl_elebox set nnlightctl_region_id = "+batchSetEleboxAreaRequest.getBeAreaId()+" where " +
                "id in (:eleboxIds)");

        return namedParameterJdbcTemplate.update(sql.toString(), params);

    }

    public int batchSetLightingArea(BatchSetLightingAreaRequest batchSetLightingAreaRequest){
        StringBuilder sql = new StringBuilder();

        Map<String, Object> params = new HashMap<>(1);
        params.put("lightIds", batchSetLightingAreaRequest.getLightIds());

        sql.append("update nnlightctl_lighting set nnlightctl_region_id = "+batchSetLightingAreaRequest.getBeAreaId()+" where " +
                "id in (:lightIds)");

        return namedParameterJdbcTemplate.update(sql.toString(), params);
    }
}
