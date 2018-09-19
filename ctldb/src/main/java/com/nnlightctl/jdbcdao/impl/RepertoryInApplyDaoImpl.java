package com.nnlightctl.jdbcdao.impl;

import com.nnlight.common.Tuple;
import com.nnlightctl.jdbcdao.RepertoryInApplyDao;
import com.nnlightctl.po.RepertoryInApply;
import com.nnlightctl.po.RepertoryOutApply;
import com.nnlightctl.request.ApproveApplyInRepertoryRequest;
import com.nnlightctl.request.ApproveApplyOutRepertoryRequest;
import com.nnlightctl.request.BaseRequest;
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
public class RepertoryInApplyDaoImpl implements RepertoryInApplyDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Tuple.TwoTuple<List<RepertoryInApply>, Integer> listApplyInApprovePending(BaseRequest request , int applyState){
        StringBuilder sql = new StringBuilder();
        StringBuilder countSql = new StringBuilder();
        List<Object> params = new ArrayList<>(1);
        sql.append("SELECT id ,gmt_created ,gmt_updated ,serialnumber ,in_repertory_date ,nnlightctl_property_classify_catalog_id ,nnlightctl_supplier ,property_name ,property_uid ,property_count , ");
        sql.append("nnlightctl_repertory_in_reason_id , nnlightctl_repertory_id ,nnlightctl_user_apply_id ,apply_state from nnlightctl_repertory_in_apply where 1=1 ");
        countSql.append("SELECT count(*) from nnlightctl_repertory_in_apply where 1=1 ");
        if (applyState != 2) {
            sql.append(" and apply_state = ? ");
            countSql.append(" and apply_state = ? ");
            params.add(applyState);
        }
        int total = jdbcTemplate.queryForObject(countSql.toString(), params.toArray(), Integer.class);

        sql.append("order by id DESC ");

        if (request.getPageSize() > 0 && request.getPageNumber() > 0) {
            sql.append("limit ?, ?");
            params.add((request.getPageNumber() - 1) * request.getPageSize());
            params.add(request.getPageSize());
        }
        List<RepertoryInApply> repertoryInApplyList = jdbcTemplate.query(sql.toString(), params.toArray(), new RowMapper<RepertoryInApply>() {
            @Override
            public RepertoryInApply mapRow(ResultSet resultSet, int i) throws SQLException {
                RepertoryInApply repertoryInApply = new RepertoryInApply();
                repertoryInApply.setId(resultSet.getLong("id"));
                repertoryInApply.setGmtCreated(resultSet.getDate("gmt_created"));
                repertoryInApply.setGmtUpdated(resultSet.getDate("gmt_updated"));
                repertoryInApply.setSerialnumber(resultSet.getString("serialnumber"));
                repertoryInApply.setInRepertoryDate(resultSet.getDate("in_repertory_date"));
                repertoryInApply.setNnlightctlPropertyClassifyCatalogId(resultSet.getLong("nnlightctl_property_classify_catalog_id"));
                repertoryInApply.setNnlightctlSupplier(resultSet.getLong("nnlightctl_supplier"));
                repertoryInApply.setPropertyName(resultSet.getString("property_name"));
                repertoryInApply.setPropertyUid(resultSet.getString("property_uid"));
                repertoryInApply.setPropertyCount(resultSet.getLong("property_count"));
                repertoryInApply.setNnlightctlRepertoryInReasonId(resultSet.getLong("nnlightctl_repertory_in_reason_id"));
                repertoryInApply.setNnlightctlRepertoryId(resultSet.getLong("nnlightctl_repertory_id"));
                repertoryInApply.setNnlightctlUserApplyId(resultSet.getLong("nnlightctl_user_apply_id"));
                repertoryInApply.setApplyState(resultSet.getByte("apply_state"));
                return repertoryInApply;
            }
        });
        Tuple.TwoTuple<List<RepertoryInApply>, Integer> tuple = new Tuple.TwoTuple<>();
        tuple.setFirst(repertoryInApplyList);
        tuple.setSecond(total);
        return tuple;
    }
    @Override
    public  Tuple.TwoTuple<List<RepertoryOutApply>, Integer> listApplyOutApprovePending(BaseRequest request , Integer applyState){
        StringBuilder sql = new StringBuilder();
        StringBuilder countSql = new StringBuilder();
        List<Object> params = new ArrayList<>(1);
        sql.append("SELECT id ,gmt_created ,gmt_updated ,serialnumber ,nnlightctl_property_id ,nnlightctl_user_id ,apply_state ,refuse_reason from nnlightctl_repertory_out_apply where 1=1 ");
        countSql.append("SELECT count(*) from nnlightctl_repertory_out_apply where 1=1 ");
        if (applyState != 2) {
            sql.append(" and apply_state = ? ");
            countSql.append(" and apply_state = ? ");
            params.add(applyState);
        }
        int total = jdbcTemplate.queryForObject(countSql.toString(), params.toArray(), Integer.class);

        sql.append("order by id DESC ");

        if (request.getPageSize() > 0 && request.getPageNumber() > 0) {
            sql.append("limit ?, ?");
            params.add((request.getPageNumber() - 1) * request.getPageSize());
            params.add(request.getPageSize());
        }
        List<RepertoryOutApply> repertoryOutApplyList = jdbcTemplate.query(sql.toString(), params.toArray(), new RowMapper<RepertoryOutApply>() {
            @Override
            public RepertoryOutApply mapRow(ResultSet resultSet, int i) throws SQLException {
                RepertoryOutApply repertoryOutApply = new RepertoryOutApply();
                repertoryOutApply.setId(resultSet.getLong("id"));
                repertoryOutApply.setGmtCreated(resultSet.getDate("gmt_created"));
                repertoryOutApply.setGmtUpdated(resultSet.getDate("gmt_updated"));
                repertoryOutApply.setSerialnumber(resultSet.getString("serialnumber"));
                repertoryOutApply.setNnlightctlPropertyId(resultSet.getLong("nnlightctl_property_id"));
                repertoryOutApply.setNnlightctlUserId(resultSet.getLong("nnlightctl_user_id"));
                repertoryOutApply.setApplyState(resultSet.getByte("apply_state"));
                repertoryOutApply.setRefuseReason(resultSet.getString("refuse_reason"));
                return repertoryOutApply;
            }
        });
        Tuple.TwoTuple<List<RepertoryOutApply>, Integer> tuple = new Tuple.TwoTuple<>();
        tuple.setFirst(repertoryOutApplyList);
        tuple.setSecond(total);
        return tuple;
    }
    @Override
    public Tuple.TwoTuple<List<RepertoryInApply>, Integer> listApplyInHistory(BaseRequest request ,List<Integer> applyStates){
        StringBuilder sql = new StringBuilder();
        StringBuilder countSql = new StringBuilder();
        List<Object> params = new ArrayList<>(1);
        String inApplyStates = "";
        sql.append("SELECT id ,gmt_created ,gmt_updated ,serialnumber ,in_repertory_date ,nnlightctl_property_classify_catalog_id ,nnlightctl_supplier ,property_name ,property_uid ,property_count , ");
        sql.append("nnlightctl_repertory_in_reason_id , nnlightctl_repertory_id ,nnlightctl_user_apply_id ,apply_state from nnlightctl_repertory_in_apply where 1=1 ");
        countSql.append("SELECT count(*) from nnlightctl_repertory_in_apply where 1=1 ");
        if (applyStates.isEmpty()) {
            sql.append(" and 1=1 ");
            countSql.append(" and 1=1 ");
        }else {
            for(int i = 0; i < applyStates.size();i++){
                if(i!=( applyStates.size()-1)){
                    inApplyStates +=  applyStates.get(i) + ",";
                }else{
                    inApplyStates +=  applyStates.get(i);
                }
            }
            sql.append(" and apply_state IN("+inApplyStates+") ");
            countSql.append(" and apply_state IN("+inApplyStates+") ");
        }
        int total = jdbcTemplate.queryForObject(countSql.toString(), params.toArray(), Integer.class);

        sql.append("order by id DESC ");

        if (request.getPageSize() > 0 && request.getPageNumber() > 0) {
            sql.append("limit ?, ?");
            params.add((request.getPageNumber() - 1) * request.getPageSize());
            params.add(request.getPageSize());
        }
        List<RepertoryInApply> repertoryInApplyList = jdbcTemplate.query(sql.toString(), params.toArray(), new RowMapper<RepertoryInApply>() {
            @Override
            public RepertoryInApply mapRow(ResultSet resultSet, int i) throws SQLException {
                RepertoryInApply repertoryInApply = new RepertoryInApply();
                repertoryInApply.setId(resultSet.getLong("id"));
                repertoryInApply.setGmtCreated(resultSet.getDate("gmt_created"));
                repertoryInApply.setGmtUpdated(resultSet.getDate("gmt_updated"));
                repertoryInApply.setSerialnumber(resultSet.getString("serialnumber"));
                repertoryInApply.setInRepertoryDate(resultSet.getDate("in_repertory_date"));
                repertoryInApply.setNnlightctlPropertyClassifyCatalogId(resultSet.getLong("nnlightctl_property_classify_catalog_id"));
                repertoryInApply.setNnlightctlSupplier(resultSet.getLong("nnlightctl_supplier"));
                repertoryInApply.setPropertyName(resultSet.getString("property_name"));
                repertoryInApply.setPropertyUid(resultSet.getString("property_uid"));
                repertoryInApply.setPropertyCount(resultSet.getLong("property_count"));
                repertoryInApply.setNnlightctlRepertoryInReasonId(resultSet.getLong("nnlightctl_repertory_in_reason_id"));
                repertoryInApply.setNnlightctlRepertoryId(resultSet.getLong("nnlightctl_repertory_id"));
                repertoryInApply.setNnlightctlUserApplyId(resultSet.getLong("nnlightctl_user_apply_id"));
                repertoryInApply.setApplyState(resultSet.getByte("apply_state"));
                return repertoryInApply;
            }
        });
        Tuple.TwoTuple<List<RepertoryInApply>, Integer> tuple = new Tuple.TwoTuple<>();
        tuple.setFirst(repertoryInApplyList);
        tuple.setSecond(total);
        return tuple;
    }
    @Override
    public Tuple.TwoTuple<List<RepertoryOutApply>, Integer> listApplyOutHistory(BaseRequest request ,List<Integer> applyStates){
        StringBuilder sql = new StringBuilder();
        StringBuilder countSql = new StringBuilder();
        List<Object> params = new ArrayList<>(1);
        String inApplyStates = "";
        sql.append("SELECT id ,gmt_created ,gmt_updated ,serialnumber ,nnlightctl_property_id ,nnlightctl_user_id ,apply_state ,refuse_reason from nnlightctl_repertory_out_apply where 1=1 ");
        countSql.append("SELECT count(*) from nnlightctl_repertory_out_apply where 1=1 ");
        if (applyStates.isEmpty()) {
            sql.append(" and 1=1 ");
            countSql.append(" and 1=1 ");
        }else {
            for(int i = 0; i < applyStates.size();i++){
                if(i!=( applyStates.size()-1)){
                    inApplyStates +=  applyStates.get(i) + ",";
                }else{
                    inApplyStates +=  applyStates.get(i);
                }
            }
            sql.append(" and apply_state IN("+inApplyStates+") ");
            countSql.append(" and apply_state IN("+inApplyStates+") ");
        }
        int total = jdbcTemplate.queryForObject(countSql.toString(), params.toArray(), Integer.class);

        sql.append("order by id DESC ");

        if (request.getPageSize() > 0 && request.getPageNumber() > 0) {
            sql.append("limit ?, ?");
            params.add((request.getPageNumber() - 1) * request.getPageSize());
            params.add(request.getPageSize());
        }
        List<RepertoryOutApply> repertoryOutApplyList = jdbcTemplate.query(sql.toString(), params.toArray(), new RowMapper<RepertoryOutApply>() {
            @Override
            public RepertoryOutApply mapRow(ResultSet resultSet, int i) throws SQLException {
                RepertoryOutApply repertoryOutApply = new RepertoryOutApply();
                repertoryOutApply.setId(resultSet.getLong("id"));
                repertoryOutApply.setGmtCreated(resultSet.getDate("gmt_created"));
                repertoryOutApply.setGmtUpdated(resultSet.getDate("gmt_updated"));
                repertoryOutApply.setSerialnumber(resultSet.getString("serialnumber"));
                repertoryOutApply.setNnlightctlPropertyId(resultSet.getLong("nnlightctl_property_id"));
                repertoryOutApply.setNnlightctlUserId(resultSet.getLong("nnlightctl_user_id"));
                repertoryOutApply.setApplyState(resultSet.getByte("apply_state"));
                repertoryOutApply.setRefuseReason(resultSet.getString("refuse_reason"));
                return repertoryOutApply;
            }
        });
        Tuple.TwoTuple<List<RepertoryOutApply>, Integer> tuple = new Tuple.TwoTuple<>();
        tuple.setFirst(repertoryOutApplyList);
        tuple.setSecond(total);
        return tuple;
    }
    @Override
    public int updateApproveApplyInRepertory(ApproveApplyInRepertoryRequest request){
        StringBuilder sql = new StringBuilder();

        Map<String, Object> params = new HashMap<>(2);
        params.put("applyInRepertoryIds", request.getApplyInRepertoryIds());
        params.put("refuseReason",request.getRefuseReason());
        if (request.getIsApprove()==0){//申请不通过
            sql.append("update nnlightctl_repertory_in_apply set  apply_state = 2 ,refuse_reason = :refuseReason where " +
                    "id in (:applyInRepertoryIds)");
        }else if (request.getIsApprove()==1){//通过
            sql.append("update nnlightctl_repertory_in_apply set  apply_state = 3 where " +
                    "id in (:applyInRepertoryIds)");
        }
        return namedParameterJdbcTemplate.update(sql.toString(), params);
    }

    @Override
    public int updateApproveApplyOutRepertory(ApproveApplyOutRepertoryRequest request){
        StringBuilder sql = new StringBuilder();

        Map<String, Object> params = new HashMap<>(2);
        params.put("applyInRepertoryIds", request.getApplyOutRepertoryIds());
        params.put("refuseReason", request.getRefuseReason());
        if (request.getIsApprove()==0){//申请不通过
            sql.append("update nnlightctl_repertory_out_apply set  apply_state = 2 ,refuse_reason = :refuseReason where " +
                    "id in (:applyInRepertoryIds)");
        }else if (request.getIsApprove()==1){//通过
            sql.append("update nnlightctl_repertory_out_apply set  apply_state = 3 where " +
                    "id in (:applyInRepertoryIds)");
        }
        return namedParameterJdbcTemplate.update(sql.toString(), params);
    }
}
