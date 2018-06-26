package com.nnlightctl.server;

import com.nnlight.common.Tuple;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.request.SystemParamRequest;
import com.nnlightctl.po.SystemParam;

import java.util.List;

public interface SystemParamServer {

 int addOrUpdateSystemParam( SystemParamRequest request);

 SystemParam getDepartment(Long id);

 List<SystemParam> getSystemParamByCode(String  codeNumber);

 Tuple.TwoTuple<List<SystemParam>, Integer> listSystemParam(BaseRequest request);

 int deleteSystemParam(List<Long> systemParamIds);
}
