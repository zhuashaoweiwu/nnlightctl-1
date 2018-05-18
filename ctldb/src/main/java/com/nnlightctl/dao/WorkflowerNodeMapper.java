package com.nnlightctl.dao;

import com.nnlightctl.po.WorkflowerNode;
import com.nnlightctl.po.WorkflowerNodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkflowerNodeMapper {
    int countByExample(WorkflowerNodeExample example);

    int deleteByExample(WorkflowerNodeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WorkflowerNode record);

    int insertSelective(WorkflowerNode record);

    List<WorkflowerNode> selectByExample(WorkflowerNodeExample example);

    WorkflowerNode selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WorkflowerNode record, @Param("example") WorkflowerNodeExample example);

    int updateByExample(@Param("record") WorkflowerNode record, @Param("example") WorkflowerNodeExample example);

    int updateByPrimaryKeySelective(WorkflowerNode record);

    int updateByPrimaryKey(WorkflowerNode record);
}