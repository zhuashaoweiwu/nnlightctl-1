package com.nnlightctl.server.impl;

import com.github.pagehelper.PageHelper;
import com.nnlight.common.ReflectCopyUtil;
import com.nnlight.common.Tuple;
import com.nnlightctl.dao.DepartmentMapper;
import com.nnlightctl.po.Department;
import com.nnlightctl.po.DepartmentExample;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.request.DepartmentRequest;
import com.nnlightctl.server.DepartmentServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class DepartmentServerImpl implements DepartmentServer {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public int addOrUpdateDepartment(DepartmentRequest request) {
        Department department = new Department();
        ReflectCopyUtil.beanSameFieldCopy(request, department);
        department.setGmtUpdated(new Date());

        int ret = -1;
        if (request.getId() == null) {
            //新增
            department.setGmtCreated(new Date());
            department.setCreateTime(new Date());
            department.setDepartmentLevel((byte)0);

            ret = departmentMapper.insertSelective(department);
        } else {
            //更新
            ret = departmentMapper.updateByPrimaryKeySelective(department);
        }
        return ret;
    }
    @Override
    public int getCountDepartmentByName(String departmentName){
        DepartmentExample departmentExample = new DepartmentExample();
        departmentExample.createCriteria().andDepartmentNameEqualTo(departmentName);
        int total = departmentMapper.countByExample(departmentExample);
        return total;
    }

    @Override
    public Tuple.TwoTuple<List<Department>, Integer> listDepartment(DepartmentRequest request) {
        Tuple.TwoTuple<List<Department>, Integer> tuple = new Tuple.TwoTuple<>();

        DepartmentExample departmentExample = new DepartmentExample();
        DepartmentExample.Criteria criteria = departmentExample.createCriteria();
        if(!StringUtils.isEmpty(request.getAddr())){
            criteria.andAddrLike("%" + request.getAddr() + "%");
        }
        if(!StringUtils.isEmpty(request.getDepartmentName())){
            criteria.andDepartmentNameLike("%" + request.getDepartmentName() + "%");
        }
        departmentExample.setOrderByClause("id DESC");

        int total = departmentMapper.countByExample(departmentExample);
        tuple.setSecond(total);

        PageHelper.startPage(request.getPageNumber(), request.getPageSize());

        List<Department> departmentList = departmentMapper.selectByExample(departmentExample);
        tuple.setFirst(departmentList);

        return tuple;
    }

    @Override
    public Department getDepartment(Long id) {
        return departmentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteDepartment(List<Long> departmentIds) {
        for (Long id : departmentIds) {
            departmentMapper.deleteByPrimaryKey(id);
        }
        return 1;
    }
}
