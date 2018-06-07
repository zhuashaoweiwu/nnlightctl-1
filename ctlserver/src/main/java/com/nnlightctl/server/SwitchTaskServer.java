package com.nnlightctl.server;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.SwitchTask;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.request.SwitchTaskConditionRequest;
import com.nnlightctl.request.SwitchTaskRequest;

import java.util.List;

public interface SwitchTaskServer {
    int addOrUpdateSwitchTask(SwitchTaskRequest request);

    Tuple.TwoTuple<List<SwitchTask>, Integer> listSwitchTask(BaseRequest request);

    SwitchTask getSwitchTask(Long id);

    int deleteSwitchTask(SwitchTaskConditionRequest request);
}
