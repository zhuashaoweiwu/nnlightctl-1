package com.nnlightctl.server.impl;

import com.github.pagehelper.PageHelper;
import com.nnlight.common.ReflectCopyUtil;
import com.nnlight.common.Tuple;
import com.nnlightctl.dao.LampControllerMapper;
import com.nnlightctl.parameter.LampControllerParameter;
import com.nnlightctl.po.LampController;
import com.nnlightctl.request.LampControllerConditionRequest;
import com.nnlightctl.request.LampControllerRequest;
import com.nnlightctl.server.LampControllerServer;
import com.nnlightctl.vo.LampControllerView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LampControllerImpl implements LampControllerServer {


    @Autowired
    private LampControllerMapper lampControllerMapper;

    //判断标志位
    private Integer flag=null;

    @Override
    public int addOrUpdateLampController(LampControllerRequest request) {

        LampController lampController=new LampController();

        ReflectCopyUtil.beanSameFieldCopy(request,lampController);

        int ret=-1;

        if (request.getId()==null){

            //新增用户
            ret= lampControllerMapper.insert(lampController);
        }else {

            //修改用户
            ret= lampControllerMapper.updateByPrimaryKey(lampController);

        }
        return ret;
    }

    @Override
    public int deleteLampController(LampControllerConditionRequest request) {

        //得到id
        List<Long> lampControllerIds = request.getLampControllerIds();

        if (lampControllerIds==null){
            flag=-1;
        }else {
            for (Long lampControllerId : lampControllerIds) {
                flag= lampControllerMapper.deleteByPrimaryKey(lampControllerId);
                if (flag<0){
                    flag=-2;
                }
            }
        }

        return flag;
    }

    @Override
    public Tuple.TwoTuple<List<LampControllerView>, Integer> listLampController(LampControllerConditionRequest request) {
        Tuple.TwoTuple<List<LampControllerView>,Integer> twoTuple=new Tuple.TwoTuple<>();

        List<LampControllerView> lampControllerList=new ArrayList<>(8);

        int total = lampControllerMapper.selectByCount();

        twoTuple.setSecond(total);

        PageHelper.startPage(request.getPageNumber(),request.getPageSize());

        LampController lampController=new LampController();

        String equipmentNumber = request.getEquipmentNumber();

        lampController.setEquipmentNumber(equipmentNumber);

        List<LampController> lampControllers = lampControllerMapper.selectAll(lampController);

        for (LampController lampControllerNew : lampControllers) {

            LampControllerView lampControllerView=new LampControllerView();

            ReflectCopyUtil.beanSameFieldCopy(lampControllerNew,lampControllerView);

            lampControllerList.add(lampControllerView);

        }
        twoTuple.setFirst(lampControllerList);

        return twoTuple;
    }


    @Override
    public List<LampController> SelectByParameter(LampControllerConditionRequest request) {

        LampControllerParameter parameter=new LampControllerParameter();

        parameter.setLampModel(request.getLampModel());

        parameter.setLampName(request.getLampName());

        parameter.setLatitude(request.getLatitude());

        parameter.setLongitude(request.getLongtitude());

        parameter.setCommunicationMode(request.getCommunicationMode());

        parameter.setDimmingMode(request.getDimmingMode());

        List<LampController> lampControllerList = lampControllerMapper.selectByParameter(parameter);
        return lampControllerList;
    }

    @Override
    public LampController selectByIdLampController(LampControllerConditionRequest request) {

        Long requestId = request.getId();

        LampController lampController = lampControllerMapper.selectById(requestId);


        return lampController;
    }


}
