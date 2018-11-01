package com.nnlightctl.server;

import com.nnlightctl.request.LoginRequest;
import com.nnlightctl.vo.MenuView;

import java.util.List;

public interface LoginServer {
    int login(LoginRequest request);
    int logout();
    List<MenuView> listMenu();
    List<MenuView> getStaticMenu();
    List<MenuView> getMenuByUserId(Long userId);
}
