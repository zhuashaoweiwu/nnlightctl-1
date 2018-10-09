package com.nnlightctl.server;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.Masker;
import com.nnlightctl.po.Supplier;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.request.SupplierRequest;

import java.util.List;

public interface SupplierServer {
    int addOrUpdateRepertory(SupplierRequest request);
    int deleteSupplier(List<Long> supplierIds);
    Tuple.TwoTuple<List<Supplier>, Integer> listSupplier(SupplierRequest request);
    Supplier getSupplier(Long id);
}
