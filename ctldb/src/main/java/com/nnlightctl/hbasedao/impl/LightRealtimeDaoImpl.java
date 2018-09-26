package com.nnlightctl.hbasedao.impl;

import com.nnlightctl.hbase.HBaseClient;
import com.nnlightctl.hbasedao.LightRealtimeDao;
import com.nnlightctl.po.LightingVolEleRecord;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.UUID;

@Repository
public class LightRealtimeDaoImpl implements LightRealtimeDao {
    @Override
    public int addLightRealtimeRecord(LightingVolEleRecord record) {
        String[] baseColumn =
                { "gmt_created", "gmt_updated", "uid", "record_datetime", "voltage", "electricty", "energy", "dampness", "beam" };

        Object[] value1 = {
                record.getGmtCreated(), record.getGmtUpdated(), record.getUid(), record.getRecordDatetime(),
                record.getVoltage(), record.getElectricty(), record.getEnergy(), record.getDampness(), record.getBeam() };

        String[] highColumn =
                { "persist1", "persist2", "persist3" };
        Object[] value2 = { record.getPersist1(), record.getPersist2(), record.getPersist3() };

        try {
            HBaseClient.addData(UUID.randomUUID().toString(), "light", baseColumn, value1, highColumn, value2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 1;
    }
}
