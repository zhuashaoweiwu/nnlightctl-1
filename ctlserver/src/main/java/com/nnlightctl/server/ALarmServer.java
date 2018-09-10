package com.nnlightctl.server;

import com.nnlightctl.po.Alarm;
import com.nnlight.common.Tuple;
import com.nnlightctl.po.AlarmHistory;
import com.nnlightctl.request.AlarmConfigRequest;
import com.nnlightctl.request.AlarmRequest;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.vo.AlarmAndAlarmConfigView;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.util.List;

public interface ALarmServer {

    Tuple.TwoTuple<List<Alarm>, Integer> listAlarm(BaseRequest request);

    List<AlarmAndAlarmConfigView> getAlarm(Long id);

    HSSFWorkbook exportElebox(List<Long> alarmIds);

    int clearAlarm(List<Long> alarmIds);

    Tuple.TwoTuple<List<AlarmHistory>, Integer> listAlarmHistory(BaseRequest request);

    int clearAlarmHistory(List<Long> alarmHistoryIds);

    HSSFWorkbook exportAlarmHistory(List<Long> alarmHistoryIds);

    int configAlarm(AlarmConfigRequest alarmConfigRequest);

    int updateIsUseAlarm(List<AlarmRequest> request);
}
