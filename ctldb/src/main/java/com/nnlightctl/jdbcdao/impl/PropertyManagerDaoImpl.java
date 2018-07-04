package com.nnlightctl.jdbcdao.impl;

import com.nnlight.common.Tuple;
import com.nnlightctl.jdbcdao.PropertyManagerDao;
import com.nnlightctl.po.RepairRecord;
import com.nnlightctl.request.ListDeviceDamageCountByMonthRequest;
import com.nnlightctl.request.ListDeviceRepairStatisticRequest;
import com.nnlightctl.request.ListRepairRecordRequest;
import com.nnlightctl.vo.LightingView;
import com.nnlightctl.vo.ListDeviceDamageCountByMonthView;
import com.nnlightctl.vo.ListDeviceRepairStatisticView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PropertyManagerDaoImpl implements PropertyManagerDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<ListDeviceRepairStatisticView> listDeviceRepaireStatistic(ListDeviceRepairStatisticRequest listDeviceRepairStatisticRequest){
        StringBuilder sql = new StringBuilder();
        List<Object> param = new ArrayList<>(2);
        sql.append("SELECT count(a.nnlightctl_property_classify_catalog_id) as ListDeviceRepairStatisticCount ,b.my_catalog_name as myCatalogName from nnlightctl_repair_record a LEFT JOIN nnlightctl_property_classify_catalog b ");
        sql.append("on a.nnlightctl_property_classify_catalog_id = b.id where 1=1 ");
        if (listDeviceRepairStatisticRequest.getStartDate() != null){
            sql.append("and a.fault_date >= ? ");
            param.add(listDeviceRepairStatisticRequest.getStartDate());
        }
        if(listDeviceRepairStatisticRequest.getEndDate() != null){
            sql.append("and a.fault_date <= ? ");
            param.add(listDeviceRepairStatisticRequest.getEndDate());
        }
        sql.append(" GROUP BY a.nnlightctl_property_classify_catalog_id");

        List<ListDeviceRepairStatisticView> listDeviceRepairStatisticViewList = jdbcTemplate.query(sql.toString(), param.toArray(), new RowMapper<ListDeviceRepairStatisticView>() {
            @Override
            public ListDeviceRepairStatisticView mapRow(ResultSet resultSet, int i) throws SQLException {
                ListDeviceRepairStatisticView listDeviceRepairStatisticView = new ListDeviceRepairStatisticView();
                listDeviceRepairStatisticView.setListDeviceRepairStatisticCount(resultSet.getLong("ListDeviceRepairStatisticCount"));
                listDeviceRepairStatisticView.setMyCatalogName(resultSet.getString("myCatalogName"));
                return listDeviceRepairStatisticView;
            }
        });
        return listDeviceRepairStatisticViewList;
    }

    @Override
    public List<ListDeviceDamageCountByMonthView> listDeviceDamageCountByMonth(ListDeviceDamageCountByMonthRequest listDeviceDamageCountByMonthRequest){
        StringBuilder sql = new StringBuilder();
        List<Object> param = new ArrayList<>(2);
        sql.append("SELECT SUBSTR(fault_date,1,7) AS month, COUNT(*) AS MonthCount FROM nnlightctl_repair_record where 1=1 ");
        if(listDeviceDamageCountByMonthRequest.getStartDate() != null){
            sql.append("and fault_date >= ? ");
            param.add(listDeviceDamageCountByMonthRequest.getStartDate());
        }
        if(listDeviceDamageCountByMonthRequest.getEndDate() != null){
            sql.append("and fault_date <= ? ");
            param.add(listDeviceDamageCountByMonthRequest.getEndDate());
        }
        sql.append("GROUP BY month");

        List<ListDeviceDamageCountByMonthView> listDeviceDamageCountByMonthViewList = jdbcTemplate.query(sql.toString(), param.toArray(), new RowMapper<ListDeviceDamageCountByMonthView>() {
            @Override
            public ListDeviceDamageCountByMonthView mapRow(ResultSet resultSet, int i) throws SQLException {
                ListDeviceDamageCountByMonthView listDeviceDamageCountByMonthView = new ListDeviceDamageCountByMonthView();
                listDeviceDamageCountByMonthView.setMonth(resultSet.getString("month"));
                listDeviceDamageCountByMonthView.setMonthCount(resultSet.getLong("monthCount"));
                return listDeviceDamageCountByMonthView;
            }
        });
        return listDeviceDamageCountByMonthViewList;
    }

    @Override
    public Tuple.TwoTuple<List<RepairRecord>, Integer> listRepairRecord(ListRepairRecordRequest request){
        StringBuilder sql = new StringBuilder();
        StringBuilder countSql = new StringBuilder();

        List<Object> params = new ArrayList<>(1);
        sql.append("SELECT id ,gmt_created ,gmt_updated ,nnlightctl_elebox_id ,nnlightctl_property_classify_catalog_id ,property_name ,property_count ,fault_date ,create_date ,nnlightctl_user_id ,is_commit FROM nnlightctl_repair_record where 1=1 ");
        countSql.append("select count(*) FROM nnlightctl_repair_record where 1=1 ");

        sql.append("and is_commit = ? ");
        countSql.append("and is_commit = ? ");

        params.add(request.getIsCommit());
        int total = jdbcTemplate.queryForObject(countSql.toString(), params.toArray(), Integer.class);

        sql.append("order by id DESC ");

        if (request.getPageSize() > 0 && request.getPageNumber() > 0) {
            sql.append("limit ?, ?");
            params.add((request.getPageNumber() - 1) * request.getPageSize());
            params.add(request.getPageSize());
        }
        List<RepairRecord> repairRecordList = jdbcTemplate.query(sql.toString(), params.toArray(), new RowMapper<RepairRecord>() {
            @Override
            public RepairRecord mapRow(ResultSet resultSet, int i) throws SQLException {
                RepairRecord repairRecord = new RepairRecord();
                repairRecord.setId(resultSet.getLong("id"));
                repairRecord.setGmtCreated(resultSet.getDate("gmt_created"));
                repairRecord.setGmtUpdated(resultSet.getDate("gmt_updated"));
                repairRecord.setNnlightctlEleboxId(resultSet.getLong("nnlightctl_elebox_id"));
                repairRecord.setNnlightctlPropertyClassifyCatalogId(resultSet.getLong("nnlightctl_property_classify_catalog_id"));
                repairRecord.setPropertyName(resultSet.getString("property_name"));
                repairRecord.setPropertyCount(resultSet.getLong("property_count"));
                repairRecord.setFaultDate(resultSet.getDate("fault_date"));
                repairRecord.setCreateDate(resultSet.getDate("create_date"));
                repairRecord.setNnlightctlUserId(resultSet.getLong("nnlightctl_user_id"));
                repairRecord.setIsCommit(resultSet.getByte("is_commit"));
                return repairRecord;
            }
        });

        Tuple.TwoTuple<List<RepairRecord>, Integer> tuple = new Tuple.TwoTuple<>();
        tuple.setFirst(repairRecordList);
        tuple.setSecond(total);
        return tuple;
    }

    @Override
    public int commitRepairRecord(List<Long> repairRecordIds){
        StringBuilder sql = new StringBuilder();

        Map<String, Object> params = new HashMap<>(1);
        params.put("repairRecordIds", repairRecordIds);

        sql.append("update nnlightctl_repair_record set is_commit = 1 where " +
                "id in (:repairRecordIds)");

        return namedParameterJdbcTemplate.update(sql.toString(), params);
    }
}
