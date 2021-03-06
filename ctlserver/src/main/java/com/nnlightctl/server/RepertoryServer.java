package com.nnlightctl.server;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.*;
import com.nnlightctl.request.*;
import com.nnlightctl.vo.ListRepertoryUserView;
import com.nnlightctl.vo.RepertoryInApplyView;
import com.nnlightctl.vo.RepertoryOutApplyView;
import com.nnlightctl.vo.RepertoryPropertyTranslateRecordView;

import java.util.List;

public interface RepertoryServer {

    int addOrUpdateRepertory(RepertoryRequest request);
    int deleteRepairRecord(List<Long> repertoryIds);
    Tuple.TwoTuple<List<ListRepertoryUserView>, Integer> listRepertory(ListRepertoryRequest request);
    Tuple.TwoTuple<List<ListRepertoryUserView>, Integer> getRepertory(Long id);
    int updateTransferProperty(TransferPropertyRequest request);
    Tuple.TwoTuple<List<RepertoryPropertyTranslateRecordView>, Integer> listPropertyTransRecord(ListPropertyTransRecordRequest request);
    Tuple.TwoTuple<List<RepertoryInApplyView>, Integer> listApplyInRepertory(ApplyInRepertoryRequest request);
    Tuple.TwoTuple<List<RepertoryOutApplyView>, Integer> listApplyOutRepertory(ApplyOutRepertoryRequest request);
    Long countApplyInRepertory();
    Long countApplyOutRepertory();
    int addOrUpdateApplyInRepertory(RepertoryInApplyRequest request);
    int deleteApplyInRepertory(List<Long> applyInRepertoryIds );
    RepertoryInApply getApplyInRepertoryById(Long id);
    int addOrUpdateApplyOutRepertory(RepertoryOutApplyRequest request);
    int deleteApplyOutRepertory(List<Long> applyOutRepertoryIds);
    RepertoryOutApply getApplyOutRepertoryById(Long id);
    Tuple.TwoTuple<List<RepertoryInApplyView>, Integer> listApplyInApprovePending(BaseRequest request ,int applyState);
    Tuple.TwoTuple<List<RepertoryOutApplyView>, Integer> listApplyOutApprovePending(BaseRequest request ,Integer applyState);
    Tuple.TwoTuple<List<RepertoryInApply>, Integer> listApplyInHistory(BaseRequest request ,List<Integer> applyStates);
    Tuple.TwoTuple<List<RepertoryOutApply>, Integer> listApplyOutHistory(BaseRequest request ,List<Integer> applyStates);
    int updateApproveApplyInRepertory(ApproveApplyInRepertoryRequest request);
    int updateApproveApplyOutRepertory(ApproveApplyOutRepertoryRequest request);
}
