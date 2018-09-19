package com.nnlightctl.jdbcdao.impl;

import com.nnlightctl.jdbcdao.LightDao;
import com.nnlightctl.jdbcdao.LightMapNetDao;
import com.nnlightctl.po.Lighting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class LightMapNetDaoImpl implements LightMapNetDao {

    private static final Logger log = LoggerFactory.getLogger(LightMapNetDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private LightDao lightDao;

    @Override
    public int mapLightingNet(Lighting lighting) {
        List<Object> params = new ArrayList<>(1);

        //判断是否存在UUID对应的灯具信息
        List<Lighting> lightingList = lightDao.getLightingByUUID(lighting.getUid());

        if (lightingList.size() > 0) {    //存在，则更新realtimeUid
            //判断是否已经更新
            if (lighting.getRealtimeUid().equalsIgnoreCase(lightingList.get(0).getRealtimeUid())) { //已经更新过了
                return 1;
            }

            StringBuilder updateSql = new StringBuilder();
            updateSql.append("update nnlightctl_lighting set gmt_updated = ?, realtime_uid = ? where id = ?");
            params.clear();
            params.add(new Date());
            params.add(lighting.getRealtimeUid());
            params.add(lightingList.get(0).getId());

            return this.jdbcTemplate.update(updateSql.toString(), params.toArray());
        } else {    //不存在，则新建一条UUID确定的灯具记录
            StringBuilder createSql = new StringBuilder();
            createSql.append("insert into nnlightctl_lighting(gmt_created, gmt_updated, uid, realtime_uid) values(?, ?, ?, ?)");
            params.clear();
            params.add(new Date());
            params.add(new Date());
            params.add(lighting.getUid());
            params.add(lighting.getRealtimeUid());

            return this.jdbcTemplate.update(createSql.toString(), params.toArray());
        }
    }
}
