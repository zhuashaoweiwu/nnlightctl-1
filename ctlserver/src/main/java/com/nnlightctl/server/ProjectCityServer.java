package com.nnlightctl.server;

import com.nnlightctl.po.ProjectCity;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.request.CityConditionRequest;
import com.nnlightctl.request.ProjectCityConditionRequest;
import com.nnlightctl.request.ProjectCityRequest;

import java.util.List;

public interface ProjectCityServer {
    List<ProjectCity> listCity(CityConditionRequest request);
    ProjectCity getCity(ProjectCityConditionRequest request);
    ProjectCity getCityById(Long id);
    int addOrUpdateCity(ProjectCityRequest request);
    int getCountCityByCodeNumber(String codeNumber);
    int getCountCityByCityName(String cityName);
}
