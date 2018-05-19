package com.nnlightctl.server;

import com.nnlightctl.po.Project;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.request.ProjectConditionRequest;
import com.nnlightctl.request.ProjectRequest;
import com.nnlightctl.vo.ProjectView;

import java.util.List;

public interface ProjectServer {
    List<ProjectView> listProject(BaseRequest request);
    Project getProject(ProjectConditionRequest request);
    int insertProject(ProjectRequest request);
    int updateProject(ProjectRequest request);
    int deleteProject(List<Long> idList);
}
