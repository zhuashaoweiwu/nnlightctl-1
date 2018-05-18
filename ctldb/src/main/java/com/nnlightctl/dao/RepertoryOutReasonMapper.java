package com.nnlightctl.dao;

import com.nnlightctl.po.RepertoryOutReason;
import com.nnlightctl.po.RepertoryOutReasonExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RepertoryOutReasonMapper {
    int countByExample(RepertoryOutReasonExample example);

    int deleteByExample(RepertoryOutReasonExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RepertoryOutReason record);

    int insertSelective(RepertoryOutReason record);

    List<RepertoryOutReason> selectByExample(RepertoryOutReasonExample example);

    RepertoryOutReason selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RepertoryOutReason record, @Param("example") RepertoryOutReasonExample example);

    int updateByExample(@Param("record") RepertoryOutReason record, @Param("example") RepertoryOutReasonExample example);

    int updateByPrimaryKeySelective(RepertoryOutReason record);

    int updateByPrimaryKey(RepertoryOutReason record);
}