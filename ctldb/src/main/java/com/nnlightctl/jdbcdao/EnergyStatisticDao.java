package com.nnlightctl.jdbcdao;

import com.nnlightctl.po.EleboxVolEleRecord;
import com.nnlightctl.request.EleboxPowerRequest;

import java.util.List;

public interface EnergyStatisticDao {

   List<EleboxVolEleRecord> listEleboxPower(EleboxPowerRequest eleboxPowerRequest);
}
