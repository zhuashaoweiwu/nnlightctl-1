package com.nnlightctl.jdbcdao;

import com.nnlightctl.request.SaveUserMapRightersRequest;
import com.nnlightctl.vo.GetUserWithRighterView;

import java.util.List;

public interface MenuDao {

    int insertSaveUserMapRighters(SaveUserMapRightersRequest request);
    List<GetUserWithRighterView> getUserWithRighter(Integer userId);
}
