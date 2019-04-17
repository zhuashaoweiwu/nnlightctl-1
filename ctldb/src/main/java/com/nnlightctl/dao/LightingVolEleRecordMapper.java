package com.nnlightctl.dao;

import com.nnlightctl.po.LightingVolEleRecord;
import com.nnlightctl.po.LightingVolEleRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LightingVolEleRecordMapper {
    int countByExample(LightingVolEleRecordExample example);

    int deleteByExample(LightingVolEleRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LightingVolEleRecord record);

    int insertSelective(LightingVolEleRecord record);

    List<LightingVolEleRecord> selectByExample(LightingVolEleRecordExample example);

    LightingVolEleRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LightingVolEleRecord record, @Param("example") LightingVolEleRecordExample example);

    int updateByExample(@Param("record") LightingVolEleRecord record, @Param("example") LightingVolEleRecordExample example);

    int updateByPrimaryKeySelective(LightingVolEleRecord record);

    int updateByPrimaryKey(LightingVolEleRecord record);
}