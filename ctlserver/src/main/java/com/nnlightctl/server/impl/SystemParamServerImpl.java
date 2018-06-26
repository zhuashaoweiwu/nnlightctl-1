package com.nnlightctl.server.impl;

import com.github.pagehelper.PageHelper;
import com.nnlight.common.Tuple;
import com.nnlightctl.dao.SystemParamMapper;
import com.nnlightctl.po.SystemParamExample;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.server.SystemParamServer;
import com.nnlightctl.request.SystemParamRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nnlightctl.po.SystemParam;
import com.nnlight.common.ReflectCopyUtil;

import java.util.Date;
import java.util.List;

@Service
public class SystemParamServerImpl implements SystemParamServer{
    @Autowired
    private SystemParamMapper systemParamMapper;
    @Override
    public int addOrUpdateSystemParam(SystemParamRequest request){
        SystemParam SystemParam = new SystemParam();
        ReflectCopyUtil.beanSameFieldCopy(request, SystemParam);
        int ret = -1;
        SystemParam.setGmtCreated(new Date());
        SystemParam.setGmtUpdated(new Date());
        if (request.getId() == null) {

            ret =  systemParamMapper.insertSelective(SystemParam);
        }else{
            ret = systemParamMapper.updateByPrimaryKeySelective(SystemParam);
        }
        return ret;
    }

    @Override
    public SystemParam getDepartment(Long id) {
        return systemParamMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SystemParam> getSystemParamByCode(String codeNumber) {

        SystemParamExample systemParamExample = new SystemParamExample();
        systemParamExample.createCriteria().andCodeNumberEqualTo(codeNumber);
        systemParamExample.setOrderByClause("id DESC");

        return systemParamMapper.selectByExample(systemParamExample);
    }

    @Override
    public Tuple.TwoTuple<List<SystemParam>, Integer> listSystemParam(BaseRequest request) {

        Tuple.TwoTuple<List<SystemParam>, Integer> tuple = new Tuple.TwoTuple<>();

        SystemParamExample systemParamExample = new SystemParamExample();
        systemParamExample.setOrderByClause("id DESC");

        int total = systemParamMapper.countByExample(systemParamExample);
        tuple.setSecond(total);
        PageHelper.startPage(request.getPageNumber(), request.getPageSize());

        List<SystemParam> systemParamList = systemParamMapper.selectByExample(systemParamExample);
        tuple.setFirst(systemParamList);

        return tuple;
    }

    @Override
    public int deleteSystemParam( List<Long> systemParamIds){

        for (Long id : systemParamIds) {
            systemParamMapper.deleteByPrimaryKey(id);
        }
        return 1;

    }
}
