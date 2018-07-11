package com.nnlightctl.server;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.RepertoryInReason;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.request.RepertoryInReasonRequest;

import java.util.List;

public interface RepertoryInReasonServer {
    int addOrUpdateRepertoryInReason(RepertoryInReasonRequest request);
    int deleteRepertoryInReason(List<Long> repertoryInReasonIds);
    Tuple.TwoTuple<List<RepertoryInReason>, Integer> listRepertoryInReason(BaseRequest request);
    RepertoryInReason getRepertoryInReasonById(Long id);
}
