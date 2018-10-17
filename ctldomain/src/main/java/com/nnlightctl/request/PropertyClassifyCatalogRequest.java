package com.nnlightctl.request;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class PropertyClassifyCatalogRequest {

    private Long id;

    private Date gmtCreated;

    private Date gmtUpdated;
    @NotBlank(message = "资产分类目录名称不能为空！")
    private String myCatalogName;

    private Byte catalogLevel;

    private Long nnlightctlPropertyClassifyCatalogId;

    private List<Long> propertyClassifyCatalogIds;

    public List<Long> getPropertyClassifyCatalogIds() {
        return propertyClassifyCatalogIds;
    }

    public void setPropertyClassifyCatalogIds(List<Long> propertyClassifyCatalogIds) {
        this.propertyClassifyCatalogIds = propertyClassifyCatalogIds;
    }

    public Long getNnlightctlPropertyClassifyCatalogId() {
        return nnlightctlPropertyClassifyCatalogId;
    }

    public void setNnlightctlPropertyClassifyCatalogId(Long nnlightctlPropertyClassifyCatalogId) {
        this.nnlightctlPropertyClassifyCatalogId = nnlightctlPropertyClassifyCatalogId;
    }

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

    public String getMyCatalogName() {
        return myCatalogName;
    }

    public void setMyCatalogName(String myCatalogName) {
        this.myCatalogName = myCatalogName;
    }

    public Byte getCatalogLevel() {
        return catalogLevel;
    }

    public void setCatalogLevel(Byte catalogLevel) {
        this.catalogLevel = catalogLevel;
    }
}
