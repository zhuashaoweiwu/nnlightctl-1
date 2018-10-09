package com.nnlightctl.jdbcdao;

import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.request.MapProjectsToInstitutionRequest;
import com.nnlightctl.request.ProjectRequest;
import com.nnlightctl.vo.ProjectView;
import com.nnlightctl.vo.ProjectsToInstitutionView;

import java.util.List;

public interface ProjectDao {
    List<ProjectView> listProject(ProjectRequest request);

    List<ProjectsToInstitutionView> mapProjectsToInstitution(MapProjectsToInstitutionRequest mapProjectsToInstitutionRequest);
}
