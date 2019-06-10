package com.nnlightctl.dao;

import com.nnlightctl.po.SwitchTaskInfo;
import com.nnlightctl.vo.SceneView;
import com.nnlightctl.vo.SwitchTaskInfoView;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface SwitchTaskInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SwitchTaskInfo record);

    int insertSelective(SwitchTaskInfo record);

    SwitchTaskInfo selectByPrimaryKey(Long id);

    List<SwitchTaskInfoView> selectByTaskId(@Param("taskId") Long taskId);

    int updateByPrimaryKeySelective(SwitchTaskInfo record);

    int updateByPrimaryKey(SwitchTaskInfo record);

    int selectCountByTaskId(@Param("taskIds")List<Long> ids);

    int deleteByTaskId(@Param("taskInfoIds")List<Long> ids,@Param("taskId") Long taskId);

}