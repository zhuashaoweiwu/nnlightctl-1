package com.nnlightctl.server.impl;

import com.github.pagehelper.PageHelper;
import com.nnlight.common.ReflectCopyUtil;
import com.nnlight.common.Tuple;
import com.nnlightctl.dao.LamppostMapper;
import com.nnlightctl.po.Lamppost;
import com.nnlightctl.request.LamppostConditionRequest;
import com.nnlightctl.request.LamppostRequest;
import com.nnlightctl.server.LamppostServer;
import com.nnlightctl.vo.LamppostView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class LamppostServerImpl implements LamppostServer {


    @Autowired
    private LamppostMapper lamppostMapper;

    @Override
    public int addOrUpdateLamppost(LamppostRequest request) {

        Lamppost lamppost=new Lamppost();

        ReflectCopyUtil.beanSameFieldCopy(request,lamppost);

        int sign=-1;

        if (request.getId()==null){

            request.setState(0);
            //新增灯杆
            sign=lamppostMapper.insertLamppost(lamppost);
        }else {

            sign=lamppostMapper.updateByPrimaryKeyLamppost(lamppost);
        }
        return sign;
    }

    @Override
    public int deleteLamppost(LamppostConditionRequest request) {
        List<Long> lamppostIds = request.getLamppostIds();

        int sign=-1;

        for (Long lamppostId : lamppostIds) {
            sign= lamppostMapper.deleteByPrimaryKeyLamppost(lamppostId);
        }

        return sign;
    }

    @Override
    public Tuple.TwoTuple<List<LamppostView>, Integer> listLamppost(LamppostConditionRequest request) {

        Tuple.TwoTuple<List<LamppostView>,Integer> listLamppost=new Tuple.TwoTuple<>();

        int total = lamppostMapper.selectByCountLamppost();

        listLamppost.setSecond(total);

        PageHelper.startPage(request.getPageNumber(),request.getPageSize());

        String equipmentNumber = request.getEquipmentNumber();

        Lamppost lamppost=new Lamppost();

        lamppost.setEquipmentNumber(equipmentNumber);

        lamppost.setLamppostModel(request.getLamppostModel());

        lamppost.setLampostName(request.getLampostName());

        List<Lamppost> lampposts = lamppostMapper.selectAllLamppost(lamppost);

        List<LamppostView> lamppostViews=new ArrayList<>();

        for (Lamppost lamppostNew : lampposts) {
            LamppostView lamppostView=new LamppostView();

            ReflectCopyUtil.beanSameFieldCopy(lamppostNew,lamppostView);

            lamppostViews.add(lamppostView);
        }

        listLamppost.setFirst(lamppostViews);
        return listLamppost;
    }

    @Override
    public Lamppost selectLamppostById(LamppostConditionRequest request) {

        Long id = request.getId();

        Lamppost lamppost = lamppostMapper.selectLampById(id);
        return lamppost;
    }
}
