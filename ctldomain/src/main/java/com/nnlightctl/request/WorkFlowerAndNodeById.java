package com.nnlightctl.request;

import java.util.Date;

public class WorkFlowerAndNodeById {

    private Long id;

    private Date gmtCreated;

    private Date gmtUpdated;

    private String workflowerName;

    private Byte state;

    private String mem;

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

    public String getWorkflowerName() {
        return workflowerName;
    }

    public void setWorkflowerName(String workflowerName) {
        this.workflowerName = workflowerName;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public String getMem() {
        return mem;
    }

    public void setMem(String mem) {
        this.mem = mem;
    }
}
