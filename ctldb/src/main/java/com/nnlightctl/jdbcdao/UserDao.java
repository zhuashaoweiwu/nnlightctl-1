package com.nnlightctl.jdbcdao;

import com.nnlightctl.po.UserOperationLog;

import java.util.List;

public interface UserDao {

  List<UserOperationLog> listUserOpLog(Long id);

  List<String> getRightByLoginName(String loginName);
}
