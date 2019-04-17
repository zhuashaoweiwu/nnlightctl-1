package com.nnlightctl.server.impl;

import com.github.pagehelper.PageHelper;
import com.nnlight.common.ReflectCopyUtil;
import com.nnlight.common.Tuple;
import com.nnlightctl.dao.RepertoryOutReasonMapper;
import com.nnlightctl.po.*;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.request.RepertoryOutReasonRequest;
import com.nnlightctl.server.RepertoryOutReasonServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RepertoryOutReasonServerImpl implements RepertoryOutReasonServer {
    @Autowired
    private RepertoryOutReasonMapper repertoryOutReasonMapper;
    @Override
    public int addOrUpdateRepertoryOutReason(RepertoryOutReasonRequest request){
        RepertoryOutReason repertoryOutReason = new RepertoryOutReason();
        ReflectCopyUtil.beanSameFieldCopy(request, repertoryOutReason);
        repertoryOutReason.setGmtUpdated(new Date());

        int ret = -1;
        if (request.getId() != null) {  //修改
            ret = repertoryOutReasonMapper.updateByPrimaryKeySelective(repertoryOutReason);
        } else {
            repertoryOutReason.setGmtCreated(new Date());
            ret = repertoryOutReasonMapper.insertSelective(repertoryOutReason);
        }
        return ret;
    }
    @Override
    public int deleteRepertoryOutReason(List<Long> repertoryOutReasonIds){
        int ret = -1;
        for (Long repertoryOutReasonId : repertoryOutReasonIds) {
            ret = repertoryOutReasonMapper.deleteByPrimaryKey(repertoryOutReasonId);
        }
        return ret;
    }
    @Override
    public Tuple.TwoTuple<List<RepertoryOutReason>, Integer> listRepertoryOutReason(BaseRequest request){
        Tuple.TwoTuple<List<RepertoryOutReason>, Integer> tuple = new Tuple.TwoTuple<>();

        RepertoryOutReasonExample repertoryOutReasonExample = new RepertoryOutReasonExample();
        repertoryOutReasonExample.setOrderByClause("id DESC");

        int total =repertoryOutReasonMapper.countByExample(repertoryOutReasonExample);
        tuple.setSecond(total);

        PageHelper.startPage(request.getPageNumber(), request.getPageSize());

        List<RepertoryOutReason> repertoryOutReasonList = repertoryOutReasonMapper.selectByExample(repertoryOutReasonExample);
        tuple.setFirst(repertoryOutReasonList);

        return tuple;
    }
    @Override
    public RepertoryOutReason getRepertoryOutReason(Long id){
        return repertoryOutReasonMapper.selectByPrimaryKey(id);
    }
}
