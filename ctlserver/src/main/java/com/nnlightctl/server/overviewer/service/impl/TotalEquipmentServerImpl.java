package com.nnlightctl.server.overviewer.service.impl;

import com.nnlightctl.dao.EleboxMapper;
import com.nnlightctl.po.EleboxExample;
import com.nnlightctl.server.overviewer.service.TotalEquipmentServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class TotalEquipmentServerImpl implements TotalEquipmentServer {

    @Autowired
    private EleboxMapper eleboxMapper;
    @Override
    public Map totalEquipment() {

        //集中控制器
        int centralizeControllerNumber = eleboxMapper.selectCentralizeController();

        //灯具
        int LightModelNumber = eleboxMapper.selectLightModel();

        //开关模块
        int ModularNumber = eleboxMapper.selectModular();

        //光照计
        int PhotoriodNumber=eleboxMapper.selectPhotoperiod();

        //控制柜
        int EleboxNumber=eleboxMapper.countByExample(new EleboxExample());

        //灯杆
        int LamppostNumber=eleboxMapper.selectLamppost();

        //电表
        int ElectricityNumber=eleboxMapper.selectElectricityMeter();

        //单灯控制器
        int LampControllerNumber=eleboxMapper.selectLampController();


        Map<String,Integer> total=new HashMap<>(8);

        total.put("centralizeController",centralizeControllerNumber);

        total.put("lightModel",LightModelNumber);

        total.put("modular",ModularNumber);

        total.put("photoriod",PhotoriodNumber);

        total.put("elebox",EleboxNumber);

        total.put("lamppost",LamppostNumber);

        total.put("electricity",ElectricityNumber);

        total.put("lampController",LampControllerNumber);


        return total;
    }
}
