package com.nnlightctl.request;

import java.util.List;

public class SaveUserMapRightersRequest {

    private Integer userId;  //-- 用户id

    private List<Integer> righterIds; // -- 菜单id集合

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<Integer> getRighterIds() {
        return righterIds;
    }

    public void setRighterIds(List<Integer> righterIds) {
        this.righterIds = righterIds;
    }
}
