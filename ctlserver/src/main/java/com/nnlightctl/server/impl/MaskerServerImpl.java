package com.nnlightctl.server.impl;

import com.github.pagehelper.PageHelper;
import com.nnlight.common.ReflectCopyUtil;
import com.nnlight.common.Tuple;
import com.nnlightctl.dao.MaskerMapper;
import com.nnlightctl.po.*;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.request.DeleteMaskerRequest;
import com.nnlightctl.request.MaskerRequest;
import com.nnlightctl.server.MaskerServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class MaskerServerImpl implements MaskerServer {
    @Autowired
    private MaskerMapper maskerMapper;

    @Override
    public int addOrUpdateMasker(MaskerRequest request){
        Masker masker = new Masker();
        ReflectCopyUtil.beanSameFieldCopy(request, masker);
        masker.setGmtUpdated(new Date());

        int ret = -1;
        if (request.getId() == null) {
            //新增
            masker.setGmtCreated(new Date());
            ret = maskerMapper.insertSelective(masker);
        } else {
            //修改
            ret = maskerMapper.updateByPrimaryKeySelective(masker);
        }

        return ret;
    }

    @Override
    public int deleteMasker(DeleteMaskerRequest request){
        for (Long id : request.getMaskerIds()) {
            maskerMapper.deleteByPrimaryKey(id);
        }
        return 1;
    }

    @Override
    public Tuple.TwoTuple<List<Masker>, Integer> listMasker(MaskerRequest request){
        Tuple.TwoTuple<List<Masker>, Integer> tuple = new Tuple.TwoTuple<>();

        MaskerExample maskerExample = new MaskerExample();
        MaskerExample.Criteria criteria = maskerExample.createCriteria();
        if (!StringUtils.isEmpty(request.getPhoneNumber())) {
            criteria.andPhoneNumberLike("%"+request.getPhoneNumber()+"%");
        }
        if (!StringUtils.isEmpty(request.getDepartment())){
            criteria.andDepartmentLike("%"+request.getDepartment()+"%");
        }
        maskerExample.setOrderByClause("id DESC");

        int total =maskerMapper.countByExample(maskerExample);
        tuple.setSecond(total);

        PageHelper.startPage(request.getPageNumber(), request.getPageSize());

        List<Masker> alarmHistoriesList = maskerMapper.selectByExample(maskerExample);
        tuple.setFirst(alarmHistoriesList);

        return tuple;
    }

    @Override
    public Masker getMasker(Long id){
       return maskerMapper.selectByPrimaryKey(id);
    }
}
