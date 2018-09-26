package com.nnlightctl.server;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.*;
import com.nnlightctl.request.*;
import com.nnlightctl.vo.ListRepertoryUserView;
import com.nnlightctl.vo.RepertoryInApplyView;

import java.util.List;

public interface RepertoryServer {

    int addOrUpdateRepertory(RepertoryRequest request);
    int deleteRepairRecord(List<Long> repertoryIds);
    Tuple.TwoTuple<List<ListRepertoryUserView>, Integer> listRepertory(BaseRequest request);
    Tuple.TwoTuple<List<ListRepertoryUserView>, Integer> getRepertory(Long id);
    int updateTransferProperty(TransferPropertyRequest request);
    Tuple.TwoTuple<List<RepertoryPropertyTranslateRecord>, Integer> listPropertyTransRecord(BaseRequest request);
    Tuple.TwoTuple<List<RepertoryInApplyView>, Integer> listApplyInRepertory(BaseRequest request);
    Tuple.TwoTuple<List<RepertoryOutApply>, Integer> listApplyOutRepertory(BaseRequest request);
    Long countApplyInRepertory();
    Long countApplyOutRepertory();
    int addOrUpdateApplyInRepertory(RepertoryInApplyRequest request);
    int deleteApplyInRepertory(List<Long> applyInRepertoryIds );
    RepertoryInApply getApplyInRepertoryById(Long id);
    int addOrUpdateApplyOutRepertory(RepertoryOutApplyRequest request);
    int deleteApplyOutRepertory(List<Long> applyOutRepertoryIds);
    RepertoryOutApply getApplyOutRepertoryById(Long id);
    Tuple.TwoTuple<List<RepertoryInApply>, Integer> listApplyInApprovePending(BaseRequest request ,int applyState);
    Tuple.TwoTuple<List<RepertoryOutApply>, Integer> listApplyOutApprovePending(BaseRequest request ,Integer applyState);
    Tuple.TwoTuple<List<RepertoryInApply>, Integer> listApplyInHistory(BaseRequest request ,List<Integer> applyStates);
    Tuple.TwoTuple<List<RepertoryOutApply>, Integer> listApplyOutHistory(BaseRequest request ,List<Integer> applyStates);
    int updateApproveApplyInRepertory(ApproveApplyInRepertoryRequest request);
    int updateApproveApplyOutRepertory(ApproveApplyOutRepertoryRequest request);
}
