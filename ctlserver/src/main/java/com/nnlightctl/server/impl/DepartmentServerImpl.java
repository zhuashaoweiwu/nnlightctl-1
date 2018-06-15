package com.nnlightctl.server.impl;

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
            ret = departmentMapper.insertSelective(department);
        } else {
            //更新
            ret = departmentMapper.updateByPrimaryKeySelective(department);
        }

        return ret;
    }

    @Override
    public Tuple.TwoTuple<List<Department>, Integer> listDepartment(BaseRequest request) {
        Tuple.TwoTuple<List<Department>, Integer> tuple = new Tuple.TwoTuple<>();

        DepartmentExample departmentExample = new DepartmentExample();
        departmentExample.setOrderByClause("id DESC");

        int total = departmentMapper.countByExample(departmentExample);
        tuple.setSecond(total);

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
