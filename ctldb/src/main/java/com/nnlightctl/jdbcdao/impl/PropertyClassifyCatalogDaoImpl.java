package com.nnlightctl.jdbcdao.impl;

import com.nnlightctl.jdbcdao.PropertyClassifyCatalogDao;
import com.nnlightctl.po.PropertyClassifyCatalog;
import com.nnlightctl.po.RepertoryOutApply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PropertyClassifyCatalogDaoImpl implements PropertyClassifyCatalogDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<PropertyClassifyCatalog> listAllChildren(List<Long> propertyClassifyCatalogIds){
        StringBuilder sql = new StringBuilder();
        StringBuilder countSql = new StringBuilder();
        String propertyClassifyCatelogId = "";
        sql.append("SELECT id ,gmt_created ,gmt_updated ,my_catalog_name ,catalog_level ,nnlightctl_property_classify_catalog_id from nnlightctl_property_classify_catalog where 1=1 ");
        if (propertyClassifyCatalogIds.isEmpty()){
            sql.append("and 1 !=1 ");
        }else {
            for(int i = 0; i < propertyClassifyCatalogIds.size();i++){
                if(i!=( propertyClassifyCatalogIds.size()-1)){
                    propertyClassifyCatelogId +=  propertyClassifyCatalogIds.get(i) + ",";
                }else{
                    propertyClassifyCatelogId +=  propertyClassifyCatalogIds.get(i);
                }
            }
            sql.append(" and nnlightctl_property_classify_catalog_id IN("+propertyClassifyCatelogId+") ");
        }
        List<PropertyClassifyCatalog> repertoryOutApplyList = jdbcTemplate.query(sql.toString(), new RowMapper<PropertyClassifyCatalog>() {
            @Override
            public PropertyClassifyCatalog mapRow(ResultSet resultSet, int i) throws SQLException {
                PropertyClassifyCatalog propertyClassifyCatalog = new PropertyClassifyCatalog();
                propertyClassifyCatalog.setId(resultSet.getLong("id"));
                propertyClassifyCatalog.setGmtCreated(resultSet.getDate("gmt_created"));
                propertyClassifyCatalog.setGmtUpdated(resultSet.getDate("gmt_updated"));
                propertyClassifyCatalog.setMyCatalogName(resultSet.getString("my_catalog_name"));
                propertyClassifyCatalog.setCatalogLevel(resultSet.getByte("catalog_level"));
                propertyClassifyCatalog.setNnlightctlPropertyClassifyCatalogId(resultSet.getLong("nnlightctl_property_classify_catalog_id"));
                return propertyClassifyCatalog;
            }
        });
        return repertoryOutApplyList;
    }
    @Override
    public List<PropertyClassifyCatalog> listPropertyClassifyCatalogLevel1(){
        StringBuilder sql = new StringBuilder();
        StringBuilder countSql = new StringBuilder();
        String propertyClassifyCatelogId = "";
        sql.append("SELECT id ,gmt_created ,gmt_updated ,my_catalog_name ,catalog_level ,nnlightctl_property_classify_catalog_id from nnlightctl_property_classify_catalog where nnlightctl_property_classify_catalog_id is null ");
        List<PropertyClassifyCatalog> repertoryOutApplyList = jdbcTemplate.query(sql.toString(), new RowMapper<PropertyClassifyCatalog>() {
            @Override
            public PropertyClassifyCatalog mapRow(ResultSet resultSet, int i) throws SQLException {
                PropertyClassifyCatalog propertyClassifyCatalog = new PropertyClassifyCatalog();
                propertyClassifyCatalog.setId(resultSet.getLong("id"));
                propertyClassifyCatalog.setGmtCreated(resultSet.getDate("gmt_created"));
                propertyClassifyCatalog.setGmtUpdated(resultSet.getDate("gmt_updated"));
                propertyClassifyCatalog.setMyCatalogName(resultSet.getString("my_catalog_name"));
                propertyClassifyCatalog.setCatalogLevel(resultSet.getByte("catalog_level"));
                propertyClassifyCatalog.setNnlightctlPropertyClassifyCatalogId(resultSet.getLong("nnlightctl_property_classify_catalog_id"));
                return propertyClassifyCatalog;
            }
        });
        return repertoryOutApplyList;
    }
}
