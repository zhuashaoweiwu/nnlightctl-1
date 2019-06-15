package com.nnlightctl.po;

import java.util.Date;

public class EleboxRelation {
    private Long id;

    private Long eleboxModelId;

    private Long eleboxId;

    private Byte eleboxModelType;

    private Date gmtCreated;

    private Date gmtUpdated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEleboxModelId() {
        return eleboxModelId;
    }

    public void setEleboxModelId(Long eleboxModelId) {
        this.eleboxModelId = eleboxModelId;
    }

    public Long getEleboxId() {
        return eleboxId;
    }

    public void setEleboxId(Long eleboxId) {
        this.eleboxId = eleboxId;
    }

    public Byte getEleboxModelType() {
        return eleboxModelType;
    }

    public void setEleboxModelType(Byte eleboxModelType) {
        this.eleboxModelType = eleboxModelType;
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
}