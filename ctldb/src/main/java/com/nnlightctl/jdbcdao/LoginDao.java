package com.nnlightctl.jdbcdao;

import com.nnlightctl.po.Righter;

import java.util.List;

public interface LoginDao {
    List<Righter> getRightersByLoginName(String loginName);
    List<Righter> getRightersByUserId(Long userId);
}
