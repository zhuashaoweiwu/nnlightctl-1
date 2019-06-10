package com.nnlightctl.request;

import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

public class MaskerRequest extends BaseRequest{

    private Long id;

    private Date gmtCreated;

    private Date gmtUpdated;
    @NotBlank(message = "执行联系人姓名不能为空！")
    private String maskName;

    private Byte sex;

    private Byte age;
    @NotBlank(message = "联系电话号码不为空！")
    private String phoneNumber;

    private String email;

    private String place;

    private Long nnlightctlMaskerId;
    @NotBlank(message = "编号不能为空！")
    private String codeNumber;

    private String department;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public Date getGmtUpdated() {
        return gmtUpdated;
    }

    public void setGmtUpdated(Date gmtUpdated) {
        this.gmtUpdated = gmtUpdated;
    }

    public String getMaskName() {
        return maskName;
    }

    public void setMaskName(String maskName) {
        this.maskName = maskName;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public Long getNnlightctlMaskerId() {
        return nnlightctlMaskerId;
    }

    public void setNnlightctlMaskerId(Long nnlightctlMaskerId) {
        this.nnlightctlMaskerId = nnlightctlMaskerId;
    }

    public String getCodeNumber() {
        return codeNumber;
    }

    public void setCodeNumber(String codeNumber) {
        this.codeNumber = codeNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
