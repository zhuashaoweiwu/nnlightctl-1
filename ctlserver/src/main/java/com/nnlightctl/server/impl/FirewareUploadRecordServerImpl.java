package com.nnlightctl.server.impl;

import com.nnlightctl.dao.FirewareUploadRecordMapper;
import com.nnlightctl.po.FirewareUploadRecord;
import com.nnlightctl.po.FirewareUploadRecordExample;
import com.nnlightctl.server.FirewareUploadRecordServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FirewareUploadRecordServerImpl implements FirewareUploadRecordServer {

    @Autowired
    private FirewareUploadRecordMapper firewareUploadRecordMapper;

    @Override
    public int addOrUpdateFirewareUploadRecord(FirewareUploadRecord record) {
        //版本号及AB面相同可识为更新
        FirewareUploadRecordExample firewareUploadRecordExample = new FirewareUploadRecordExample();
        FirewareUploadRecordExample.Criteria criteria = firewareUploadRecordExample.createCriteria();
        criteria.andFirewareVersionEqualTo(record.getFirewareVersion());
        criteria.andPersist1EqualTo(record.getPersist1());
        List<FirewareUploadRecord> firewareUploadRecordList = firewareUploadRecordMapper.selectByExample(firewareUploadRecordExample);
        if (firewareUploadRecordList != null && firewareUploadRecordList.size() > 0) {
            //更新
            firewareUploadRecordMapper.updateByExampleSelective(record, firewareUploadRecordExample);
        } else {
            //新建
            record.setGmtCreated(new Date());
            this.firewareUploadRecordMapper.insertSelective(record);
        }

        return 1;
    }

    @Override
    public List<FirewareUploadRecord> listFirewareUploadRecord() {
        return firewareUploadRecordMapper.selectByExample(new FirewareUploadRecordExample());
    }
}
