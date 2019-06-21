package com.nnlightctl.server.impl;

import com.github.pagehelper.PageHelper;
import com.nnlight.common.ReflectCopyUtil;
import com.nnlight.common.SystemConfig;
import com.nnlight.common.Tuple;
import com.nnlightctl.dao.EleboxMapper;
import com.nnlightctl.dao.EleboxRelationMapper;
import com.nnlightctl.dao.ElectricityMeterMapper;
import com.nnlightctl.dao.LampControllerMapper;
import com.nnlightctl.parameter.ElectricityMeterParameter;
import com.nnlightctl.po.EleboxRelation;
import com.nnlightctl.po.ElectricityMeter;
import com.nnlightctl.po.ElectricityMeterExample;

import com.nnlightctl.request.ElectricityMeterConditionRequest;
import com.nnlightctl.request.ElectricityMeterRequest;
import com.nnlightctl.request.deployRequest.DeployElectricityMeter;
import com.nnlightctl.server.ElectricityMeterServer;
import com.nnlightctl.vo.ElectricityMeterView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ElectricityMeterServerImpl implements ElectricityMeterServer {


    @Autowired
    private ElectricityMeterMapper electricityMeterMapper;

    @Autowired
    private EleboxRelationMapper eleboxRelationMapper;

    private int flag=-1;

    @Override
    public int addOrUpdateElectricityMeter(ElectricityMeterRequest request) {

        if (request==null){
            throw new RuntimeException("提交信息数据为空");
        }

        ElectricityMeter electricityMeter=new ElectricityMeter();

        ReflectCopyUtil.beanSameFieldCopy(request,electricityMeter);

        if (request.getId()==null){

            //未部署
            electricityMeter.setState(0);
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

        electricityMeterExample.setOrderByClause("id DESC");

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

    @Override
    public Boolean deployElectricityMeter(DeployElectricityMeter request) {

        try {
            List<Long> electricityMeterIds = request.getElectricityMeterIds();

            for (Long electricityMeterId : electricityMeterIds) {

                /**
                 * 更新电表信息
                 */
                ElectricityMeter electricityMeter=new ElectricityMeter();

                electricityMeter.setState(1);

                electricityMeter.setId(electricityMeterId);

                electricityMeterMapper.updateByPrimaryKeySelective(electricityMeter);

                /**
                 * 保存到关联表
                 */
                EleboxRelation eleboxRelation=new EleboxRelation();

                eleboxRelation.setEleboxId(request.getEleboxId());

                eleboxRelation.setEleboxModelId(electricityMeterId);

                eleboxRelation.setEleboxModelType(SystemConfig.getInfo.getConstant.WattHour);

                eleboxRelation.setGmtUpdated(new Date());

                eleboxRelation.setGmtCreated(new Date());

                eleboxRelationMapper.insertSelective(eleboxRelation);

                return Boolean.TRUE;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Boolean.FALSE;
    }

    @Override
    public Boolean deleteDeployEletricityMeterAndPhotoriod(Long eleboxId, byte EleboxModelType) {

        if (EleboxModelType==(byte) 3){
            electricityMeterMapper.updateDeployElectricity(eleboxId,EleboxModelType);

            return Boolean.TRUE;
        }
        if (EleboxModelType==(byte) 4){
            electricityMeterMapper.updateDeployPhotoriod(eleboxId,EleboxModelType);

            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }


}
