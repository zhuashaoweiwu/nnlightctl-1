package com.nnlightctl.server.impl;

import com.nnlightctl.dao.EleboxMapper;
import com.nnlightctl.jdbcdao.EnergyStatisticDao;
import com.nnlightctl.po.Elebox;
import com.nnlightctl.po.EleboxModel;
import com.nnlightctl.po.EleboxVolEleRecord;
import com.nnlightctl.po.LightingVolEleRecord;
import com.nnlightctl.request.EleboxPowerRequest;
import com.nnlightctl.request.listEleboxEnergyStatisticRequest;
import com.nnlightctl.server.EnergyStatisticServer;
import com.nnlightctl.vo.CommonEnergyStatisticView;
import com.nnlightctl.vo.GetEleboxEnergyStatisticView;
import com.nnlightctl.vo.ListEleboxEnergyStatisticView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nnlightctl.request.LightingVolEleRecordRequest;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnergyStatisticServerImpl implements EnergyStatisticServer {

    @Autowired
    private EnergyStatisticDao energyStatisticDao;
    @Autowired
    private EleboxMapper eleboxMapper;

    @Override
    public List<EleboxVolEleRecord> listEleboxPower(EleboxPowerRequest eleboxPowerRequest){
        Long id = eleboxPowerRequest.getEleboxId();
        Elebox elebox = eleboxMapper.selectByPrimaryKey(id);
        if (elebox != null){
            eleboxPowerRequest.setUid(elebox.getUid());
        }
        return energyStatisticDao.listEleboxPower(eleboxPowerRequest);
    }
    @Override
    public List<LightingVolEleRecord> listLightingVolEleRecord(LightingVolEleRecordRequest lightingVolEleRecordRequest){
        return energyStatisticDao.listLightingVolEleRecord(lightingVolEleRecordRequest);
    }
    @Override
    public List<CommonEnergyStatisticView> getCommonEnergyStatistic(){
        List<CommonEnergyStatisticView> dateTotal = energyStatisticDao.getCommonEnergyStatisticDate();
        List<CommonEnergyStatisticView> mouthTotal = energyStatisticDao.getCommonEnergyStatisticMouth();
        List<CommonEnergyStatisticView> yearTotal = energyStatisticDao.getCommonEnergyStatisticYear();
        List<CommonEnergyStatisticView> list = new ArrayList<>();
        list.addAll(dateTotal);
        list.addAll(mouthTotal);
        list.addAll(yearTotal);
        return list;
    }
    @Override
    public List<CommonEnergyStatisticView> listEnergyStatisticByDay(int month ){
        return energyStatisticDao.listEnergyStatisticByDay(month);
    }
    @Override
    public List<ListEleboxEnergyStatisticView> listEleboxEnergyStatistic(listEleboxEnergyStatisticRequest request){
        return energyStatisticDao.listEleboxEnergyStatistic(request);
    }

    @Override
    public List<GetEleboxEnergyStatisticView> getEleboxEnergyStatistic(listEleboxEnergyStatisticRequest request){
        return energyStatisticDao.getEleboxEnergyStatistic(request);
    }
}
