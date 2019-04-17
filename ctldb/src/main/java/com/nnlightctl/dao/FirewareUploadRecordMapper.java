package com.nnlightctl.dao;

import com.nnlightctl.po.FirewareUploadRecord;
import com.nnlightctl.po.FirewareUploadRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FirewareUploadRecordMapper {
    int countByExample(FirewareUploadRecordExample example);

    int deleteByExample(FirewareUploadRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FirewareUploadRecord record);

    int insertSelective(FirewareUploadRecord record);

    List<FirewareUploadRecord> selectByExample(FirewareUploadRecordExample example);

    FirewareUploadRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FirewareUploadRecord record, @Param("example") FirewareUploadRecordExample example);

    int updateByExample(@Param("record") FirewareUploadRecord record, @Param("example") FirewareUploadRecordExample example);

    int updateByPrimaryKeySelective(FirewareUploadRecord record);

    int updateByPrimaryKey(FirewareUploadRecord record);
}