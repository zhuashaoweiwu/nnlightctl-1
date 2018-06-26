package com.nnlightctl.server;

import com.nnlightctl.po.Alarm;
import com.nnlight.common.Tuple;
import com.nnlightctl.request.BaseRequest;

import java.util.List;

public interface ALarmServer {

    Tuple.TwoTuple<List<Alarm>, Integer> listAlarm(BaseRequest request);

}
