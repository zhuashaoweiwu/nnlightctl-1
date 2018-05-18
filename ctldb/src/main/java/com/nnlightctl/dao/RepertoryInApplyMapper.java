package com.nnlightctl.dao;

import com.nnlightctl.po.RepertoryInApply;
import com.nnlightctl.po.RepertoryInApplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RepertoryInApplyMapper {
    int countByExample(RepertoryInApplyExample example);

    int deleteByExample(RepertoryInApplyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RepertoryInApply record);

    int insertSelective(RepertoryInApply record);

    List<RepertoryInApply> selectByExample(RepertoryInApplyExample example);

    RepertoryInApply selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RepertoryInApply record, @Param("example") RepertoryInApplyExample example);

    int updateByExample(@Param("record") RepertoryInApply record, @Param("example") RepertoryInApplyExample example);

    int updateByPrimaryKeySelective(RepertoryInApply record);

    int updateByPrimaryKey(RepertoryInApply record);
}