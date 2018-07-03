package com.nnlightctl.server.impl;

import com.nnlightctl.jdbcdao.EnergyStatisticDao;
import com.nnlightctl.po.EleboxVolEleRecord;
import com.nnlightctl.po.LightingVolEleRecord;
import com.nnlightctl.request.EleboxPowerRequest;
import com.nnlightctl.server.EnergyStatisticServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nnlightctl.request.LightingVolEleRecordRequest;

import java.util.List;

@Service
public class EnergyStatisticServerImpl implements EnergyStatisticServer {

    @Autowired
    private EnergyStatisticDao energyStatisticDao;

    @Override
    public List<EleboxVolEleRecord> listEleboxPower(EleboxPowerRequest eleboxPowerRequest){
        return energyStatisticDao.listEleboxPower(eleboxPowerRequest);
    }
    @Override
    public List<LightingVolEleRecord> listLightingVolEleRecord(LightingVolEleRecordRequest lightingVolEleRecordRequest){
        return energyStatisticDao.listLightingVolEleRecord(lightingVolEleRecordRequest);
    }
}
