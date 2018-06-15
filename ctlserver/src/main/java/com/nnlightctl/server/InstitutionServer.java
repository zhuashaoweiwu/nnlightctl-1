package com.nnlightctl.server;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.Institution;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.request.InstitutionRequest;

import java.util.List;

public interface InstitutionServer {

    int addOrUpdateInstitution(InstitutionRequest request);

    Tuple.TwoTuple<List<Institution>, Integer> listInstitution(BaseRequest request);

    Institution getInstitutionById(Long id);

    int deleteInstitution(List<Long> institutionIds);
}
