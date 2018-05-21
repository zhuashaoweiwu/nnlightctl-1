/**
 * 项目管理控制器
 */

package com.nnlightctl.springmvc.controller;


import com.nnlight.common.Tuple;
import com.nnlightctl.po.Project;
import com.nnlightctl.po.ProjectCity;
import com.nnlightctl.po.ProjectCountry;
import com.nnlightctl.po.ProjectProvince;
import com.nnlightctl.request.*;
import com.nnlightctl.result.JsonResult;
import com.nnlightctl.server.ProjectCityServer;
import com.nnlightctl.server.ProjectCountryServer;
import com.nnlightctl.server.ProjectProvinceServer;
import com.nnlightctl.server.ProjectServer;
import com.nnlightctl.vo.ProjectView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/project")
public class ProjectController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(ProjectController.class);

    @Autowired
    private ProjectCountryServer projectCountryServer;

    @Autowired
    private ProjectProvinceServer projectProvinceServer;

    @Autowired
    private ProjectCityServer projectCityServer;

    @Autowired
    private ProjectServer projectServer;

    @RequestMapping(value = "addorupdatecountry")
    public String addOrUpdateCountry(ProjectCountryRequest request) {
        logger.info("[POST] /api/project/addorupdatecountry");

        int ret = projectCountryServer.addOrUpdateCountry(request);
        if (ret > 0) {
            return toJson(JsonResult.getSUCCESS());
        } else {
            return toJson(JsonResult.getFAILURE());
        }
    }

    @RequestMapping("listcountry")
    public String listCountry(BaseRequest request) {
        logger.info("[POST] /api/project/listcountry");

        List<ProjectCountry> projectCountryList = projectCountryServer.listCountry(request);
        JsonResult jsonResult = JsonResult.SUCCESS;
        jsonResult.setData(projectCountryList);

        return toJson(jsonResult);
    }

    @RequestMapping("getcountry")
    public String getCountry(ProjectCountryConditionRequest request) {
        logger.info("[POST] /api/project/getcountry");

        ProjectCountry projectCountry = projectCountryServer.getCountry(request);
        JsonResult jsonResult = JsonResult.SUCCESS;
        List<ProjectCountry> projectCountryList = new ArrayList<>(1);
        projectCountryList.add(projectCountry);
        jsonResult.setData(projectCountryList);

        return toJson(jsonResult);
    }

    @RequestMapping("listprovince")
    public String listProvince(BaseRequest request) {
        logger.info("[POST] /api/project/listprovince");

        List<ProjectProvince> projectProvinceList = projectProvinceServer.listProvince(request);
        JsonResult jsonResult = JsonResult.SUCCESS;
        jsonResult.setData(projectProvinceList);

        return toJson(jsonResult);
    }

    @RequestMapping("getProvince")
    public String getProvince(ProjectProvinceConditionRequest request) {
        logger.info("[POST] /api/project/getProvince");

        ProjectProvince projectProvince = projectProvinceServer.getProvince(request);
        List<ProjectProvince> projectProvinceList = new ArrayList<>(1);
        projectProvinceList.add(projectProvince);
        JsonResult jsonResult = JsonResult.SUCCESS;
        jsonResult.setData(projectProvinceList);

        return toJson(jsonResult);
    }

    @RequestMapping("addorupdateProvince")
    public String addOrUpdateProvince(ProjectProvinceRequest request) {
        logger.info("[POST] /api/project/addorupdateProvince");

        int ret = projectProvinceServer.addOrUpdateProvince(request);
        if (ret > 0) {
            return toJson(JsonResult.getSUCCESS());
        } else {
            return toJson(JsonResult.getFAILURE());
        }
    }


    @RequestMapping("listcity")
    public String listCity(BaseRequest request) {
        logger.info("[POST] /api/project/listcity");

        List<ProjectCity> projectCityList = projectCityServer.listCity(request);
        JsonResult jsonResult = JsonResult.SUCCESS;
        jsonResult.setData(projectCityList);

        return toJson(jsonResult);
    }

    @RequestMapping("getcity")
    public String getCity(ProjectCityConditionRequest request) {
        logger.info("[POST] /api/project/getcity");

        ProjectCity projectCity = projectCityServer.getCity(request);
        List<ProjectCity> projectCityList = new ArrayList<>(1);
        projectCityList.add(projectCity);
        JsonResult jsonResult = JsonResult.SUCCESS;
        jsonResult.setData(projectCityList);

        return toJson(jsonResult);
    }

    @RequestMapping("addorupdatecity")
    public String addOrUpdatedCity(ProjectCityRequest request) {
        logger.info("[POST] /api/project/addorupdatecity");

        int ret = projectCityServer.addOrUpdateCity(request);
        if (ret > 0) {
            return toJson(JsonResult.getSUCCESS());
        } else {
            return toJson(JsonResult.getFAILURE());
        }
    }

    @RequestMapping("listproject")
    public String listProject(BaseRequest request) {
        logger.info("[POST] /api/project/listproject");

        Tuple.TwoTuple<List<ProjectView>, Integer> result = projectServer.listProject(request);
        List<ProjectView> projectList = result.getFirst();
        JsonResult jsonResult = JsonResult.SUCCESS;
        jsonResult.setData(projectList);
        jsonResult.setTotal(result.getSecond());

        return toJson(jsonResult);
    }

    @RequestMapping("getproject")
    public String getProject(ProjectConditionRequest request) {
        logger.info("[POST] /api/project/getproject");

        Project project = projectServer.getProject(request);
        JsonResult jsonResult = JsonResult.SUCCESS;
        List<Project> projectList = new ArrayList<>(1);
        projectList.add(project);
        jsonResult.setData(projectList);

        return toJson(jsonResult);
    }

    @RequestMapping("addproject")
    public String addProject(ProjectRequest request) {
        logger.info("[POST] /api/project/addproject");

        int ret = projectServer.insertProject(request);

        if (ret > 0) {
            return toJson(JsonResult.getSUCCESS());
        } else {
            return toJson(JsonResult.getFAILURE());
        }
    }

    @RequestMapping("updateproject")
    public String updateProject(ProjectRequest request) {
        logger.info("[POST] /api/project/updateproject");

        int ret = projectServer.updateProject(request);

        if (ret > 0) {
            return toJson(JsonResult.getSUCCESS());
        } else {
            return toJson(JsonResult.getFAILURE());
        }
    }

    @RequestMapping("deleteproject")
    public String deleteProject(ProjectConditionRequest request) {
        logger.info("[POST] /api/project/deleteproject");

        List<Long> idList = request.getIdList();

        int ret = projectServer.deleteProject(idList);

        if (ret > 0) {
            return toJson(JsonResult.getSUCCESS());
        } else {
            return toJson(JsonResult.getFAILURE());
        }
    }
}
