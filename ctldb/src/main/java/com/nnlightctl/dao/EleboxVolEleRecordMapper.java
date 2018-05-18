package com.nnlightctl.dao;

import com.nnlightctl.po.EleboxVolEleRecord;
import com.nnlightctl.po.EleboxVolEleRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EleboxVolEleRecordMapper {
    int countByExample(EleboxVolEleRecordExample example);

    int deleteByExample(EleboxVolEleRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(EleboxVolEleRecord record);

    int insertSelective(EleboxVolEleRecord record);

    List<EleboxVolEleRecord> selectByExample(EleboxVolEleRecordExample example);

    EleboxVolEleRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") EleboxVolEleRecord record, @Param("example") EleboxVolEleRecordExample example);

    int updateByExample(@Param("record") EleboxVolEleRecord record, @Param("example") EleboxVolEleRecordExample example);

    int updateByPrimaryKeySelective(EleboxVolEleRecord record);

    int updateByPrimaryKey(EleboxVolEleRecord record);
}