package com.nnlightctl.server;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.Department;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.request.DepartmentRequest;

import java.util.List;

public interface DepartmentServer {
    int addOrUpdateDepartment(DepartmentRequest request);

    Tuple.TwoTuple<List<Department>, Integer> listDepartment(BaseRequest request);

    Department getDepartment(Long id);

    int deleteDepartment(List<Long> departmentIds);
}
