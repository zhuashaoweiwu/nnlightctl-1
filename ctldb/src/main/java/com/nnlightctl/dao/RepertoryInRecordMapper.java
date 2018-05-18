package com.nnlightctl.dao;

import com.nnlightctl.po.RepertoryInRecord;
import com.nnlightctl.po.RepertoryInRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RepertoryInRecordMapper {
    int countByExample(RepertoryInRecordExample example);

    int deleteByExample(RepertoryInRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RepertoryInRecord record);

    int insertSelective(RepertoryInRecord record);

    List<RepertoryInRecord> selectByExample(RepertoryInRecordExample example);

    RepertoryInRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RepertoryInRecord record, @Param("example") RepertoryInRecordExample example);

    int updateByExample(@Param("record") RepertoryInRecord record, @Param("example") RepertoryInRecordExample example);

    int updateByPrimaryKeySelective(RepertoryInRecord record);

    int updateByPrimaryKey(RepertoryInRecord record);
}