package com.nnlightctl.dao;

import com.nnlightctl.po.WorkflowerMoveRecord;
import com.nnlightctl.po.WorkflowerMoveRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkflowerMoveRecordMapper {
    int countByExample(WorkflowerMoveRecordExample example);

    int deleteByExample(WorkflowerMoveRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WorkflowerMoveRecord record);

    int insertSelective(WorkflowerMoveRecord record);

    List<WorkflowerMoveRecord> selectByExample(WorkflowerMoveRecordExample example);

    WorkflowerMoveRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WorkflowerMoveRecord record, @Param("example") WorkflowerMoveRecordExample example);

    int updateByExample(@Param("record") WorkflowerMoveRecord record, @Param("example") WorkflowerMoveRecordExample example);

    int updateByPrimaryKeySelective(WorkflowerMoveRecord record);

    int updateByPrimaryKey(WorkflowerMoveRecord record);
}