package com.nnlightctl.jdbcdao;

import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.vo.ProjectView;

import java.util.List;

public interface ProjectDao {
    List<ProjectView> listProject(BaseRequest request);
}
