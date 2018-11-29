package com.nnlightctl.jdbcdao.impl;

import com.nnlightctl.jdbcdao.EnergyStatisticDao;
import com.nnlightctl.po.EleboxVolEleRecord;
import com.nnlightctl.po.LightingVolEleRecord;
import com.nnlightctl.request.EleboxPowerRequest;
import com.nnlightctl.request.LightingVolEleRecordRequest;
import com.nnlightctl.request.listEleboxEnergyStatisticRequest;
import com.nnlightctl.vo.CommonEnergyStatisticView;
import com.nnlightctl.vo.GetEleboxEnergyStatisticView;
import com.nnlightctl.vo.ListEleboxEnergyStatisticView;
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
public class EnergyStatisticDaoImpl implements EnergyStatisticDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<EleboxVolEleRecord> listEleboxPower(EleboxPowerRequest eleboxPowerRequest){
        //List<EleboxVolEleRecord> eleboxVolEleRecordList = null;
        StringBuilder sql = new StringBuilder();

        List<Object> param = new ArrayList<>(3);
        sql.append("SELECT id ,gmt_created ,gmt_updated ,uid ,realtime_date ,voltage ,electricity ,voltage*electricity as elebox_power from nnlightctl_elebox_vol_ele_record where 1=1 ");

        if (eleboxPowerRequest.getEleboxId() != null) {
            sql.append("and  uid = ? ");
            param.add(eleboxPowerRequest.getUid());
        }
        if(eleboxPowerRequest.getStartDate() != null){
            sql.append("and realtime_date >= ? ");
            param.add(eleboxPowerRequest.getStartDate());
        }
        if(eleboxPowerRequest.getEndDate() !=null){
            sql.append("and realtime_date <= ? ");
            param.add(eleboxPowerRequest.getEndDate());
        }

        List<EleboxVolEleRecord> eleboxVolEleRecordList = jdbcTemplate.query(sql.toString(), param.toArray(), new RowMapper<EleboxVolEleRecord>() {
            @Override
            public EleboxVolEleRecord mapRow(ResultSet resultSet, int i) throws SQLException {
                EleboxVolEleRecord eleboxVolEleRecord = new EleboxVolEleRecord();
                eleboxVolEleRecord.setId(resultSet.getLong("id"));
                eleboxVolEleRecord.setEleboxPower(resultSet.getBigDecimal("elebox_power"));
                eleboxVolEleRecord.setElectricity(resultSet.getBigDecimal("electricity"));
                eleboxVolEleRecord.setGmtCreated(resultSet.getTimestamp("gmt_created"));
                eleboxVolEleRecord.setGmtUpdated(resultSet.getTimestamp("gmt_updated"));
                eleboxVolEleRecord.setRealtimeDate(resultSet.getTimestamp("realtime_date"));
                eleboxVolEleRecord.setUid(resultSet.getString("uid"));
                eleboxVolEleRecord.setVoltage(resultSet.getBigDecimal("voltage"));
                return eleboxVolEleRecord;
            }
        });

        return eleboxVolEleRecordList;
    }

    public List<LightingVolEleRecord> listLightingVolEleRecord(LightingVolEleRecordRequest lightingVolEleRecordRequest){

        StringBuilder sql = new StringBuilder();
        List<Object> param = new ArrayList<>(3);
        Map<String, Object> params = new HashMap<>(1);
        String lightIds = "";
        sql.append("SELECT id ,gmt_created ,gmt_updated ,uid ,record_datetime ,voltage ,electricty ,dampness ,temperature ,beam ,signal_intensity ,longitude ,voltage*electricty as persist3 from nnlightctl_lighting_vol_ele_record where 1=1 ");

        if(lightingVolEleRecordRequest.getLightIds().isEmpty()){
            sql.append("and 1=1 ");
        }else{
            for(int i = 0; i < lightingVolEleRecordRequest.getLightIds().size();i++){
                if(i!=( lightingVolEleRecordRequest.getLightIds().size()-1)){
                    lightIds +=  lightingVolEleRecordRequest.getLightIds().get(i) + ",";
                }else{
                    lightIds +=  lightingVolEleRecordRequest.getLightIds().get(i);
                }
            }
            sql.append(" and uid IN("+lightIds+") ");
        }
        if (lightingVolEleRecordRequest.getStartDate() != null){
            sql.append("and record_datetime >= ? ");
            param.add(lightingVolEleRecordRequest.getStartDate());
        }
        if(lightingVolEleRecordRequest.getEndDate()!= null){
            sql.append("and record_datetime <= ? ");
            param.add(lightingVolEleRecordRequest.getEndDate());
        }
        List<LightingVolEleRecord> lightingVolEleRecordList = jdbcTemplate.query(sql.toString(), param.toArray(), new RowMapper<LightingVolEleRecord>() {
            @Override
            public LightingVolEleRecord mapRow(ResultSet resultSet, int i) throws SQLException {
                LightingVolEleRecord lightingVolEleRecord = new LightingVolEleRecord();
                lightingVolEleRecord.setId(resultSet.getLong("id"));
                lightingVolEleRecord.setGmtCreated(resultSet.getDate("gmt_created"));
                lightingVolEleRecord.setGmtUpdated(resultSet.getDate("gmt_updated"));
                lightingVolEleRecord.setUid(resultSet.getString("uid"));
                lightingVolEleRecord.setRecordDatetime(resultSet.getDate("record_datetime"));
                lightingVolEleRecord.setVoltage(resultSet.getBigDecimal("voltage"));
                lightingVolEleRecord.setElectricty(resultSet.getBigDecimal("electricty"));
                lightingVolEleRecord.setDampness(resultSet.getBigDecimal("dampness"));
                lightingVolEleRecord.setBeam(resultSet.getBigDecimal("beam"));
                lightingVolEleRecord.setSignalIntensity(resultSet.getBigDecimal("persist1"));
                lightingVolEleRecord.setLongitude(resultSet.getString("persist2"));
                lightingVolEleRecord.setLatitude(resultSet.getString("persist3"));
                lightingVolEleRecord.setTemperature(resultSet.getBigDecimal("temperature"));
                return lightingVolEleRecord;
            }
        });

        return lightingVolEleRecordList;
    }

    public List<CommonEnergyStatisticView> getCommonEnergyStatisticYear(){
        StringBuilder sql = new StringBuilder();
        List<Object> param = new ArrayList<>(1);
        sql.append("SELECT in_seen_energy as energy  ,SUBSTR(record_datetime ,1,4) as year FROM nnlightctl_lighting_vol_ele_record where 1=1 ");
        Calendar now = Calendar.getInstance();
        String year = now.get(Calendar.YEAR)+"";
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
        CommonEnergyStatisticView commonEnergyStatisticView = new CommonEnergyStatisticView();
        BigDecimal big = new BigDecimal(0);
        for(CommonEnergyStatisticView en:commonEnergyStatisticViewList){
            String e = !StringUtils.isEmpty(en.getEnergy())?en.getEnergy():"0";
            BigDecimal bd=new BigDecimal(e);
            big=big.add(bd);
        }
        commonEnergyStatisticView.setTotalEnergy(big);
        commonEnergyStatisticView.setYear(year);
        List<CommonEnergyStatisticView> list = new ArrayList<>();
        list.add(commonEnergyStatisticView);
        return list;
    }

    public List<CommonEnergyStatisticView> getCommonEnergyStatisticMouth(){
        StringBuilder sql = new StringBuilder();
        List<Object> param = new ArrayList<>(1);
        sql.append("SELECT in_seen_energy as energy ,SUBSTR(record_datetime ,1,7) as mouth   FROM nnlightctl_lighting_vol_ele_record where 1=1 ");
        Date date = new Date();
        Calendar now = Calendar.getInstance();
        String year = now.get(Calendar.YEAR)+"";
        String mouth = "";
        if (date.getMonth()+1 < 10){
            mouth = "0"+(date.getMonth()+1);
        }else {
            mouth = ""+(date.getMonth()+1);
        }
        String  m= year +"-"+ mouth;
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
        CommonEnergyStatisticView commonEnergyStatisticView = new CommonEnergyStatisticView();
        BigDecimal big = new BigDecimal(0);
        for(CommonEnergyStatisticView en:commonEnergyStatisticViewList){
            String e = !StringUtils.isEmpty(en.getEnergy())?en.getEnergy():"0";
            BigDecimal bd=new BigDecimal(e);
            big=big.add(bd);
        }
        commonEnergyStatisticView.setTotalEnergy(big);
        commonEnergyStatisticView.setMouth(m);
        List<CommonEnergyStatisticView> list = new ArrayList<>();
        list.add(commonEnergyStatisticView);
        return list;

    }

    public List<CommonEnergyStatisticView> getCommonEnergyStatisticDate(){
        StringBuilder sql = new StringBuilder();
        List<Object> param = new ArrayList<>(1);
        sql.append("SELECT in_seen_energy as energy ,SUBSTR(record_datetime ,1,10) as date FROM nnlightctl_lighting_vol_ele_record where 1=1 ");
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

    public List<CommonEnergyStatisticView> listEnergyStatisticByDay(int month ){
        StringBuilder sql = new StringBuilder();
        List<Object> param = new ArrayList<>(1);
        sql.append("SELECT in_seen_energy AS energy , SUBSTR(record_datetime ,1,10) as date FROM nnlightctl_lighting_vol_ele_record where 1=1 ");
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
        List<CommonEnergyStatisticView> list = new ArrayList<>();
        BigDecimal en = new BigDecimal(0);
        for(int i = 0 ; i < commonEnergyStatisticViewList.size() ; i++) {
            String data = commonEnergyStatisticViewList.get(i).getDate();
            String e = !StringUtils.isEmpty(commonEnergyStatisticViewList.get(i).getEnergy()) ? commonEnergyStatisticViewList.get(i).getEnergy() : "0";
            int flag = 0;// 0为新增数据，1为增加count
            for (int j = 0; j < list.size(); j++) {
                String data_ = list.get(j).getDate();
                String e_ = !StringUtils.isEmpty(list.get(j).getEnergy()) ? list.get(j).getEnergy() : "0";
                if(data.equals(data_)){
                    BigDecimal sum = new BigDecimal(e).add(new BigDecimal(e_));
                    CommonEnergyStatisticView comm = new CommonEnergyStatisticView();
                    list.get(j).setEnergy(sum+"");
                    list.get(j).setDate(data_);
                    flag = 1;
                    continue;
                }
            }
            if (flag == 0){
                list.add(commonEnergyStatisticViewList.get(i));
            }
        }
        return list;
    }

    public List<ListEleboxEnergyStatisticView> listEleboxEnergyStatistic(listEleboxEnergyStatisticRequest request){
        StringBuilder sql = new StringBuilder();
        List<Object> param = new ArrayList<>(2);
        sql.append("SELECT uid ,SUM(electricity) as total  from nnlightctl_elebox_vol_ele_record where 1=1 ");
        if (request.getStartDate() != null){
            sql.append("and realtime_date >= ? ");
            param.add(request.getStartDate());
        }
        if(request.getEndDate() != null){
            sql.append(" and realtime_date <= ? ");
            param.add(request.getEndDate());
        }
        sql.append(" GROUP BY uid ");

        if (request.getPageSize() > 0 && request.getPageNumber() > 0) {
            sql.append("limit ?, ?");
            param.add((request.getPageNumber() - 1) * request.getPageSize());
            param.add(request.getPageSize());
        }
        List<ListEleboxEnergyStatisticView> listEleboxEnergyStatisticViewList = jdbcTemplate.query(sql.toString(), param.toArray(), new RowMapper<ListEleboxEnergyStatisticView>() {
            @Override
            public ListEleboxEnergyStatisticView mapRow(ResultSet resultSet, int i) throws SQLException {
                ListEleboxEnergyStatisticView listEleboxEnergyStatisticView = new ListEleboxEnergyStatisticView();
                listEleboxEnergyStatisticView.setUid(resultSet.getString("uid"));
                listEleboxEnergyStatisticView.setTotal(resultSet.getBigDecimal("total"));
                return listEleboxEnergyStatisticView;
            }
        });
        return listEleboxEnergyStatisticViewList;
    }

    public  List<GetEleboxEnergyStatisticView> getEleboxEnergyStatistic(listEleboxEnergyStatisticRequest request){
        StringBuilder sql = new StringBuilder();
        List<Object> param = new ArrayList<>(1);
        sql.append("SELECT sum(electricity) as total , SUBSTR(realtime_date ,1,10) as time from nnlightctl_elebox_vol_ele_record where id in ");
        if (request.getEleboxId()!=null){
            sql.append("( SELECT id from nnlightctl_elebox_vol_ele_record where uid = ? ) ");
            param.add(request.getEleboxId());
        }
        sql.append(" GROUP BY SUBSTR(realtime_date ,1,7) ");
        if (request.getPageSize() > 0 && request.getPageNumber() > 0) {
            sql.append("limit ?, ?");
            param.add((request.getPageNumber() - 1) * request.getPageSize());
            param.add(request.getPageSize());
        }
        List<GetEleboxEnergyStatisticView> getEleboxEnergyStatisticViewList = jdbcTemplate.query(sql.toString(), param.toArray(), new RowMapper<GetEleboxEnergyStatisticView>() {
            @Override
            public GetEleboxEnergyStatisticView mapRow(ResultSet resultSet, int i) throws SQLException {
                GetEleboxEnergyStatisticView getEleboxEnergyStatisticView = new GetEleboxEnergyStatisticView();
                getEleboxEnergyStatisticView.setMouth(resultSet.getString("time"));
                getEleboxEnergyStatisticView.setTotal(resultSet.getLong("total"));
                return getEleboxEnergyStatisticView;
            }
        });
        return getEleboxEnergyStatisticViewList;
    }
}
