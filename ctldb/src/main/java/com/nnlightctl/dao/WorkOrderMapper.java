package com.nnlightctl.dao;

import com.nnlightctl.po.WorkOrder;
import com.nnlightctl.po.WorkOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkOrderMapper {
    int countByExample(WorkOrderExample example);

    int deleteByExample(WorkOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WorkOrder record);

    int insertSelective(WorkOrder record);

    List<WorkOrder> selectByExample(WorkOrderExample example);

    WorkOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WorkOrder record, @Param("example") WorkOrderExample example);

    int updateByExample(@Param("record") WorkOrder record, @Param("example") WorkOrderExample example);

    int updateByPrimaryKeySelective(WorkOrder record);

    int updateByPrimaryKey(WorkOrder record);
}