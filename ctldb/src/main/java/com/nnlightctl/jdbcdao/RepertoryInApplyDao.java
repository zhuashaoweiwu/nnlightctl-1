package com.nnlightctl.jdbcdao;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.RepertoryInApply;
import com.nnlightctl.po.RepertoryOutApply;
import com.nnlightctl.request.ApproveApplyInRepertoryRequest;
import com.nnlightctl.request.ApproveApplyOutRepertoryRequest;
import com.nnlightctl.request.BaseRequest;

import java.util.List;

public interface RepertoryInApplyDao {
    Tuple.TwoTuple<List<RepertoryInApply>, Integer> listApplyInApprovePending(BaseRequest request ,int applyState);
    Tuple.TwoTuple<List<RepertoryOutApply>, Integer> listApplyOutApprovePending(BaseRequest request , Integer applyState);
    Tuple.TwoTuple<List<RepertoryInApply>, Integer> listApplyInHistory(BaseRequest request ,List<Integer> applyStates);
    Tuple.TwoTuple<List<RepertoryOutApply>, Integer> listApplyOutHistory(BaseRequest request ,List<Integer> applyStates);
    int updateApproveApplyInRepertory(ApproveApplyInRepertoryRequest request);
    int updateApproveApplyOutRepertory(ApproveApplyOutRepertoryRequest request);
}
