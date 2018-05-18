package com.nnlightctl.dao;

import com.nnlightctl.po.Righter;
import com.nnlightctl.po.RighterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RighterMapper {
    int countByExample(RighterExample example);

    int deleteByExample(RighterExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Righter record);

    int insertSelective(Righter record);

    List<Righter> selectByExample(RighterExample example);

    Righter selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Righter record, @Param("example") RighterExample example);

    int updateByExample(@Param("record") Righter record, @Param("example") RighterExample example);

    int updateByPrimaryKeySelective(Righter record);

    int updateByPrimaryKey(Righter record);
}