package com.nnlightctl.jdbcdao.impl;

import com.nnlight.common.Tuple;
import com.nnlightctl.jdbcdao.RepertoryDao;
import com.nnlightctl.po.Property;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.request.TransferPropertyRequest;
import com.nnlightctl.vo.LightingView;
import com.nnlightctl.vo.ListRepertoryUserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class RepertoryDaoImpl implements RepertoryDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public int transferProperty(TransferPropertyRequest transferPropertyRequest){
        StringBuilder sql = new StringBuilder();

        Map<String, Object> params = new HashMap<>(3);
        params.put("PropertyIds", transferPropertyRequest.getPropertyIds());
        params.put("gmtUpdated",new Date());
        params.put("newRepertoryId",transferPropertyRequest.getNewRepertoryId());
        sql.append("UPDATE nnlightctl_property SET nnlightctl_repertory_id = :newRepertoryId , gmt_updated = :gmtUpdated  where " +
                "id in (:PropertyIds)");

        return namedParameterJdbcTemplate.update(sql.toString(), params);
    }

    public Tuple.TwoTuple<List<ListRepertoryUserView>, Integer> listRepertoryUser(BaseRequest request){
        StringBuilder sql = new StringBuilder();
        StringBuilder countSql = new StringBuilder();
        List<Object> params = new ArrayList<>(1);
        sql.append("SELECT a.id ,a.gmt_created ,a.gmt_updated ,a.uid ,a.repertory_name ,a.repertory_address, a.repertory_phone ,a.repertory_zip_code ,a.nnlightctl_user_id ,b.user_name ,b.phone ,b.email ,b.place  from nnlightctl_repertory a LEFT JOIN nnlightctl_user b on a.nnlightctl_user_id = b.id  ");
        countSql.append("select count(*) from nnlightctl_repertory a LEFT JOIN nnlightctl_user b on a.nnlightctl_user_id = b.id ");

        int total = jdbcTemplate.queryForObject(countSql.toString(),params.toArray(), Integer.class);

        sql.append("order by id DESC ");

        if (request.getPageSize() > 0 && request.getPageNumber() > 0) {
            sql.append("limit ?, ?");
            params.add((request.getPageNumber() - 1) * request.getPageSize());
            params.add(request.getPageSize());
        }
        List<ListRepertoryUserView> listRepertoryUserViews = jdbcTemplate.query(sql.toString(), params.toArray(), new RowMapper<ListRepertoryUserView>() {
            @Override
            public ListRepertoryUserView mapRow(ResultSet resultSet, int i) throws SQLException {
                ListRepertoryUserView listRepertoryUserView = new ListRepertoryUserView();
                listRepertoryUserView.setId(resultSet.getLong("id"));
                listRepertoryUserView.setGmtCreated(resultSet.getDate("gmt_created"));
                listRepertoryUserView.setGmtUpdated(resultSet.getDate("gmt_updated"));
                listRepertoryUserView.setUid(resultSet.getString("uid"));
                listRepertoryUserView.setRepertoryName(resultSet.getString("repertory_name"));
                listRepertoryUserView.setRepertoryAddress(resultSet.getString("repertory_address"));
                listRepertoryUserView.setRepertoryPhone(resultSet.getString("repertory_phone"));
                listRepertoryUserView.setRepertoryZipCode(resultSet.getString("repertory_zip_code"));
                listRepertoryUserView.setNnlightctlUserId(resultSet.getLong("nnlightctl_user_id"));
                listRepertoryUserView.setUserName(resultSet.getString("user_name"));
                listRepertoryUserView.setPhone(resultSet.getString("phone"));
                listRepertoryUserView.setEmail(resultSet.getString("email"));
                listRepertoryUserView.setPlace(resultSet.getString("place"));
                return listRepertoryUserView;
            }
        });
        Tuple.TwoTuple<List<ListRepertoryUserView>, Integer> tuple = new Tuple.TwoTuple<>();
        tuple.setFirst(listRepertoryUserViews);
        tuple.setSecond(total);

        return tuple;
    }

    public Tuple.TwoTuple<List<ListRepertoryUserView>, Integer> getRepertory(Long id){
        StringBuilder sql = new StringBuilder();
        StringBuilder countSql = new StringBuilder();
        List<Object> params = new ArrayList<>(1);
        sql.append("SELECT a.id ,a.gmt_created ,a.gmt_updated ,a.uid ,a.repertory_name ,a.repertory_address, a.repertory_phone ,a.repertory_zip_code ,a.nnlightctl_user_id ,b.user_name ,b.phone ,b.email ,b.place  from nnlightctl_repertory a LEFT JOIN nnlightctl_user b on a.nnlightctl_user_id = b.id where 1=1  ");
        countSql.append("select count(*) from nnlightctl_repertory a LEFT JOIN nnlightctl_user b on a.nnlightctl_user_id = b.id where 1 =1 ");
        if (id != null){
            sql.append(" and a.id = ? ");

            countSql.append(" and a.id = ? ");
            params.add(id);
        }
        int total = jdbcTemplate.queryForObject(countSql.toString(),params.toArray(), Integer.class);

        sql.append("order by id DESC ");
        List<ListRepertoryUserView> listRepertoryUserViews = jdbcTemplate.query(sql.toString(), params.toArray(), new RowMapper<ListRepertoryUserView>() {
            @Override
            public ListRepertoryUserView mapRow(ResultSet resultSet, int i) throws SQLException {
                ListRepertoryUserView listRepertoryUserView = new ListRepertoryUserView();
                listRepertoryUserView.setId(resultSet.getLong("id"));
                listRepertoryUserView.setGmtCreated(resultSet.getDate("gmt_created"));
                listRepertoryUserView.setGmtUpdated(resultSet.getDate("gmt_updated"));
                listRepertoryUserView.setUid(resultSet.getString("uid"));
                listRepertoryUserView.setRepertoryName(resultSet.getString("repertory_name"));
                listRepertoryUserView.setRepertoryAddress(resultSet.getString("repertory_address"));
                listRepertoryUserView.setRepertoryPhone(resultSet.getString("repertory_phone"));
                listRepertoryUserView.setRepertoryZipCode(resultSet.getString("repertory_zip_code"));
                listRepertoryUserView.setNnlightctlUserId(resultSet.getLong("nnlightctl_user_id"));
                listRepertoryUserView.setUserName(resultSet.getString("user_name"));
                listRepertoryUserView.setPhone(resultSet.getString("phone"));
                listRepertoryUserView.setEmail(resultSet.getString("email"));
                listRepertoryUserView.setPlace(resultSet.getString("place"));
                return listRepertoryUserView;
            }
        });
        Tuple.TwoTuple<List<ListRepertoryUserView>, Integer> tuple = new Tuple.TwoTuple<>();
        tuple.setFirst(listRepertoryUserViews);
        tuple.setSecond(total);

        return tuple;
    }

    public Long countApplyInRepertory(){
        StringBuilder countSql = new StringBuilder();
        countSql.append("SELECT count(*) from nnlightctl_repertory_in_apply ");
        Long total = jdbcTemplate.queryForObject(countSql.toString(), long.class);
        return total;
    }

    public Long countApplyOutRepertory(){
        StringBuilder countSql = new StringBuilder();
        countSql.append("SELECT COUNT(*) from nnlightctl_repertory_out_apply ");
        Long total = jdbcTemplate.queryForObject(countSql.toString(), long.class);
        return total;
    }
}
