package com.nnlightctl.jdbcdao.impl;

import com.nnlight.common.DateTimeUtil;
import com.nnlight.common.TableNameUtil;
import com.nnlightctl.jdbcdao.LightingVolEleRecordDao;
import com.nnlightctl.po.LightingVolEleRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class LightingVolEleRecordDaoImpl implements LightingVolEleRecordDao {

    private static final String LIGHTING_VOL_ELE_RECORD_TABLENAMEROOT = "nnlightctl_lighting_vol_ele_record";

    private static final Logger log = LoggerFactory.getLogger(LightingVolEleRecordDao.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private void createLightingVolEleRecordTable(String tableName) {
        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE `" + tableName + "` (");
        sql.append("`id` bigint(20) NOT NULL AUTO_INCREMENT,");
        sql.append("`gmt_created` datetime DEFAULT NULL,");
        sql.append("`gmt_updated` datetime DEFAULT NULL,");
        sql.append("`uid` varchar(64) DEFAULT NULL,");
        sql.append("`record_datetime` datetime DEFAULT NULL,");
        sql.append("`voltage` decimal(10,3) DEFAULT NULL,");
        sql.append("`electricty` decimal(10,3) DEFAULT NULL,");
        sql.append("`energy` decimal(10,3) DEFAULT NULL,");
        sql.append("`dampness` decimal(10,3) DEFAULT NULL,");
        sql.append("`temperature` decimal(10,3) DEFAULT NULL,");
        sql.append("`beam` decimal(10,3) DEFAULT NULL,");
        sql.append("`signal_intensity` decimal(10,3) DEFAULT NULL,");
        sql.append("`longitude` varchar(12) DEFAULT NULL,");
        sql.append("`latitude` varchar(12) DEFAULT NULL,");
        sql.append("`in_electricity` varchar(14) DEFAULT NULL,");
        sql.append("`in_voltage` varchar(14) DEFAULT NULL,");
        sql.append("`elec_frequency` varchar(14) DEFAULT NULL,");
        sql.append("`in_active_power` varchar(14) DEFAULT NULL,");
        sql.append("`in_reactive_power` varchar(14) DEFAULT NULL,");
        sql.append("`in_seen_power` varchar(14) DEFAULT NULL,");
        sql.append("`in_active_energy` varchar(14) DEFAULT NULL,");
        sql.append("`in_reactive_energy` varchar(14) DEFAULT NULL,");
        sql.append("`in_seen_energy` varchar(14) DEFAULT NULL,");
        sql.append("PRIMARY KEY (`id`)");
        sql.append(") ENGINE=InnoDB AUTO_INCREMENT=159029 DEFAULT CHARSET=utf8;");

        jdbcTemplate.update(sql.toString());
    }

    @Override
    public int addLightingVolEleRecord(LightingVolEleRecord lightingVolEleRecord) {
        String tableName = TableNameUtil.getTableNameByDate(LIGHTING_VOL_ELE_RECORD_TABLENAMEROOT, new Date());
        //判断该表是否存在
        try {
            if (!TableNameUtil.isTableExist(jdbcTemplate, tableName)) {
                //创建该表
                createLightingVolEleRecordTable(tableName);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        //插入记录到该表
        StringBuilder insertSql = new StringBuilder();
        insertSql.append("insert into " + tableName + "(gmt_created, gmt_updated, uid, record_datetime, voltage, electricty, ");
        insertSql.append("energy, dampness, temperature, beam, signal_intensity, longitude, latitude, in_electricity, in_voltage, ");
        insertSql.append("elec_frequency, in_active_power, in_reactive_power, in_seen_power, in_active_energy, in_reactive_energy, in_seen_energy) ");
        insertSql.append("values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

        return jdbcTemplate.update(insertSql.toString(), new Object[] {new Date(), new Date(), lightingVolEleRecord.getUid(), lightingVolEleRecord.getRecordDatetime(),
            lightingVolEleRecord.getVoltage(), lightingVolEleRecord.getElectricty(), lightingVolEleRecord.getEnergy(), lightingVolEleRecord.getDampness(),
            lightingVolEleRecord.getTemperature(), lightingVolEleRecord.getBeam(), lightingVolEleRecord.getSignalIntensity(), lightingVolEleRecord.getLongitude(),
            lightingVolEleRecord.getLatitude(), lightingVolEleRecord.getInElectricity(), lightingVolEleRecord.getInVoltage(), lightingVolEleRecord.getElecFrequency(),
            lightingVolEleRecord.getInActivePower(), lightingVolEleRecord.getInReactivePower(), lightingVolEleRecord.getInSeenPower(), lightingVolEleRecord.getInActiveEnergy(),
            lightingVolEleRecord.getInReactiveEnergy(), lightingVolEleRecord.getInSeenEnergy()});
    }
}
