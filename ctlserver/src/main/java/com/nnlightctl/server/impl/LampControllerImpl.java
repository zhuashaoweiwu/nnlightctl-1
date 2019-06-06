package com.nnlightctl.server.impl;

import com.nnlight.common.ReflectCopyUtil;
import com.nnlight.common.Tuple;
import com.nnlightctl.dao.LampControllerMapper;
import com.nnlightctl.po.LampController;
import com.nnlightctl.request.LampControllerConditionRequest;
import com.nnlightctl.request.LampControllerRequest;
import com.nnlightctl.server.LampControllerServer;
import com.nnlightctl.vo.LampControllerView;
import org.apache.hadoop.yarn.webapp.ToJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LampControllerImpl implements LampControllerServer {

    @Autowired
    private LampControllerMapper lampControllerMapper;

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


        return 0;
    }

    @Override
    public Tuple.TwoTuple<List<LampControllerView>, Integer> listLampController() {


        return null;
    }

    @Override
    public LampController LampControllerById() {
        return null;
    }
}
