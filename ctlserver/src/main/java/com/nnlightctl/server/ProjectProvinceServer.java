package com.nnlightctl.server;

import com.nnlightctl.po.ProjectProvince;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.request.ProjectProvinceConditionRequest;
import com.nnlightctl.request.ProjectProvinceRequest;

import java.util.List;

public interface ProjectProvinceServer {
    List<ProjectProvince> listProvince(BaseRequest request);
    ProjectProvince getProvince(ProjectProvinceConditionRequest request);
    int addOrUpdateProvince(ProjectProvinceRequest request);
    int getCountProvinceByCodeNumber(String codeNumber);
    int getCountProvinceByProvinceName(String provinceName);
}
