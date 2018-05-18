package com.nnlightctl.server;

import com.nnlightctl.po.ProjectCity;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.request.ProjectCityConditionRequest;
import com.nnlightctl.request.ProjectCityRequest;

import java.util.List;

public interface ProjectCityServer {
    List<ProjectCity> listCity(BaseRequest request);
    ProjectCity getCity(ProjectCityConditionRequest request);
    int addOrUpdateCity(ProjectCityRequest request);
}
