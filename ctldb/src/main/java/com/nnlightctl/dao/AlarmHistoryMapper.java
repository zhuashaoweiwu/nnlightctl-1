package com.nnlightctl.dao;

import com.nnlightctl.po.AlarmHistory;
import com.nnlightctl.po.AlarmHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AlarmHistoryMapper {
    int countByExample(AlarmHistoryExample example);

    int deleteByExample(AlarmHistoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AlarmHistory record);

    int insertSelective(AlarmHistory record);

    List<AlarmHistory> selectByExample(AlarmHistoryExample example);

    AlarmHistory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AlarmHistory record, @Param("example") AlarmHistoryExample example);

    int updateByExample(@Param("record") AlarmHistory record, @Param("example") AlarmHistoryExample example);

    int updateByPrimaryKeySelective(AlarmHistory record);

    int updateByPrimaryKey(AlarmHistory record);
}