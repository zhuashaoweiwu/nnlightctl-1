package com.nnlightctl.server;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.Institution;
import com.nnlightctl.po.Project;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.request.InstitutionConditionRequest;
import com.nnlightctl.request.InstitutionRequest;
import com.nnlightctl.request.MapProjectsToInstitutionRequest;
import com.nnlightctl.vo.*;
import java.util.List;

public interface InstitutionServer {

    int addOrUpdateInstitution(InstitutionRequest request);

    int getCountInstitutionByName(String institutionName);

    Tuple.TwoTuple<List<InstitutionView>, Integer> listInstitution(InstitutionRequest request);

    Institution getInstitutionById(Long id);

    int deleteInstitution(List<Long> institutionIds);

    List<ProjectsToInstitutionView> mapProjectsToInstitution(MapProjectsToInstitutionRequest mapProjectsToInstitutionRequest);

    List<Project> listProjectByInsitutionId(Long insitutionId);

    int updateMapProjects2Institution(InstitutionConditionRequest request);

    List<Project> listNotBeProjects();

}
