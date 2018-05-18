package com.nnlightctl.server;

import com.nnlightctl.po.ProjectCountry;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.request.ProjectCountryConditionRequest;
import com.nnlightctl.request.ProjectCountryRequest;

import java.util.List;

public interface ProjectCountryServer {
    int addOrUpdateCountry(ProjectCountryRequest request);
    List<ProjectCountry> listCountry(BaseRequest request);
    ProjectCountry getCountry(ProjectCountryConditionRequest request);
}
