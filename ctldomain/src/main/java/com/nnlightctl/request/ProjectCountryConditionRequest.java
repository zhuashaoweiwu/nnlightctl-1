package com.nnlightctl.request;

public class ProjectCountryConditionRequest extends BaseRequest {
    public String getCodeNumber() {
        return codeNumber;
    }

    public void setCodeNumber(String codeNumber) {
        this.codeNumber = codeNumber;
    }

    private String codeNumber;
}
