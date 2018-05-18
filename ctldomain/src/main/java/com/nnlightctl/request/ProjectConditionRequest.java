package com.nnlightctl.request;

import java.util.List;

public class ProjectConditionRequest extends BaseRequest {
    public String getCodeNumber() {
        return codeNumber;
    }

    public void setCodeNumber(String codeNumber) {
        this.codeNumber = codeNumber;
    }

    public List<Long> getIdList() {
        return idList;
    }

    public void setIdList(List<Long> idList) {
        this.idList = idList;
    }

    private List<Long> idList;
    private String codeNumber;
}
