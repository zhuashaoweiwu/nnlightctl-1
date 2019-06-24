package com.nnlightctl.server.impl;

import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.nnlight.common.PubMethod;
import com.nnlight.common.ReflectCopyUtil;
import com.nnlight.common.SystemConfig;
import com.nnlight.common.Tuple;
import com.nnlightctl.dao.SwitchTaskInfoMapper;
import com.nnlightctl.dao.SwitchTaskMapper;
import com.nnlightctl.po.SwitchTask;
import com.nnlightctl.po.SwitchTaskExample;
import com.nnlightctl.po.SwitchTaskInfo;
import com.nnlightctl.request.SwitchTaskConditionRequest;
import com.nnlightctl.request.SwitchTaskRequest;
import com.nnlightctl.server.SwitchTaskServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SwitchTaskServerImpl implements SwitchTaskServer {

    private static final Logger log = LoggerFactory.getLogger(SwitchTaskServerImpl.class);

    @Autowired
    private SwitchTaskMapper switchTaskMapper;

    @Autowired
    private SwitchTaskInfoMapper switchTaskInfoMapper;


    @Override
    public int addOrUpdateSwitchTask(SwitchTaskRequest request) {
        SwitchTask switchTask = new SwitchTask();
        ReflectCopyUtil.beanSameFieldCopy(request, switchTask);
        switchTask.setGmtUpdated(new Date());

        int ret = -1;
        if (request.getId() == null) {
            switchTask.setGmtCreated(new Date());
            ret = this.switchTaskMapper.insertSelective(switchTask);
            request.setId(switchTask.getId());
        } else {
            ret = this.switchTaskMapper.updateByPrimaryKeySelective(switchTask);
        }
        try {
            optionHolidaysInfo(request);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return ret;
    }

    private void optionHolidaysInfo(SwitchTaskRequest request) {
        if (request.getPeriod().equals(SystemConfig.getInfo.getConstant.HOLIDAYVACATIONS) && !PubMethod.isEmpty(request.getSwitchTaskInfoArray())) {
            List<Long> parList = Lists.newArrayList();
            request.getSwitchTaskInfoArray().forEach(switchInfo -> {
                if (PubMethod.isEmpty(switchInfo.getSwitchTaskInfoId())) {
                    SwitchTaskInfo switchTaskInfo = new SwitchTaskInfo(switchInfo.getBeginTime(), request.getId(), switchInfo.getLightPercent());
                    this.switchTaskInfoMapper.insertSelective(switchTaskInfo);
                    parList.add(switchTaskInfo.getId());
                } else {
                    this.switchTaskInfoMapper.updateByPrimaryKeySelective(new SwitchTaskInfo(switchInfo.getSwitchTaskInfoId(), switchInfo.getBeginTime(), request.getId(), switchInfo.getLightPercent()));
                    parList.add(switchInfo.getSwitchTaskInfoId());
                }

            });
            this.switchTaskInfoMapper.deleteByTaskId(parList, request.getId());
        }
    }

    @Override
    public Tuple.TwoTuple<List<SwitchTask>, Integer> listSwitchTask(SwitchTaskConditionRequest request) {
        Tuple.TwoTuple<List<SwitchTask>, Integer> tuple = new Tuple.TwoTuple<>();

        SwitchTaskExample switchTaskExample = new SwitchTaskExample();
        if (request.getSwitchName() != null) {
            switchTaskExample.createCriteria().andSwitchNameEqualTo(request.getSwitchName());
        }
        switchTaskExample.setOrderByClause("id DESC");
        int total = this.switchTaskMapper.countByExample(switchTaskExample);
        tuple.setSecond(total);

        PageHelper.startPage(request.getPageNumber(), request.getPageSize());

        List<SwitchTask> switchTaskList = this.switchTaskMapper.selectByExample(switchTaskExample);
        tuple.setFirst(switchTaskList);

        return tuple;
    }

    @Override
    public SwitchTask getSwitchTask(Long id) {
        return this.switchTaskMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteSwitchTask(SwitchTaskConditionRequest request) {
        List<Long> switchTaskIds = request.getSwitchTaskIds();
        for (Long id : switchTaskIds) {
            this.switchTaskMapper.deleteByPrimaryKey(id);
        }
        return 1;
    }
}
