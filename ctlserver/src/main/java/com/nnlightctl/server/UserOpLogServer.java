package com.nnlightctl.server;

import com.nnlight.common.Tuple;
import com.nnlightctl.request.UserOpLogConditionRequest;
import com.nnlightctl.vo.UserOpLogView;

import java.util.List;

public interface UserOpLogServer {
    Tuple.TwoTuple<List<UserOpLogView>, Integer> listUserOpLog(UserOpLogConditionRequest request);
}
