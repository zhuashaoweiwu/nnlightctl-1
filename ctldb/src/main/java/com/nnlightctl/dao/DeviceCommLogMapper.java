package com.nnlightctl.dao;

import com.nnlightctl.po.DeviceCommLog;
import com.nnlightctl.po.DeviceCommLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeviceCommLogMapper {
    int countByExample(DeviceCommLogExample example);

    int deleteByExample(DeviceCommLogExample example);

    int insert(DeviceCommLog record);

    int insertSelective(DeviceCommLog record);

    List<DeviceCommLog> selectByExampleWithBLOBs(DeviceCommLogExample example);

    List<DeviceCommLog> selectByExample(DeviceCommLogExample example);

    int updateByExampleSelective(@Param("record") DeviceCommLog record, @Param("example") DeviceCommLogExample example);

    int updateByExampleWithBLOBs(@Param("record") DeviceCommLog record, @Param("example") DeviceCommLogExample example);

    int updateByExample(@Param("record") DeviceCommLog record, @Param("example") DeviceCommLogExample example);
}