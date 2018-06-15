package com.nnlightctl.server;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.User;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.request.UserConditionRequest;
import com.nnlightctl.request.UserRequest;

import java.util.List;

public interface UserServer {
    int addOrUpdateUser(UserRequest request);

    Tuple.TwoTuple<List<User>, Integer> listUser(BaseRequest request);

    User getUser(Long id);

    int deleteUser(UserConditionRequest request);

    int updateUserPwd(UserConditionRequest request);

    Tuple.TwoTuple<List<User>, Integer> listOnlineUser();
}
