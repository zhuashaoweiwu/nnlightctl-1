package com.nnlightctl.server.impl;

import com.github.pagehelper.PageHelper;
import com.nnlight.common.ReflectCopyUtil;
import com.nnlight.common.Tuple;
import com.nnlightctl.dao.ElectricityMeterMapper;
import com.nnlightctl.parameter.ElectricityMeterParameter;
import com.nnlightctl.po.ElectricityMeter;
import com.nnlightctl.po.ElectricityMeterExample;
import com.nnlightctl.request.ElectricityMeterConditionRequest;
import com.nnlightctl.request.ElectricityMeterRequest;
import com.nnlightctl.server.ElectricityMeterServer;
import com.nnlightctl.vo.ElectricityMeterView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class ElectricityMeterServerImpl implements ElectricityMeterServer {


    @Autowired
    private ElectricityMeterMapper electricityMeterMapper;

    private int flag=-1;

    @Override
    public int addOrUpdateElectricityMeter(ElectricityMeterRequest request) {

        if (request==null){
            throw new RuntimeException("提交信息数据为空");
        }

        ElectricityMeter electricityMeter=new ElectricityMeter();

        ReflectCopyUtil.beanSameFieldCopy(request,electricityMeter);

        if (request.getId()==null){
            //新增
            flag = electricityMeterMapper.insertSelective(electricityMeter);

        }else {
            //修改
            flag=electricityMeterMapper.updateByPrimaryKeySelective(electricityMeter);
        }

        return flag;

    }

    @Override
    public int deleteElectricityMeter(ElectricityMeterConditionRequest request) {

        List<Long> electricityMeterIds = request.getElectricityMeterIds();

        for (Long electricityMeterId : electricityMeterIds) {

            flag= electricityMeterMapper.deleteByPrimaryKey(electricityMeterId);
        }


        return flag;
    }

    @Override
    public Tuple.TwoTuple<List<ElectricityMeterView>, Integer> listElectricityMeter(ElectricityMeterConditionRequest request) {

        Tuple.TwoTuple<List<ElectricityMeterView>,Integer> listElectricityMeter=new Tuple.TwoTuple<>();

        ElectricityMeterExample electricityMeterExample=new ElectricityMeterExample();

        ElectricityMeterExample.Criteria criteria = electricityMeterExample.createCriteria();


        if (!StringUtils.isEmpty(request.getEquipmentNumber())) {
            criteria.andequipmentNumberLike("%" + request.getEquipmentNumber() + "%");
        }

         if (!StringUtils.isEmpty(request.getElectricityModel())){

             criteria.andElectricityModelLike("%"+request.getElectricityModel()+"%");

         }

         if (!StringUtils.isEmpty(request.getElectricityName())){

             criteria.andElectricityNameLike("%"+request.getEquipmentNumber()+"%");
         }

        List<ElectricityMeterView> electricityMeterViews=new ArrayList<>(7);

        Long countByExample = electricityMeterMapper.countByExample(electricityMeterExample);

        int total=countByExample.intValue();

        listElectricityMeter.setSecond(total);

        PageHelper.startPage(request.getPageNumber(),request.getPageSize());

        List<ElectricityMeter> electricityMeters = electricityMeterMapper.selectByExample(electricityMeterExample);

        for (ElectricityMeter electricityMeter : electricityMeters) {

            ElectricityMeterView electricityMeterView=new ElectricityMeterView();

            ReflectCopyUtil.beanSameFieldCopy(electricityMeter,electricityMeterView);

            electricityMeterViews.add(electricityMeterView);
        }

        listElectricityMeter.setFirst(electricityMeterViews);


        return listElectricityMeter;
    }

    @Override
    public ElectricityMeter selectByPrimarykey(ElectricityMeterConditionRequest request) {

        Long id = request.getId();

        ElectricityMeter electricityMeter = electricityMeterMapper.selectByPrimaryKey(id);

        return electricityMeter;


    }

    @Override
    public List<ElectricityMeter> selectByParams(ElectricityMeterConditionRequest request) {

        ElectricityMeterParameter parameter=new ElectricityMeterParameter();

        parameter.setElectricityModel(request.getElectricityModel());

        parameter.setCommunityMode(request.getCommunityMode());

        parameter.setMeasureMode(request.getMeasureMode());

        parameter.setElectricityName(request.getElectricityName());

        List<ElectricityMeter> electricityMeters = electricityMeterMapper.selectByParams(parameter);


        return electricityMeters;
    }
}
