package com.nnlightctl.request;

public class LoginRequest {
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Byte getIsRememberMe() {
        return isRememberMe;
    }

    public void setIsRememberMe(Byte isRememberMe) {
        this.isRememberMe = isRememberMe;
    }

    private String loginName;
    private String pwd;
    private Byte isRememberMe;
}
