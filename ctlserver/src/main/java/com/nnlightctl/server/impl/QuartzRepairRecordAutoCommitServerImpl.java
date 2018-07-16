package com.nnlightctl.server.impl;

import com.nnlight.common.DateTimeUtil;
import com.nnlightctl.dao.RepairRecordAutoCommitMapper;
import com.nnlightctl.dao.RepairRecordMapper;
import com.nnlightctl.po.RepairRecord;
import com.nnlightctl.po.RepairRecordAutoCommit;
import com.nnlightctl.po.RepairRecordAutoCommitExample;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuartzRepairRecordAutoCommitServerImpl implements Job {

    @Autowired
    private RepairRecordAutoCommitMapper repairRecordAutoCommitMapper;

    @Autowired
    private RepairRecordMapper repairRecordMapper;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        RepairRecordAutoCommitExample example = new RepairRecordAutoCommitExample();
        example.createCriteria().andAutoCommitTimeEqualTo(DateTimeUtil.nowWithoutSecond());
        List<RepairRecordAutoCommit> repairRecordAutoCommits = repairRecordAutoCommitMapper.selectByExample(example);

        for (RepairRecordAutoCommit repairRecordAutoCommit : repairRecordAutoCommits) {
            //更改维修记录已提交状态
            RepairRecord repairRecord = new RepairRecord();
            repairRecord.setId(repairRecordAutoCommit.getRepairRecordId());
            repairRecord.setIsCommit((byte)1);
            repairRecordMapper.updateByPrimaryKeySelective(repairRecord);

            //更新自动提交维修记录表已执行状态
            repairRecordAutoCommit.setCommitState((byte)1);
            repairRecordAutoCommitMapper.updateByPrimaryKeySelective(repairRecordAutoCommit);
        }
    }
}
