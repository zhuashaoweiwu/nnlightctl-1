package com.nnlightctl.jdbcdao.impl;

import com.nnlight.common.TableNameUtil;
import com.nnlightctl.jdbcdao.LightSignalRecordDao;
import com.nnlightctl.po.LightSignalLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class LightSignalRecordDaoImpl implements LightSignalRecordDao {

    private static final String LIGHTING_SIGNAL_LOG_ROOTTABLENAME = "nnlightctl_light_signal_log";

    private static final Logger log = LoggerFactory.getLogger(LightSignalRecordDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private void createLightSignalLogTable(String tableName) {
        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE `" + tableName + "` (");
        sql.append("`id` bigint(20) NOT NULL AUTO_INCREMENT,");
        sql.append("`gmt_created` datetime DEFAULT NULL,");
        sql.append("`gmt_updated` datetime DEFAULT NULL,");
        sql.append("`uid` varchar(64) DEFAULT NULL,");
        sql.append("`signal_log_date` datetime DEFAULT NULL,");
        sql.append("`longitude` varchar(12) DEFAULT NULL,");
        sql.append("`latitude` varchar(12) DEFAULT NULL,");
        sql.append("`signal_intensity` decimal(10,3) DEFAULT NULL,");
        sql.append("`unit` varchar(12) DEFAULT NULL,");
        sql.append("`signal_level` tinyint(3) unsigned DEFAULT NULL,");
        sql.append("`online_state` tinyint(3) unsigned DEFAULT NULL,");
        sql.append("PRIMARY KEY (`id`)");
        sql.append(") ENGINE=InnoDB AUTO_INCREMENT=159029 DEFAULT CHARSET=utf8;");

        jdbcTemplate.update(sql.toString());
    }

    @Override
    public int addLightSignalRecord(LightSignalLog lightSignalLog) {
        String tableName = TableNameUtil.getTableNameByDate(LIGHTING_SIGNAL_LOG_ROOTTABLENAME, new Date());
        //判断该表是否存在
        try {
            if (!TableNameUtil.isTableExist(jdbcTemplate, tableName)) {
                //不存在则动态创建该表
                createLightSignalLogTable(tableName);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        //插入信号日志
        StringBuilder insertSql = new StringBuilder();
        insertSql.append("insert into " + tableName + "(gmt_created, gmt_updated, uid, signal_log_date, longitude, latitude, ");
        insertSql.append("signal_intensity, unit, signal_level, online_state) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

        return jdbcTemplate.update(insertSql.toString(), new Object[] {new Date(), new Date(), lightSignalLog.getUid(), lightSignalLog.getSignalLogDate(),
            lightSignalLog.getLongitude(), lightSignalLog.getLatitude(), lightSignalLog.getSignalIntensity(), lightSignalLog.getUnit(),
            lightSignalLog.getSignalLevel(), lightSignalLog.getOnlineState()});
    }
}
