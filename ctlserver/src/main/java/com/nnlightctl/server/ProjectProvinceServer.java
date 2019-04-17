package com.nnlightctl.server;

import com.nnlightctl.po.ProjectProvince;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.request.ProjectProvinceConditionRequest;
import com.nnlightctl.request.ProjectProvinceRequest;
import com.nnlightctl.request.ProvinceConditionRequest;

import java.util.List;

public interface ProjectProvinceServer {
    List<ProjectProvince> listProvince(ProvinceConditionRequest request);
    ProjectProvince getProvince(ProjectProvinceConditionRequest request);
    int addOrUpdateProvince(ProjectProvinceRequest request);
    int getCountProvinceByCodeNumber(String codeNumber);
    int getCountProvinceByProvinceName(String provinceName);
}
