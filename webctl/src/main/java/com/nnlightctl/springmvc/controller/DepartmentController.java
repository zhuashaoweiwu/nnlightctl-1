package com.nnlightctl.springmvc.controller;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.Department;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.request.DepartmentConditionRequest;
import com.nnlightctl.request.DepartmentRequest;
import com.nnlightctl.result.JsonResult;
import com.nnlightctl.server.DepartmentServer;
import com.nnlightctl.vo.DepartmentView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/department")
public class DepartmentController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentServer departmentServer;

    @RequestMapping("addOrUpdateDepartment")
    public String addOrUpdateDepartment(@Valid DepartmentRequest request, BindingResult bindingResult) {
        logger.info("[POST] /api/department/addOrUpdateDepartment");

        //参数检验
        if (bindingResult.hasErrors()) {
            JsonResult jsonResult = JsonResult.getFAILURE();
            StringBuilder stringBuilder = new StringBuilder();
            List<ObjectError> objectErrorList = bindingResult.getAllErrors();
            for (ObjectError objectError : objectErrorList) {
                stringBuilder.append(objectError.getDefaultMessage() + "\r\n");
            }

            jsonResult.setMsg(stringBuilder.toString());
            return toJson(jsonResult);
        }

        int ret = departmentServer.addOrUpdateDepartment(request);

        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }

    /*
    *部门管理
    *一点一、通过部门名称统计部门数量（判断部门名称是否唯一用）
    * */
    @RequestMapping("countDepartmentByName")
    public String countDepartmentByName(String departmentName){
        logger.info("[POST] /api/department/countDepartmentByName");
        int total = departmentServer.getCountDepartmentByName(departmentName);
        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setTotal(total);
        return toJson(jsonResult);
    }

    @RequestMapping("listDepartment")
    public String listDepartment(DepartmentRequest request) {
        logger.info("[POST] /api/department/listDepartment");

        Tuple.TwoTuple<List<DepartmentView>, Integer> tuple = departmentServer.listDepartment(request);

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
