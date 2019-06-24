package com.nnlightctl.dao;

import com.nnlightctl.po.CentralizeController;
import com.nnlightctl.po.CentralizeControllerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CentralizeControllerMapper {
    long countByExample(CentralizeControllerExample example);

    int deleteByExample(CentralizeControllerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CentralizeController record);

    int insertSelective(CentralizeController record);

    List<CentralizeController> selectByExample(CentralizeControllerExample example);

    CentralizeController selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CentralizeController record, @Param("example") CentralizeControllerExample example);

    int updateByExample(@Param("record") CentralizeController record, @Param("example") CentralizeControllerExample example);

    int updateByPrimaryKeySelective(CentralizeController record);

    int updateByPrimaryKey(CentralizeController record);

    List<String> listEquipmentNumber();
}