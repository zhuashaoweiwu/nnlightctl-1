package com.nnlightctl.server;

import com.nnlightctl.po.Righter;
import com.nnlightctl.request.SaveUserMapRightersRequest;
import com.nnlightctl.vo.GetUserWithRighterView;

import java.util.List;

public interface MenuServer {

    List<Righter> listMenuLevel1();
    List<Righter> listMenuLevelSub(Integer parentId);
    int insertSaveUserMapRighters(SaveUserMapRightersRequest request);
    List<GetUserWithRighterView> getUserWithRighter(Integer userId);
}
