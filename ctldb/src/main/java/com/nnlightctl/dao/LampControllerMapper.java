package com.nnlightctl.dao;

import com.nnlightctl.parameter.LampControllerParameter;
import com.nnlightctl.po.LampController;
import org.apache.ibatis.annotations.Param;


import java.util.List;
import java.util.Map;

public interface LampControllerMapper {

    int insert(LampController lampController);

    int updateByPrimaryKey(LampController lampController);

    int deleteByPrimaryKey(Long id);

    int selectByCount();

    List<LampController> selectAll(@Param("params") LampController lampController);

    LampController selectById(@Param("id") Long id);

    List<LampController> selectByParameter(@Param("params")LampControllerParameter parameter);

    int updateByEleboxId(@Param("eleboxId") Long eleboxId);

    List<String> queryLightingByLoop(@Param("loopId") Long loopId);


}