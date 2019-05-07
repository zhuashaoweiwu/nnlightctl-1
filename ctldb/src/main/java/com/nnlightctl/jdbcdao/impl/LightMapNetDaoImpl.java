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
    public synchronized int mapLightingNet(Lighting lighting) {
        List<Object> params = new ArrayList<>(1);

        log.info("------------------------UUID[" + lighting.getUid() + "]判断开始--------------------------");
        //判断是否存在UUID对应的灯具信息
        List<Lighting> lightingList = lightDao.getLightingByUUID(lighting.getUid());

        if (lightingList.size() > 0) {    //存在，则更新realtimeUid
            log.info("-------------------------------从缓存或者数据库是查询1条以上该UUID的灯具记录--------------------------------");

            StringBuilder updateSql = new StringBuilder();
            updateSql.append("update nnlightctl_lighting set gmt_updated = ?, realtime_uid = ?, lighting_imei = ?, fault_tag = ? where id = ?");
            params.clear();
            params.add(new Date());
            params.add(lighting.getRealtimeUid());
            params.add(lighting.getLightingImei());
//            params.add(lighting.getLongitude());
//            params.add(lighting.getLatitude());
            params.add(lighting.getFaultTag());
            params.add(lightingList.get(0).getId());

            return this.jdbcTemplate.update(updateSql.toString(), params.toArray());
        } else {    //不存在，则新建一条UUID确定的灯具记录
            log.info("-------------------------------从缓存或者数据库中没有查询到该UUID的灯具记录--------------------------------");

            StringBuilder createSql = new StringBuilder();
            createSql.append("insert into nnlightctl_lighting(gmt_created, gmt_updated, uid, realtime_uid, lighting_imei, longitude, latitude, fault_tag) values(?, ?, ?, ?, ?, ?, ?, ?)");
            params.clear();
            params.add(new Date());
            params.add(new Date());
            params.add(lighting.getUid());
            params.add(lighting.getRealtimeUid());
            params.add(lighting.getLightingImei());
            params.add(lighting.getLongitude());
            params.add(lighting.getLatitude());
            params.add(lighting.getFaultTag());

            return this.jdbcTemplate.update(createSql.toString(), params.toArray());
        }
    }
}
