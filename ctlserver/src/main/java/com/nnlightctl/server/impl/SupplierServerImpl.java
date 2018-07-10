package com.nnlightctl.server.impl;

import com.nnlight.common.ReflectCopyUtil;
import com.nnlightctl.dao.SupplierMapper;
import com.nnlightctl.po.SceneShotcut;
import com.nnlightctl.po.Supplier;
import com.nnlightctl.request.SupplierRequest;
import com.nnlightctl.server.SupplierServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SupplierServerImpl implements SupplierServer {
    @Autowired
    private SupplierMapper supplierMapper;
    @Override
    public int addOrUpdateRepertory(SupplierRequest request){
        Supplier supplier = new Supplier();
        ReflectCopyUtil.beanSameFieldCopy(request, supplier);
        supplier.setGmtUpdated(new Date());

        int ret = -1;
        if (request.getId() == null) {
            //新增
            supplier.setGmtCreated(new Date());

            ret = supplierMapper.insertSelective(supplier);
        } else {
            //修改
            ret = supplierMapper.updateByPrimaryKeySelective(supplier);
        }

        return ret;
    }
}
