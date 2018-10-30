package com.nnlightctl.server;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.User;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.request.UserConditionRequest;
import com.nnlightctl.request.UserRequest;
import com.nnlightctl.vo.UserView;

import java.util.List;

public interface UserServer {
    int addOrUpdateUser(UserRequest request);
    int getCountUserByLoginName(String loginName);
    int getCountUserByCodeNumber(String codeNumber);
    Tuple.TwoTuple<List<UserView>, Integer> listUser(UserConditionRequest request);

    User getUser(Long id);

    User getUserByLoginName(String loginName);

    int deleteUser(List<Long> userIds);

    int updateUserPwd(UserConditionRequest request);

    Tuple.TwoTuple<List<User>, Integer> listOnlineUser();

    int updateInitUserPwd(Long userId);

    int updateUserLockState(Long userId, Integer state);
}
