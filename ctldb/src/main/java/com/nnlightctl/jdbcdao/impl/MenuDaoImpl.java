package com.nnlightctl.jdbcdao.impl;

import com.nnlightctl.jdbcdao.MenuDao;
import com.nnlightctl.jdbcmapper.UserMapRightersBatch;
import com.nnlightctl.request.SaveUserMapRightersRequest;
import com.nnlightctl.vo.GetUserWithRighterView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MenuDaoImpl implements MenuDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insertSaveUserMapRighters(SaveUserMapRightersRequest request){
        StringBuilder sqlDelete = new StringBuilder();
        sqlDelete.append("delete from nnlightctl_user_righter_map where nnlightctl_user_id =  ?");
        int ret = jdbcTemplate.update(sqlDelete.toString(), new Object[] {request.getUserId()});
        // return jdbcTemplate.update(sql.toString(), new Object[] {sceneId});
        StringBuilder sqlInsert = new StringBuilder();
        sqlInsert.append("insert into nnlightctl_user_righter_map(gmt_created, gmt_updated, nnlightctl_user_id, nnlightctl_righter_id)values(?, ?, ?, ?)");
        int [] Save = jdbcTemplate.batchUpdate(sqlInsert.toString(), new UserMapRightersBatch(request.getUserId(), request.getRighterIds()));
        return Save.length;
    }
    @Override
    public List<GetUserWithRighterView> getUserWithRighter(Integer userId){
        StringBuilder sql = new StringBuilder();
        List<Object> param = new ArrayList<>(1);
        sql.append("select  nnlightctl_righter_id from nnlightctl_user_righter_map ");
        if (userId != null){
            sql.append(" where nnlightctl_user_id = ? ");
            param.add(userId);
        }
        List<GetUserWithRighterView> projectViewList = jdbcTemplate.query(sql.toString(), param.toArray(), new RowMapper<GetUserWithRighterView>() {
            @Override
            public GetUserWithRighterView mapRow(ResultSet resultSet, int i) throws SQLException {
                GetUserWithRighterView getUserWithRighterView = new GetUserWithRighterView();
                getUserWithRighterView.setRighterId(resultSet.getLong("nnlightctl_righter_id"));
                return getUserWithRighterView;
            }
        });
        return projectViewList;
    }
}
