package com.nnlightctl.dao;

import com.nnlightctl.po.WorkOrderHistory;
import com.nnlightctl.po.WorkOrderHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkOrderHistoryMapper {
    int countByExample(WorkOrderHistoryExample example);

    int deleteByExample(WorkOrderHistoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WorkOrderHistory record);

    int insertSelective(WorkOrderHistory record);

    List<WorkOrderHistory> selectByExample(WorkOrderHistoryExample example);

    WorkOrderHistory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WorkOrderHistory record, @Param("example") WorkOrderHistoryExample example);

    int updateByExample(@Param("record") WorkOrderHistory record, @Param("example") WorkOrderHistoryExample example);

    int updateByPrimaryKeySelective(WorkOrderHistory record);

    int updateByPrimaryKey(WorkOrderHistory record);
}