package com.nnlightctl.request;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class UpdateFirewareCommandRequest {
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAspect() {
        return aspect;
    }

    public void setAspect(String aspect) {
        this.aspect = aspect;
    }

    public MultipartFile getUpdateFireware() {
        return updateFireware;
    }

    public void setUpdateFireware(MultipartFile updateFireware) {
        this.updateFireware = updateFireware;
    }

    public List<String> getUuids() {
        return uuids;
    }

    public void setUuids(List<String> uuids) {
        this.uuids = uuids;
    }


    private List<String> uuids;
    private String version;
    private String aspect;
    private MultipartFile updateFireware;
}
