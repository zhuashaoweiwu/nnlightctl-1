package com.nnlightctl.server;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.RepertoryOutReason;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.request.RepertoryOutReasonRequest;

import java.util.List;

public interface RepertoryOutReasonServer {
    int addOrUpdateRepertoryOutReason(RepertoryOutReasonRequest request);
    int deleteRepertoryOutReason(List<Long> repertoryOutReasonIds);
    Tuple.TwoTuple<List<RepertoryOutReason>, Integer> listRepertoryOutReason(BaseRequest request);
    RepertoryOutReason getRepertoryOutReason(Long id);
}
