package com.nnlightctl.vo;

import java.util.List;

public class RegionView extends BaseView {
    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public List<RegionView> getSubRegionViewList() {
        return subRegionViewList;
    }

    public void setSubRegionViewList(List<RegionView> subRegionViewList) {
        this.subRegionViewList = subRegionViewList;
    }

    private String areaName;

    private List<RegionView> subRegionViewList;
}
