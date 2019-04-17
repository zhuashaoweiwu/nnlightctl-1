package com.nnlightctl.dao;

import com.nnlightctl.po.RepertoryOutRecord;
import com.nnlightctl.po.RepertoryOutRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RepertoryOutRecordMapper {
    int countByExample(RepertoryOutRecordExample example);

    int deleteByExample(RepertoryOutRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RepertoryOutRecord record);

    int insertSelective(RepertoryOutRecord record);

    List<RepertoryOutRecord> selectByExample(RepertoryOutRecordExample example);

    RepertoryOutRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RepertoryOutRecord record, @Param("example") RepertoryOutRecordExample example);

    int updateByExample(@Param("record") RepertoryOutRecord record, @Param("example") RepertoryOutRecordExample example);

    int updateByPrimaryKeySelective(RepertoryOutRecord record);

    int updateByPrimaryKey(RepertoryOutRecord record);
}