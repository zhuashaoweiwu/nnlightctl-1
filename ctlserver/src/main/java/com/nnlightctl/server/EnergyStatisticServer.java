package com.nnlightctl.server;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.Elebox;
import com.nnlightctl.po.EleboxVolEleRecord;
import com.nnlightctl.po.LightSignalLog;
import com.nnlightctl.po.LightingVolEleRecord;
import com.nnlightctl.request.*;
import com.nnlightctl.vo.CommonEnergyStatisticView;
import com.nnlightctl.vo.GetEleboxEnergyStatisticView;
import com.nnlightctl.vo.ListEleboxEnergyStatisticView;

import java.util.List;

public interface EnergyStatisticServer {
    List<EleboxVolEleRecord> listEleboxPower(EleboxPowerRequest eleboxPowerRequest);
    List<LightingVolEleRecord> listLightingVolEleRecord(LightingVolEleRecordRequest lightingVolEleRecordRequest);
    List<CommonEnergyStatisticView> getCommonEnergyStatistic();
    List<CommonEnergyStatisticView> listEnergyStatisticByDay(int month );
    List<ListEleboxEnergyStatisticView> listEleboxEnergyStatistic(listEleboxEnergyStatisticRequest request);
    List<GetEleboxEnergyStatisticView> getEleboxEnergyStatistic(listEleboxEnergyStatisticRequest request);
    List<LightingVolEleRecord> listStatisticLightEnergy(StatisticLightEnergyRequest request);
    Tuple.TwoTuple<List<LightSignalLog>, Integer> listLightSignalLog(SignalLogRequest request);
}
