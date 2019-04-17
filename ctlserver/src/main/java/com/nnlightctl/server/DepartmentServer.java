package com.nnlightctl.server;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.Department;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.request.DepartmentRequest;
import com.nnlightctl.vo.DepartmentView;

import java.util.List;

public interface DepartmentServer {
    int addOrUpdateDepartment(DepartmentRequest request);
    int getCountDepartmentByName(String departmentName);
    Tuple.TwoTuple<List<DepartmentView>, Integer> listDepartment(DepartmentRequest request);

    Department getDepartment(Long id);

    int deleteDepartment(List<Long> departmentIds);
}
