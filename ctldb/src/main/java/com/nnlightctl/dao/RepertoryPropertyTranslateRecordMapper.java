package com.nnlightctl.dao;

import com.nnlightctl.po.RepertoryPropertyTranslateRecord;
import com.nnlightctl.po.RepertoryPropertyTranslateRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RepertoryPropertyTranslateRecordMapper {
    int countByExample(RepertoryPropertyTranslateRecordExample example);

    int deleteByExample(RepertoryPropertyTranslateRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RepertoryPropertyTranslateRecord record);

    int insertSelective(RepertoryPropertyTranslateRecord record);

    List<RepertoryPropertyTranslateRecord> selectByExample(RepertoryPropertyTranslateRecordExample example);

    RepertoryPropertyTranslateRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RepertoryPropertyTranslateRecord record, @Param("example") RepertoryPropertyTranslateRecordExample example);

    int updateByExample(@Param("record") RepertoryPropertyTranslateRecord record, @Param("example") RepertoryPropertyTranslateRecordExample example);

    int updateByPrimaryKeySelective(RepertoryPropertyTranslateRecord record);

    int updateByPrimaryKey(RepertoryPropertyTranslateRecord record);
}