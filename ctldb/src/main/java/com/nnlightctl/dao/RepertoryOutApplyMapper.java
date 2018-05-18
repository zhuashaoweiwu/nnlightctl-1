package com.nnlightctl.dao;

import com.nnlightctl.po.RepertoryOutApply;
import com.nnlightctl.po.RepertoryOutApplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RepertoryOutApplyMapper {
    int countByExample(RepertoryOutApplyExample example);

    int deleteByExample(RepertoryOutApplyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RepertoryOutApply record);

    int insertSelective(RepertoryOutApply record);

    List<RepertoryOutApply> selectByExample(RepertoryOutApplyExample example);

    RepertoryOutApply selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RepertoryOutApply record, @Param("example") RepertoryOutApplyExample example);

    int updateByExample(@Param("record") RepertoryOutApply record, @Param("example") RepertoryOutApplyExample example);

    int updateByPrimaryKeySelective(RepertoryOutApply record);

    int updateByPrimaryKey(RepertoryOutApply record);
}