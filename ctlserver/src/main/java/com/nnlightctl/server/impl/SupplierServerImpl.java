package com.nnlightctl.server.impl;

import com.github.pagehelper.PageHelper;
import com.nnlight.common.ReflectCopyUtil;
import com.nnlight.common.Tuple;
import com.nnlightctl.dao.SupplierMapper;
import com.nnlightctl.po.*;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.request.SupplierRequest;
import com.nnlightctl.server.SupplierServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
    @Override
    public int deleteSupplier(List<Long> supplierIds){
        for (Long id : supplierIds) {
            supplierMapper.deleteByPrimaryKey(id);
        }
        return 1;
    }
    @Override
    public Tuple.TwoTuple<List<Supplier>, Integer> listSupplier(BaseRequest request){
        Tuple.TwoTuple<List<Supplier>, Integer> tuple = new Tuple.TwoTuple<>();

        SupplierExample supplierExample = new SupplierExample();
        supplierExample.setOrderByClause("id DESC");

        int total =supplierMapper.countByExample(supplierExample);
        tuple.setSecond(total);

        PageHelper.startPage(request.getPageNumber(), request.getPageSize());

        List<Supplier> supplierList = supplierMapper.selectByExample(supplierExample);
        tuple.setFirst(supplierList);

        return tuple;
    }
    @Override
    public Supplier getSupplier(Long id){
        return supplierMapper.selectByPrimaryKey(id);
    }
}
