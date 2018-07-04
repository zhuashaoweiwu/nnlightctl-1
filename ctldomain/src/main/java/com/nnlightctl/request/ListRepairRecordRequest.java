package com.nnlightctl.request;

public class ListRepairRecordRequest extends BaseRequest{

    private int isCommit;  //-- 提交状态

    public int getIsCommit() {
        return isCommit;
    }

    public void setIsCommit(int isCommit) {
        this.isCommit = isCommit;
    }
}
