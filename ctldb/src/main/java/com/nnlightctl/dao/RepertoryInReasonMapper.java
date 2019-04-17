package com.nnlightctl.dao;

import com.nnlightctl.po.RepertoryInReason;
import com.nnlightctl.po.RepertoryInReasonExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RepertoryInReasonMapper {
    int countByExample(RepertoryInReasonExample example);

    int deleteByExample(RepertoryInReasonExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RepertoryInReason record);

    int insertSelective(RepertoryInReason record);

    List<RepertoryInReason> selectByExample(RepertoryInReasonExample example);

    RepertoryInReason selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RepertoryInReason record, @Param("example") RepertoryInReasonExample example);

    int updateByExample(@Param("record") RepertoryInReason record, @Param("example") RepertoryInReasonExample example);

    int updateByPrimaryKeySelective(RepertoryInReason record);

    int updateByPrimaryKey(RepertoryInReason record);
}