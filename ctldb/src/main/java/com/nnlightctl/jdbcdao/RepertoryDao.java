package com.nnlightctl.jdbcdao;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.Property;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.request.LightConditionRequest;
import com.nnlightctl.request.TransferPropertyRequest;
import com.nnlightctl.vo.LightingView;
import com.nnlightctl.vo.ListRepertoryUserView;

import java.util.List;

public interface RepertoryDao {

    int transferProperty(TransferPropertyRequest transferPropertyRequest);
    Tuple.TwoTuple<List<ListRepertoryUserView>, Integer> listRepertoryUser(BaseRequest request);
    Tuple.TwoTuple<List<ListRepertoryUserView>, Integer> getRepertory(Long id);
    Long countApplyInRepertory();
    Long countApplyOutRepertory();
}
