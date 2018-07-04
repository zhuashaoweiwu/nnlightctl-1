package com.nnlightctl.server;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.Masker;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.request.DeleteMaskerRequest;
import com.nnlightctl.request.MaskerRequest;

import java.util.List;

public interface MaskerServer {

    int addOrUpdateMasker(MaskerRequest request);
    int deleteMasker(DeleteMaskerRequest request);
    Tuple.TwoTuple<List<Masker>, Integer> listMasker(BaseRequest request);
    Masker getMasker(Long id);
}
