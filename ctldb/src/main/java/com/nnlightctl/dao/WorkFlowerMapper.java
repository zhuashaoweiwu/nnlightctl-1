package com.nnlightctl.dao;

import com.nnlightctl.po.WorkFlower;
import com.nnlightctl.po.WorkFlowerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkFlowerMapper {
    int countByExample(WorkFlowerExample example);

    int deleteByExample(WorkFlowerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WorkFlower record);

    int insertSelective(WorkFlower record);

    List<WorkFlower> selectByExample(WorkFlowerExample example);

    WorkFlower selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WorkFlower record, @Param("example") WorkFlowerExample example);

    int updateByExample(@Param("record") WorkFlower record, @Param("example") WorkFlowerExample example);

    int updateByPrimaryKeySelective(WorkFlower record);

    int updateByPrimaryKey(WorkFlower record);
}