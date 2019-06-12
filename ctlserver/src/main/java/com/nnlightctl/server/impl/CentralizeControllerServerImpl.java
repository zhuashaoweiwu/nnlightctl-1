package com.nnlightctl.server.impl;

import com.github.pagehelper.PageHelper;
import com.nnlight.common.ReflectCopyUtil;
import com.nnlight.common.Tuple;
import com.nnlightctl.dao.CentralizeControllerMapper;
import com.nnlightctl.po.CentralizeController;
import com.nnlightctl.po.CentralizeControllerExample;
import com.nnlightctl.request.CentralizeControllerConditionRequest;
import com.nnlightctl.request.CentralizeControllerRquester;
import com.nnlightctl.server.CentralizeControllerServer;
import com.nnlightctl.vo.CentralizeControllerView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
@Service
public class CentralizeControllerServerImpl implements CentralizeControllerServer {

    @Autowired
    private CentralizeControllerMapper centralizeControllerMapper;

    private int flag=-1;


    @Override
    public int addOrUpdateCentralizeController(CentralizeControllerRquester request) {

        CentralizeController centralizeController=new CentralizeController();

        ReflectCopyUtil.beanSameFieldCopy(request,centralizeController);

        if (request.getId()==null){

            //增加
            flag=centralizeControllerMapper.insertSelective(centralizeController);

        }else {

            flag=centralizeControllerMapper.updateByPrimaryKeySelective(centralizeController);

        }
        return flag;
    }

    @Override
    public int deleteCentralizeController(CentralizeControllerConditionRequest request) {

        List<Long> controllerIds = request.getCentralizeControllerIds();

        for (Long controllerId : controllerIds) {

            flag= centralizeControllerMapper.deleteByPrimaryKey(controllerId);
        }
        return flag;
    }

    @Override
    public CentralizeController selectByPrimaryKey(CentralizeControllerConditionRequest request) {

        Long id = request.getId();

        CentralizeController centralizeController = centralizeControllerMapper.selectByPrimaryKey(id);


        return centralizeController;
    }

    @Override
    public Tuple.TwoTuple<List<CentralizeControllerView>, Integer> listCentralizeController(CentralizeControllerConditionRequest request) {


        CentralizeControllerExample centralizeControllerExample=new CentralizeControllerExample();

        Long countByExample = centralizeControllerMapper.countByExample(centralizeControllerExample);

        int total=countByExample.intValue();

        Tuple.TwoTuple<List<CentralizeControllerView>,Integer> twoTuple=new Tuple.TwoTuple<>();

        twoTuple.setSecond(total);

        CentralizeControllerExample.Criteria criteria = centralizeControllerExample.createCriteria();

        if (!StringUtils.isEmpty(request.getEquipmentNumber())){

            criteria.addEquipmentNumber("%"+request.getEquipmentNumber()+"%");
        }


        PageHelper.startPage(request.getPageNumber(),request.getPageSize());

        List<CentralizeControllerView> viewList=new ArrayList<>(7);

        List<CentralizeController> centralizeControllers = centralizeControllerMapper.selectByExample(centralizeControllerExample);

        for (CentralizeController centralizeController : centralizeControllers) {

            CentralizeControllerView centralizeControllerView=new CentralizeControllerView();

            ReflectCopyUtil.beanSameFieldCopy(centralizeController,centralizeControllerView);

            viewList.add(centralizeControllerView);

        }

        twoTuple.setFirst(viewList);
        return twoTuple;
    }


}
