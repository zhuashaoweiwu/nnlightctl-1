package com.nnlightctl.server.impl;

import com.nnlight.common.ReflectCopyUtil;
import com.nnlight.common.Tuple;
import com.nnlightctl.dao.ModularMapper;
import com.nnlightctl.parameter.ModularParameter;
import com.nnlightctl.po.Modular;
import com.nnlightctl.po.ModularExample;
import com.nnlightctl.request.ModularConditionRequest;
import com.nnlightctl.request.ModularRequest;
import com.nnlightctl.server.ModularServer;
import com.nnlightctl.vo.ModularView;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ModularServerImpl implements ModularServer {


    @Autowired
    private ModularMapper modularMapper;

    private Integer flag=-1;

    @Override
    public int addOrUpdateModular(ModularRequest request) {


        if (request!=null){
            throw new RuntimeException("提交信息数据为空");
        }

        Modular modular=new Modular();

        ReflectCopyUtil.beanSameFieldCopy(request,modular);

        if (request.getId()==null){
            //新增
            flag = modularMapper.insert(modular);

        }else {
            //修改
            flag=modularMapper.updateByPrimaryKey(modular);

        }

        return flag;
    }

    @Override
    public Modular selectByPrimaryKey(ModularConditionRequest request) {

        Modular modular = modularMapper.selectByPrimaryKey(request.getId());

        return modular;


    }

    @Override
    public Tuple.TwoTuple<List<ModularView>, Integer> listModular(ModularConditionRequest request) {

        Tuple.TwoTuple<List<ModularView>,Integer> listModular=new Tuple.TwoTuple<>();

        List<ModularView> modularViews=new ArrayList<>(7);

        ModularExample example=new ModularExample();

        ModularExample.Criteria criteria = example.createCriteria();

        if (request.getId() != null && request.getId() > 0) {
            criteria.andIdEqualTo(request.getId());
        }

        Long example1 = modularMapper.countByExample(example);

        int total=example1.intValue();

        listModular.setSecond(total);

        List<Modular> modulars = modularMapper.selectByExample(example);

        ModularView modularView=new ModularView();

        for (Modular modular : modulars) {

            ReflectCopyUtil.beanSameFieldCopy(modular,modularView);

            modularViews.add(modularView);
        }

        listModular.setFirst(modularViews);

        return listModular;
    }

    @Override
    public int deleteModularByPrimaryKey(ModularConditionRequest request) {
            List<Long> modularIds = request.getModularIds();

            if (modularIds==null){
                flag=-2;
            }else {
                for (Long modularId : modularIds) {

                    flag=modularMapper.deleteByPrimaryKey(modularId);

                }

            }
            return flag;
    }

    @Override
    public List<Modular> selectByParams(ModularConditionRequest request) {

        ModularParameter modularParameter=new ModularParameter();

        modularParameter.setModularModel(request.getModularModel());

        modularParameter.setModularName(request.getModularName());

        modularParameter.setLoopNumber(request.getLoopNumber());

        modularParameter.setMaxElectric(request.getMaxElectric());

        List<Modular> modulars = modularMapper.selectByParams(modularParameter);

        return modulars;
    }
}