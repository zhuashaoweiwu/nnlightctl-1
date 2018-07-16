package com.nnlightctl.jdbcdao;

import com.nnlightctl.po.EleboxVolEleRecord;
import com.nnlightctl.po.LightingVolEleRecord;
import com.nnlightctl.request.EleboxPowerRequest;
import com.nnlightctl.request.LightingVolEleRecordRequest;
import com.nnlightctl.request.listEleboxEnergyStatisticRequest;
import com.nnlightctl.vo.CommonEnergyStatisticView;
import com.nnlightctl.vo.GetEleboxEnergyStatisticView;
import com.nnlightctl.vo.ListEleboxEnergyStatisticView;

import java.util.List;

public interface EnergyStatisticDao {

   List<EleboxVolEleRecord> listEleboxPower(EleboxPowerRequest eleboxPowerRequest);
   List<LightingVolEleRecord> listLightingVolEleRecord(LightingVolEleRecordRequest lightingVolEleRecordRequest);
   List<CommonEnergyStatisticView> getCommonEnergyStatisticYear();
   List<CommonEnergyStatisticView> getCommonEnergyStatisticMouth();
   List<CommonEnergyStatisticView> getCommonEnergyStatisticDate();
   List<CommonEnergyStatisticView> listEnergyStatisticByDay(int month );
   List<ListEleboxEnergyStatisticView> listEleboxEnergyStatistic(listEleboxEnergyStatisticRequest request);
   List<GetEleboxEnergyStatisticView> getEleboxEnergyStatistic(listEleboxEnergyStatisticRequest request);
}
