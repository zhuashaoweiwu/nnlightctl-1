package com.nnlightctl.server.impl;

import com.github.pagehelper.PageHelper;
import com.nnlight.common.ReflectCopyUtil;
import com.nnlight.common.Tuple;
import com.nnlightctl.dao.SwitchTaskMapper;
import com.nnlightctl.po.SwitchTask;
import com.nnlightctl.po.SwitchTaskExample;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.request.SwitchTaskConditionRequest;
import com.nnlightctl.request.SwitchTaskRequest;
import com.nnlightctl.server.SwitchTaskServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SwitchTaskServerImpl implements SwitchTaskServer {

    @Autowired
    private SwitchTaskMapper switchTaskMapper;

    @Override
    public int addOrUpdateSwitchTask(SwitchTaskRequest request) {
        SwitchTask switchTask = new SwitchTask();
        ReflectCopyUtil.beanSameFieldCopy(request, switchTask);
        switchTask.setGmtUpdated(new Date());

        int ret = -1;
        if (request.getId() == null) {
            switchTask.setGmtCreated(new Date());
            ret = this.switchTaskMapper.insertSelective(switchTask);
        } else {
            ret = this.switchTaskMapper.updateByPrimaryKeySelective(switchTask);
        }

        return ret;
    }

    @Override
    public Tuple.TwoTuple<List<SwitchTask>, Integer> listSwitchTask(SwitchTaskConditionRequest request) {
        Tuple.TwoTuple<List<SwitchTask>, Integer> tuple = new Tuple.TwoTuple<>();

        SwitchTaskExample switchTaskExample = new SwitchTaskExample();
        if(request.getSwitchName() !=null ){
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
