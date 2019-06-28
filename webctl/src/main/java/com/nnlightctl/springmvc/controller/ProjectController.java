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
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
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
    public String addOrUpdateCountry(@Valid ProjectCountryRequest request, BindingResult bindingResult) {
        logger.info("[POST] /api/project/addorupdatecountry");

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

        int ret = projectCountryServer.addOrUpdateCountry(request);
        if (ret > 0) {
            return toJson(JsonResult.getSUCCESS());
        } else {
            return toJson(JsonResult.getFAILURE());
        }
    }

    /*
     *国家信息管理
     *4、通过国家编码统计国家数量（判断国家编码是否重复）
     * */
    @RequestMapping("countCountryByCodeNumber")
    public String countCountryByCodeNumber(String codeNumber) {
        logger.info("[POST] /api/project/countCountryByCodeNumber");
        int total = projectCountryServer.getCountCountryByCodeNumber(codeNumber);
        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setTotal(total);
        return toJson(jsonResult);
    }

    /*
     *国家信息管理
     *5、通过国家名称统计国家数量（判断国家名称是否重复）
     * */
    @RequestMapping("countCountryByCountryName")
    public String countCountryByCountryName(String countryName) {
        logger.info("[POST] /api/project/countCountryByCountryName");
        int total = projectCountryServer.getCountCountryByCountryName(countryName);
        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setTotal(total);
        return toJson(jsonResult);
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
    public String listProvince(ProvinceConditionRequest request) {
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
    public String addOrUpdateProvince(@Valid ProjectProvinceRequest request, BindingResult bindingResult) {
        logger.info("[POST] /api/project/addorupdateProvince");

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

        int ret = projectProvinceServer.addOrUpdateProvince(request);
        if (ret > 0) {
            return toJson(JsonResult.getSUCCESS());
        } else {
            return toJson(JsonResult.getFAILURE());
        }
    }

    /*
     *二、省份信息管理
     *4、通过省份编码统计省份数量（判断省份编码是否重复）
     * */
    @RequestMapping("countProvinceByCodeNumber")
    public String countProvinceByCodeNumber(String codeNumber) {
        logger.info("[POST] /api/project/countProvinceByCodeNumber");
        int total = projectProvinceServer.getCountProvinceByCodeNumber(codeNumber);
        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setTotal(total);
        return toJson(jsonResult);
    }

    /*
     *二、省份信息管理
     *5、通过省份名称统计省份数量（判断省份名称是否重复）
     * */
    @RequestMapping("countProvinceByProvinceName")
    public String countProvinceByProvinceName(String provinceName) {
        logger.info("[POST] /api/project/countProvinceByProvinceName");
        int total = projectProvinceServer.getCountProvinceByProvinceName(provinceName);
        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setTotal(total);
        return toJson(jsonResult);
    }

    @RequestMapping("listcity")
    public String listCity(CityConditionRequest request) {
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

    @RequestMapping("getCityById")
    public String getCityById(ProjectCityConditionRequest request) {
        logger.info("[POST] /api/project/getCityById");

        ProjectCity projectCity = projectCityServer.getCityById(request.getId());
        List<ProjectCity> projectCityList = new ArrayList<>(1);
        projectCityList.add(projectCity);
        JsonResult jsonResult = JsonResult.SUCCESS;
        jsonResult.setData(projectCityList);

        return toJson(jsonResult);
    }

    @RequestMapping("addorupdatecity")
    public String addOrUpdatedCity(@Valid ProjectCityRequest request, BindingResult bindingResult) {
        logger.info("[POST] /api/project/addorupdatecity");

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


        int ret = projectCityServer.addOrUpdateCity(request);
        if (ret > 0) {
            return toJson(JsonResult.getSUCCESS());
        } else {
            return toJson(JsonResult.getFAILURE());
        }
    }

    /*
     *城市信息管理
     *4、通过城市编码统计城市数量（判断城市编码重复）
     * */
    @RequestMapping("countCityByCodeNumber")
    public String countCityByCodeNumber(String codeNumber) {
        logger.info("[POST] /api/project/countCityByCodeNumber");
        int total = projectCityServer.getCountCityByCodeNumber(codeNumber);
        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setTotal(total);
        return toJson(jsonResult);
    }

    /*
     *城市信息管理
     *5、通过城市名称统计城市数量（判断城市名称重复）
     * */
    @RequestMapping("countCityByCityName")
    public String countCityByCityName(String cityName) {
        logger.info("[POST] /api/project/countCityByCityName");
        int total = projectCityServer.getCountCityByCityName(cityName);
        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setTotal(total);
        return toJson(jsonResult);
    }

    @RequestMapping("listproject")
    public String listProject(ProjectRequest request) {
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
        JsonResult jsonResult = JsonResult.getSUCCESS();
        List<Project> projectList = new ArrayList<>(1);
        projectList.add(project);
        jsonResult.setData(projectList);

        return toJson(jsonResult);
    }

    @RequestMapping("addproject")
    public String addProject(@Valid ProjectRequest request, BindingResult bindingResult) {
        logger.info("[POST] /api/project/addproject");

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

        int ret = projectServer.insertProject(request);

        if (ret > 0) {
            return toJson(JsonResult.getSUCCESS());
        } else {
            return toJson(JsonResult.getFAILURE());
        }
    }

    /*
     *项目管理
     *3.1通过项目编码统计项目数量（判断项目编码是否重复）
     * */
    @RequestMapping("countProjectByCode")
    public String countProjectByCode(String projectCode) {
        logger.info("[POST] /api/project/countProjectByCode");
        int total = projectServer.getCountProjectByCode(projectCode);
        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setTotal(total);
        return toJson(jsonResult);
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
