package com.nnlightctl.dao;

import com.nnlightctl.po.RepairRecordAutoCommit;
import com.nnlightctl.po.RepairRecordAutoCommitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RepairRecordAutoCommitMapper {
    int countByExample(RepairRecordAutoCommitExample example);

    int deleteByExample(RepairRecordAutoCommitExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RepairRecordAutoCommit record);

    int insertSelective(RepairRecordAutoCommit record);

    List<RepairRecordAutoCommit> selectByExample(RepairRecordAutoCommitExample example);

    RepairRecordAutoCommit selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RepairRecordAutoCommit record, @Param("example") RepairRecordAutoCommitExample example);

    int updateByExample(@Param("record") RepairRecordAutoCommit record, @Param("example") RepairRecordAutoCommitExample example);

    int updateByPrimaryKeySelective(RepairRecordAutoCommit record);

    int updateByPrimaryKey(RepairRecordAutoCommit record);
}