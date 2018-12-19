package com.nnlightctl.jdbcdao;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.LightSignalLog;
import com.nnlightctl.request.SignalLogRequest;

import java.util.List;

public interface LightSignalRecordDao {
    int addLightSignalRecord(LightSignalLog lightSignalLog);
    //查询信号日志
    Tuple.TwoTuple<List<LightSignalLog>, Integer> listLightSignalLog(SignalLogRequest request);
    String getLightSignalByUUID(String uuid);
}
