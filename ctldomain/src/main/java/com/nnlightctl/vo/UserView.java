package com.nnlightctl.vo;

import java.util.Date;

public class UserView extends BaseView{
    private Long id;

    private Date gmtCreated;

    private Date gmtUpdated;

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

    private Byte userState;

    private String departmentName;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Date getGmtCreated() {
        return gmtCreated;
    }

    @Override
    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    @Override
    public Date getGmtUpdated() {
        return gmtUpdated;
    }

    @Override
    public void setGmtUpdated(Date gmtUpdated) {
        this.gmtUpdated = gmtUpdated;
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

    public Byte getUserState() {
        return userState;
    }

    public void setUserState(Byte userState) {
        this.userState = userState;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
