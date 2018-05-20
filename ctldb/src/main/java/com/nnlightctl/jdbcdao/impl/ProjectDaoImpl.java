package com.nnlightctl.jdbcdao.impl;

import com.nnlightctl.jdbcdao.ProjectDao;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.vo.ProjectView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProjectDaoImpl implements ProjectDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<ProjectView> listProject(BaseRequest request) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Object> param = new ArrayList<>(2);

        stringBuilder.append("select p.id, p.gmt_created, p.gmt_updated, p.code_number, p.project_name, p.ctype, c.country_name, pp.province_name, cc.city_name, p.longitude, p.latitude, p.mem, p.state ");
        stringBuilder.append("from nnlightctl_project p ");
        stringBuilder.append("left join nnlightctl_project_country c on p.nnlightctl_project_country_id = c.id ");
        stringBuilder.append("left join nnlightctl_project_province pp on p.nnlightctl_project_province_id  = pp.id ");
        stringBuilder.append("left join nnlightctl_project_city cc on p.nnlightctl_project_city_id = cc.id ");
        stringBuilder.append("order by id DESC ");
        if (request.getPageSize() > 0 && request.getPageNumber() > 0) {
            stringBuilder.append("limit ?, ?");
            param.add((request.getPageNumber() - 1) * request.getPageSize());
            param.add(request.getPageSize());
        }
        List<ProjectView> projectViewList = jdbcTemplate.query(stringBuilder.toString(), param.toArray(), new RowMapper<ProjectView>() {
            @Override
            public ProjectView mapRow(ResultSet resultSet, int i) throws SQLException {
                ProjectView projectView = new ProjectView();
                projectView.setId(resultSet.getLong("id"));
                projectView.setGmtCreated(resultSet.getDate("gmt_created"));
                projectView.setGmtUpdated(resultSet.getDate("gmt_updated"));
                projectView.setCodeNumber(resultSet.getString("code_number"));
                projectView.setProjectName(resultSet.getString("project_name"));
                projectView.setType(resultSet.getInt("ctype"));
                projectView.setContryName(resultSet.getString("country_name"));
                projectView.setProvinceName(resultSet.getString("province_name"));
                projectView.setCityName(resultSet.getString("city_name"));
                projectView.setLongitude(resultSet.getString("longitude"));
                projectView.setLatitude(resultSet.getString("latitude"));
                projectView.setMem(resultSet.getString("mem"));
                projectView.setState(resultSet.getInt("state"));
                return projectView;
            }
        });
        return projectViewList;
    }
}
