package com.nnlightctl.request;

public class UserRequest {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public Byte getIsRemenberPwd() {
        return isRemenberPwd;
    }

    public void setIsRemenberPwd(Byte isRemenberPwd) {
        this.isRemenberPwd = isRemenberPwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getCodeNumber() {
        return codeNumber;
    }

    public void setCodeNumber(String codeNumber) {
        this.codeNumber = codeNumber;
    }

    public Byte getUserType() {
        return userType;
    }

    public void setUserType(Byte userType) {
        this.userType = userType;
    }

    public Long getNnlightctlDepartmentId() {
        return nnlightctlDepartmentId;
    }

    public void setNnlightctlDepartmentId(Long nnlightctlDepartmentId) {
        this.nnlightctlDepartmentId = nnlightctlDepartmentId;
    }

    private Long id;

    private String loginName;

    private String loginPwd;

    private Byte isRemenberPwd;

    private String userName;

    private Byte sex;

    private Byte age;

    private String phone;

    private String email;

    private String place;

    private String codeNumber;

    private Byte userType;

    private Long nnlightctlDepartmentId;
}
