package com.nnlightctl.springmvc.controller;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.Department;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.request.DepartmentConditionRequest;
import com.nnlightctl.request.DepartmentRequest;
import com.nnlightctl.result.JsonResult;
import com.nnlightctl.server.DepartmentServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/department")
public class DepartmentController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentServer departmentServer;

    @RequestMapping("addOrUpdateDepartment")
    public String addOrUpdateDepartment(DepartmentRequest request) {
        logger.info("[POST] /api/department/addOrUpdateDepartment");

        int ret = departmentServer.addOrUpdateDepartment(request);

        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }

    @RequestMapping("listDepartment")
    public String listDepartment(BaseRequest request) {
        logger.info("[POST] /api/department/listDepartment");

        Tuple.TwoTuple<List<Department>, Integer> tuple = departmentServer.listDepartment(request);

        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setData(tuple.getFirst());
        jsonResult.setTotal(tuple.getSecond());

        return toJson(jsonResult);
    }

    @RequestMapping("getDepartment")
    public String getDepartment(Long id) {
        logger.info("[POST] /api/department/getDepartment");

        Department department = departmentServer.getDepartment(id);

        JsonResult jsonResult = JsonResult.getSUCCESS();

        List<Department> departmentList = new ArrayList<>(1);
        departmentList.add(department);

        JsonResult jsonResult1 = JsonResult.getSUCCESS();
        jsonResult.setData(departmentList);

        return toJson(jsonResult);
    }

    @RequestMapping("deleteDepartment")
    public String deleteDepartment(DepartmentConditionRequest request) {
        logger.info("[POST] /api/department/deleteDepartment");

        int ret = departmentServer.deleteDepartment(request.getDepartmentIds());

        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }

}
