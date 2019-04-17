package com.nnlightctl.server.impl;

import com.github.pagehelper.PageHelper;
import com.nnlight.common.ReflectCopyUtil;
import com.nnlight.common.Tuple;
import com.nnlightctl.dao.RepertoryInReasonMapper;
import com.nnlightctl.po.*;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.request.RepertoryInReasonRequest;
import com.nnlightctl.server.RepertoryInReasonServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class RepertoryInReasonServerImpl implements RepertoryInReasonServer {
    @Autowired
    private RepertoryInReasonMapper repertoryInReasonMapper;
    @Override
    public int addOrUpdateRepertoryInReason(RepertoryInReasonRequest request){

        RepertoryInReason repertoryInReason = new RepertoryInReason();
        ReflectCopyUtil.beanSameFieldCopy(request, repertoryInReason);
        repertoryInReason.setGmtUpdated(new Date());

        int ret = -1;
        if (request.getId() != null) {  //修改
            ret = repertoryInReasonMapper.updateByPrimaryKeySelective(repertoryInReason);
        } else {
            repertoryInReason.setGmtCreated(new Date());
            ret = repertoryInReasonMapper.insertSelective(repertoryInReason);
        }
        return ret;
    }
    @Override
    public int deleteRepertoryInReason(List<Long> repertoryInReasonIds){
        int ret = -1;
        for (Long repertoryInReasonId : repertoryInReasonIds) {
            ret = repertoryInReasonMapper.deleteByPrimaryKey(repertoryInReasonId);
        }
        return ret;
    }
    @Override
    public Tuple.TwoTuple<List<RepertoryInReason>, Integer> listRepertoryInReason(BaseRequest request){
        Tuple.TwoTuple<List<RepertoryInReason>, Integer> tuple = new Tuple.TwoTuple<>();

        RepertoryInReasonExample repertoryInReasonExample = new RepertoryInReasonExample();
        repertoryInReasonExample.setOrderByClause("id DESC");

        int total =repertoryInReasonMapper.countByExample(repertoryInReasonExample);
        tuple.setSecond(total);

        PageHelper.startPage(request.getPageNumber(), request.getPageSize());

        List<RepertoryInReason> repertoryInReasonList = repertoryInReasonMapper.selectByExample(repertoryInReasonExample);
        tuple.setFirst(repertoryInReasonList);

        return tuple;
    }
    @Override
    public RepertoryInReason getRepertoryInReasonById(Long id){
        return repertoryInReasonMapper.selectByPrimaryKey(id);
    }
}
