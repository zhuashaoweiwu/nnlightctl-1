package com.nnlightctl.dao;

import com.nnlightctl.po.RepairRecord;
import com.nnlightctl.po.RepairRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RepairRecordMapper {
    int countByExample(RepairRecordExample example);

    int deleteByExample(RepairRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RepairRecord record);

    int insertSelective(RepairRecord record);

    List<RepairRecord> selectByExample(RepairRecordExample example);

    RepairRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RepairRecord record, @Param("example") RepairRecordExample example);

    int updateByExample(@Param("record") RepairRecord record, @Param("example") RepairRecordExample example);

    int updateByPrimaryKeySelective(RepairRecord record);

    int updateByPrimaryKey(RepairRecord record);
}