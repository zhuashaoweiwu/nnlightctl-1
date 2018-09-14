package com.nnlightctl.server;

import com.nnlightctl.request.LoginRequest;

public interface LoginServer {
    int login(LoginRequest request);
    int logout();
}
