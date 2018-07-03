package com.nnlightctl.server;

import com.nnlightctl.po.EleboxVolEleRecord;
import com.nnlightctl.po.LightingVolEleRecord;
import com.nnlightctl.request.EleboxPowerRequest;
import com.nnlightctl.request.LightingVolEleRecordRequest;

import java.util.List;

public interface EnergyStatisticServer {

    List<EleboxVolEleRecord> listEleboxPower(EleboxPowerRequest eleboxPowerRequest);
    List<LightingVolEleRecord> listLightingVolEleRecord(LightingVolEleRecordRequest lightingVolEleRecordRequest);
}
