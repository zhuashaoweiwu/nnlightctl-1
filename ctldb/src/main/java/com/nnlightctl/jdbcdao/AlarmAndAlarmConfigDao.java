package com.nnlightctl.jdbcdao;

import com.nnlightctl.vo.AlarmAndAlarmConfigView;
import java.util.List;
public interface AlarmAndAlarmConfigDao {

    List<AlarmAndAlarmConfigView> getAlarm(Long id);

}
