package com.nnlightctl.dao;

import com.nnlightctl.parameter.LampControllerParameter;
import com.nnlightctl.po.LampController;
import com.nnlightctl.vo.DeployLightingView;
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

    LampController selectByPrimaryKey(@Param("id")Long id);

    int updateByEleboxId(@Param("eleboxId") Long eleboxId);

    List<String> queryLightingByLoop(@Param("loopId") Long loopId);

    List<Map<String,Object>> queryLightingUnLoop();

    List<DeployLightingView> selectByExampleDeployLighting(@Param("params") LampController lampController);

    List<LampController> selectByLampModel(@Param("lampModel") String lampModel);

    DeployLightingView selectByIdDeployLighting(@Param("id") Long id);

    /**
     * 通过id修改状态
     */
    int updateByDeployLightingState(@Param("id") Long id);

    List<LampController> queryLightingInfoByLoop(@Param("loopId") Long loopId);

    List<String> getAllEquipmentNumber();

    int selectCountByImei(@Param("imei") String imei);

    List<Map<String,Object>> queryLightingByProject (@Param("projectId") Long projectId,@Param("groupId") Long groupId);


}