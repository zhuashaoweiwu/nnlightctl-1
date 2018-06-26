package com.nnlightctl.server.impl;

import com.github.pagehelper.PageHelper;
import com.nnlightctl.dao.AlarmMapper;
import com.nnlight.common.Tuple;
import com.nnlightctl.po.Alarm;
import com.nnlightctl.po.AlarmExample;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.server.ALarmServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AlarmServerImpl implements ALarmServer{

    @Autowired
    private AlarmMapper alarmMapper;

    @Override
    public Tuple.TwoTuple<List<Alarm>, Integer> listAlarm(BaseRequest request) {
        Tuple.TwoTuple<List<Alarm>, Integer> tuple = new Tuple.TwoTuple<>();

        AlarmExample alarmExample = new AlarmExample();
        alarmExample.setOrderByClause("id DESC");

        int total =alarmMapper.countByExample(alarmExample);
        tuple.setSecond(total);

        PageHelper.startPage(request.getPageNumber(), request.getPageSize());

        List<Alarm> alarmList = alarmMapper.selectByExample(alarmExample);
        tuple.setFirst(alarmList);

        return tuple;
    }

}
