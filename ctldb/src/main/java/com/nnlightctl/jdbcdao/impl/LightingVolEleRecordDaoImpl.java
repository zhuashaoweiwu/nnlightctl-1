package com.nnlightctl.jdbcdao.impl;

import com.nnlight.common.DateTimeUtil;
import com.nnlight.common.TableNameUtil;
import com.nnlightctl.jdbcdao.LightingVolEleRecordDao;
import com.nnlightctl.po.LightingVolEleRecord;
import com.nnlightctl.vo.CommonEnergyStatisticView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

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
        sql.append("`lightIMEI` varchar(15) DEFAULT NULL,");
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

    @Override
    public List<CommonEnergyStatisticView> getCommonEnergyStatisticDate(){
        String tableName = TableNameUtil.getTableNameByDateTest(LIGHTING_VOL_ELE_RECORD_TABLENAMEROOT);
        StringBuilder sql = new StringBuilder();
        List<Object> param = new ArrayList<>(1);
        sql.append("SELECT in_seen_energy as energy ,SUBSTR(record_datetime ,1,10) as date FROM "+tableName+" where 1=1 ");
        Date date = new Date();
        Calendar now = Calendar.getInstance();
        String year = now.get(Calendar.YEAR)+"";
        String mouth = "";
        String d = "";
        if (date.getMonth()+1<10){
            mouth = ("0"+(date.getMonth()+1));
        }else {
            mouth = (date.getMonth()+1)+"";
        }
        if (date.getDate() < 11) {
            d = "0"+(date.getDate()-1);
        }else {
            d = ""+(date.getDate()-1);
        }


        String yestoday = year +"-"+ mouth+"-"+d;

        sql.append("and SUBSTR(record_datetime ,1,10) = ? ");
        param.add(yestoday);
        List<CommonEnergyStatisticView> commonEnergyStatisticViewList = jdbcTemplate.query(sql.toString(), param.toArray(), new RowMapper<CommonEnergyStatisticView>() {
            @Override
            public CommonEnergyStatisticView mapRow(ResultSet resultSet, int i) throws SQLException {
                CommonEnergyStatisticView commonEnergyStatisticView = new CommonEnergyStatisticView();
                commonEnergyStatisticView.setEnergy(resultSet.getString("energy"));
                commonEnergyStatisticView.setDate(resultSet.getString("date"));
                return commonEnergyStatisticView;
            }
        });
        CommonEnergyStatisticView commonEnergyStatisticView = new CommonEnergyStatisticView();
        BigDecimal big = new BigDecimal(0);
        for(CommonEnergyStatisticView en:commonEnergyStatisticViewList){
            String e = !StringUtils.isEmpty(en.getEnergy())?en.getEnergy():"0";
            BigDecimal bd=new BigDecimal(e);
            big=big.add(bd);
        }
        commonEnergyStatisticView.setTotalEnergy(big);
        commonEnergyStatisticView.setDate(yestoday);
        List<CommonEnergyStatisticView> list = new ArrayList<>();
        list.add(commonEnergyStatisticView);
        return list;
    }
    @Override
    public List<CommonEnergyStatisticView> getCommonEnergyStatisticMouth(){
        List<String> tableNameList = TableNameUtil.getAllMonthEnd(LIGHTING_VOL_ELE_RECORD_TABLENAMEROOT);
        List<CommonEnergyStatisticView> listTotal = new ArrayList<>();
        BigDecimal sum = new BigDecimal(0);
        CommonEnergyStatisticView commonEnergyStatisticView = new CommonEnergyStatisticView();
        String  m="";
        for(int i = 0 ; i < tableNameList.size() ; i++){
            try {
                if (TableNameUtil.isTableExist(jdbcTemplate, tableNameList.get(i))) {
                    StringBuilder sql = new StringBuilder();
                    List<Object> param = new ArrayList<>(1);
                    sql.append("SELECT in_seen_energy as energy ,SUBSTR(record_datetime ,1,7) as mouth   FROM "+tableNameList.get(i)+" where 1=1 ");
                    Date date = new Date();
                    Calendar now = Calendar.getInstance();
                    String year = now.get(Calendar.YEAR)+"";
                    String mouth = "";
                    if (date.getMonth()+1 < 10){
                        mouth = "0"+(date.getMonth()+1);
                    }else {
                        mouth = ""+(date.getMonth()+1);
                    }
                    m=year +"-"+ mouth;
                    sql.append(" and SUBSTR(record_datetime ,1,7) = ? ");
                    param.add(m);
                    List<CommonEnergyStatisticView> commonEnergyStatisticViewList = jdbcTemplate.query(sql.toString(), param.toArray(), new RowMapper<CommonEnergyStatisticView>() {
                        @Override
                        public CommonEnergyStatisticView mapRow(ResultSet resultSet, int i) throws SQLException {
                            CommonEnergyStatisticView commonEnergyStatisticView = new CommonEnergyStatisticView();
                            commonEnergyStatisticView.setEnergy(resultSet.getString("energy"));
                            commonEnergyStatisticView.setMouth(resultSet.getString("mouth"));
                            return commonEnergyStatisticView;
                        }
                    });
                    BigDecimal big = new BigDecimal(0);
                    for(CommonEnergyStatisticView en:commonEnergyStatisticViewList){
                        String e = !StringUtils.isEmpty(en.getEnergy())?en.getEnergy():"0";
                        BigDecimal bd=new BigDecimal(e);
                        big=big.add(bd);
                    }
                    sum = sum.add(big);
                }
            } catch (Exception e) {
                log.error(e.getMessage());
            }

        }
        commonEnergyStatisticView.setTotalEnergy(sum);
        commonEnergyStatisticView.setMouth(m);
        listTotal.add(commonEnergyStatisticView);
      return listTotal;

    }
    @Override
    public List<CommonEnergyStatisticView> getCommonEnergyStatisticYear(){
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, 0);
        c.set(Calendar.DAY_OF_YEAR,1);//设置为1号,当前日期既为本年第一天
        List<String> tableNameList = TableNameUtil.findDates(c.getTime(),new Date(),LIGHTING_VOL_ELE_RECORD_TABLENAMEROOT);
        List<CommonEnergyStatisticView> listTotal = new ArrayList<>();
        BigDecimal sum = new BigDecimal(0);
        String year = "";
        CommonEnergyStatisticView commonEnergyStatisticView = new CommonEnergyStatisticView();
        for (int i = 0 ; i < tableNameList.size() ; i++){
            //判断该表是否存在
            try {
                if (TableNameUtil.isTableExist(jdbcTemplate, tableNameList.get(i))) {
                    StringBuilder sql = new StringBuilder();
                    List<Object> param = new ArrayList<>(1);
                    sql.append("SELECT in_seen_energy as energy  ,SUBSTR(record_datetime ,1,4) as year FROM "+tableNameList.get(i)+" where 1=1 ");
                    Calendar now = Calendar.getInstance();
                    year = now.get(Calendar.YEAR)+"";
                    sql.append("and SUBSTR(record_datetime ,1,4) = ? ");
                    param.add(year);
                    List<CommonEnergyStatisticView> commonEnergyStatisticViewList = jdbcTemplate.query(sql.toString(), param.toArray(), new RowMapper<CommonEnergyStatisticView>() {
                        @Override
                        public CommonEnergyStatisticView mapRow(ResultSet resultSet, int i) throws SQLException {
                            CommonEnergyStatisticView commonEnergyStatisticView = new CommonEnergyStatisticView();
                            commonEnergyStatisticView.setEnergy(resultSet.getString("energy"));
                            commonEnergyStatisticView.setYear(resultSet.getString("year"));
                            return commonEnergyStatisticView;
                        }
                    });
                    BigDecimal big = new BigDecimal(0);
                    for(CommonEnergyStatisticView en:commonEnergyStatisticViewList){
                        String e = !StringUtils.isEmpty(en.getEnergy())?en.getEnergy():"0";
                        BigDecimal bd=new BigDecimal(e);
                        big=big.add(bd);
                    }
                    sum = sum.add(big);
                }
            } catch (Exception e) {
                log.error(e.getMessage());
            }

        }
        commonEnergyStatisticView.setTotalEnergy(sum);
        commonEnergyStatisticView.setYear(year);
        listTotal.add(commonEnergyStatisticView);
        return listTotal;
    }
    public List<CommonEnergyStatisticView> listEnergyStatisticByDay(int month ){
        List<String> tableNameList = TableNameUtil.getAllMonthEnd(LIGHTING_VOL_ELE_RECORD_TABLENAMEROOT);
        List<CommonEnergyStatisticView> listTotal = new ArrayList<>();
        for(int k = 0 ; k < tableNameList.size() ; k++){
            List<CommonEnergyStatisticView> list = new ArrayList<>();
            try {
                if (TableNameUtil.isTableExist(jdbcTemplate, tableNameList.get(k))) {
                    StringBuilder sql = new StringBuilder();
                    List<Object> param = new ArrayList<>(1);
                    sql.append("SELECT in_seen_energy AS energy , SUBSTR(record_datetime ,1,10) as date FROM "+tableNameList.get(k)+" where 1=1 ");
                    sql.append("and SUBSTR(record_datetime ,1,7) = ? ");
                    Calendar now = Calendar.getInstance();
                    String year = now.get(Calendar.YEAR)+"";
                    if (month < 10) {
                        param.add(year+"-0"+month);
                    }else {
                        param.add(year+"-"+month);
                    }

                    List<CommonEnergyStatisticView> commonEnergyStatisticViewList = jdbcTemplate.query(sql.toString(), param.toArray(), new RowMapper<CommonEnergyStatisticView>() {
                        @Override
                        public CommonEnergyStatisticView mapRow(ResultSet resultSet, int i) throws SQLException {
                            CommonEnergyStatisticView commonEnergyStatisticView = new CommonEnergyStatisticView();
                            commonEnergyStatisticView.setEnergy(resultSet.getString("energy"));
                            commonEnergyStatisticView.setDate(resultSet.getString("date"));
                            return commonEnergyStatisticView;
                        }
                    });
                    Map<String ,BigDecimal> map = new HashMap<>();
                    //List<CommonEnergyStatisticView> list = new ArrayList<>();
                    BigDecimal big = new BigDecimal(0);
                    String data= "";
                    CommonEnergyStatisticView commonEnergyStatisticView = new CommonEnergyStatisticView();
                    for(CommonEnergyStatisticView en:commonEnergyStatisticViewList){
                        String e = !StringUtils.isEmpty(en.getEnergy())?en.getEnergy():"0";
                        BigDecimal bd=new BigDecimal(e);
                        big=big.add(bd);
                        data = en.getDate();
                    }
                    commonEnergyStatisticView.setEnergy(big+"");
                    commonEnergyStatisticView.setDate(data);
                    list.add(commonEnergyStatisticView);
                    listTotal.addAll(list);
                }
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
        return listTotal;
    }
}
