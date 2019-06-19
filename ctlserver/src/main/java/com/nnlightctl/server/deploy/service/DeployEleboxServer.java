package com.nnlightctl.server.deploy.service;

import com.nnlightctl.request.deployRequest.DeployEleboxRequest;
import com.nnlightctl.request.deployRequest.DeployExleboxArrangeRequest;
import com.nnlightctl.vo.DeployEleboxModifyForView;

import java.util.List;

public interface DeployEleboxServer {

    int insertElebox(DeployEleboxRequest request);

    int updateElebox(DeployEleboxRequest request);

    Boolean deployExleboxArrange(DeployExleboxArrangeRequest request) throws RuntimeException;

    Boolean deployExleboxDelete(Long exleBoxId) throws RuntimeException;

    public void deployExleboxModify(DeployExleboxArrangeRequest request) throws RuntimeException;


    List<DeployEleboxModifyForView> modifyByView(Long eleboxId) throws RuntimeException;

    ;
}
