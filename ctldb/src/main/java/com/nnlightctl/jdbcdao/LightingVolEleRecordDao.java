package com.nnlightctl.jdbcdao;

import com.nnlightctl.po.LightingVolEleRecord;
import com.nnlightctl.vo.CommonEnergyStatisticView;

import java.util.List;

public interface LightingVolEleRecordDao {
    int addLightingVolEleRecord(LightingVolEleRecord lightingVolEleRecord);
    //获取昨天能耗
    List<CommonEnergyStatisticView> getCommonEnergyStatisticDate();
    //获取本月能耗
    List<CommonEnergyStatisticView> getCommonEnergyStatisticMouth();
    //获取本年能耗
    List<CommonEnergyStatisticView> getCommonEnergyStatisticYear();
    //按月获取每天的能耗
    List<CommonEnergyStatisticView> listEnergyStatisticByDay(int month );
}
