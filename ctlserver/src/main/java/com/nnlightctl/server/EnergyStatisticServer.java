package com.nnlightctl.server;

import com.nnlightctl.po.EleboxVolEleRecord;
import com.nnlightctl.request.EleboxPowerRequest;

import java.util.List;

public interface EnergyStatisticServer {

    List<EleboxVolEleRecord> listEleboxPower(EleboxPowerRequest eleboxPowerRequest);
}
