package com.nnlightctl.jdbcdao.impl;

import com.github.pagehelper.PageHelper;
import com.nnlight.common.TableNameUtil;
import com.nnlight.common.Tuple;
import com.nnlightctl.jdbcdao.LightSignalRecordDao;
import com.nnlightctl.po.LightSignalLog;
import com.nnlightctl.po.LightSignalLogExample;
import com.nnlightctl.request.SignalLogRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

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
    @Override
    public Tuple.TwoTuple<List<LightSignalLog>, Integer> listLightSignalLog(SignalLogRequest request) {
        Tuple.TwoTuple<List<LightSignalLog>, Integer> tuple = new Tuple.TwoTuple<>();
        List<LightSignalLog> listTotal = new ArrayList<>();
        int sum= 0;
        if (StringUtils.isEmpty(request.getStartDate())){
            Calendar currentDate = new GregorianCalendar();

            currentDate.set(Calendar.HOUR_OF_DAY, 0);
            currentDate.set(Calendar.MINUTE, 0);
            currentDate.set(Calendar.SECOND, 0);
            request.setStartDate((Date)currentDate.getTime().clone());
        }
        if (StringUtils.isEmpty(request.getEndDate())){
            request.setEndDate(new Date());
        }

        List<String> tableNameList = TableNameUtil.findDates(request.getStartDate(),request.getEndDate(),"nnlightctl_light_signal_log");

        for(int i = 0 ; i< tableNameList.size() ; i++){
            //判断该表是否存在
            try {
                if (TableNameUtil.isTableExist(jdbcTemplate, tableNameList.get(i))) {
                    StringBuilder stringBuilder = new StringBuilder();
                    StringBuilder countSql = new StringBuilder();
                    countSql.append("select count(*) ");
                    countSql.append("from "+tableNameList.get(i)+" ");
                    List<Object> param = new ArrayList<>(1);
                    stringBuilder.append("SELECT id , gmt_created , gmt_updated , uid , signal_log_date , longitude , latitude ,signal_intensity , unit ,signal_level ,online_state FROM "+tableNameList.get(i)+" ");
                    if (!StringUtils.isEmpty(request.getUuid())){
                        stringBuilder.append(" where uid like ?");
                        countSql.append(" where uid like ?");
                        param.add(request.getUuid());
                    }
                    int total = jdbcTemplate.queryForObject(countSql.toString(), param.toArray(), Integer.class);
                    sum += total;
                    stringBuilder.append("order by id DESC ");

                    if (request.getPageSize() > 0 && request.getPageNumber() > 0) {
                        stringBuilder.append("limit ?, ?");
                        param.add((request.getPageNumber() - 1) * request.getPageSize());
                        param.add(request.getPageSize());
                    }
                    List<LightSignalLog> lightingViewList = jdbcTemplate.query(stringBuilder.toString(), param.toArray(), new RowMapper<LightSignalLog>() {
                        @Override
                        public LightSignalLog mapRow(ResultSet resultSet, int i) throws SQLException {
                            LightSignalLog lightSignalLog = new LightSignalLog();
                            lightSignalLog.setId(resultSet.getLong("id"));
                            lightSignalLog.setGmtCreated(resultSet.getTimestamp("gmt_created"));
                            lightSignalLog.setGmtUpdated(resultSet.getTimestamp("gmt_updated"));
                            lightSignalLog.setUid(resultSet.getString("uid"));
                            lightSignalLog.setSignalLogDate(resultSet.getTimestamp("signal_log_date"));
                            lightSignalLog.setLongitude(resultSet.getString("longitude"));
                            lightSignalLog.setLatitude(resultSet.getString("latitude"));
                            lightSignalLog.setSignalIntensity(resultSet.getBigDecimal("signal_intensity"));
                            lightSignalLog.setUnit(resultSet.getString("unit"));
                            lightSignalLog.setSignalLevel(resultSet.getByte("signal_level"));
                            lightSignalLog.setOnlineState(resultSet.getByte("online_state"));
                            return lightSignalLog;
                        }

                    });
                    listTotal.addAll(lightingViewList);
                }
            } catch (Exception e) {
                log.error(e.getMessage());
            }

        }
        tuple.setFirst(listTotal);
        tuple.setSecond(sum);
        return tuple;
    }
}
