package com.nnlightctl.dao;

import com.nnlightctl.parameter.LampControllerParameter;
import com.nnlightctl.po.LampController;
import com.nnlightctl.po.Lighting;
import com.nnlightctl.request.LampControllerConditionRequest;
import com.nnlightctl.vo.DeployLightingView;
import com.nnlightctl.vo.LampControllerView;
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

    List<Map<String,Object>> queryLightingUnLoop();

    List<DeployLightingView> selectByExampleDeployLighting(@Param("equipmentNumber") String equipmentNumber);

    List<LampController> selectByLampModel(@Param("lampModel") String lampModel);

    DeployLightingView selectByIdDeployLighting(@Param("id") Long id);

    /**
     * 通过id修改状态
     */
    int updateByDeployLightingState(@Param("id") Long id);



}