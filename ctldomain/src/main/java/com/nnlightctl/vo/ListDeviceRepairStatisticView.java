package com.nnlightctl.vo;

public class ListDeviceRepairStatisticView extends BaseView{

    private Long ListDeviceRepairStatisticCount;

    private String myCatalogName;

    public Long getListDeviceRepairStatisticCount() {
        return ListDeviceRepairStatisticCount;
    }

    public void setListDeviceRepairStatisticCount(Long listDeviceRepairStatisticCount) {
        ListDeviceRepairStatisticCount = listDeviceRepairStatisticCount;
    }

    public String getMyCatalogName() {
        return myCatalogName;
    }

    public void setMyCatalogName(String myCatalogName) {
        this.myCatalogName = myCatalogName;
    }
}
