package com.nnlightctl.request;

public class AreaRequest {
    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getRegionDesc() {
        return regionDesc;
    }

    public void setRegionDesc(String regionDesc) {
        this.regionDesc = regionDesc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Byte getRegionLevel() {
        return regionLevel;
    }

    public void setRegionLevel(Byte regionLevel) {
        this.regionLevel = regionLevel;
    }

    public Long getNnlightctlParentRegion() {
        return nnlightctlParentRegion;
    }

    public void setNnlightctlParentRegion(Long nnlightctlParentRegion) {
        this.nnlightctlParentRegion = nnlightctlParentRegion;
    }

    private Long id;
    private String areaName;
    private String regionDesc;
    private Byte regionLevel;
    private Long nnlightctlParentRegion;
}
