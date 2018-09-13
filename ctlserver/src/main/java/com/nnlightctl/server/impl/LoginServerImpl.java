package com.nnlightctl.server.impl;

import com.nnlightctl.po.User;
import com.nnlightctl.request.LoginRequest;
import com.nnlightctl.server.LoginServer;
import com.nnlightctl.server.UserServer;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServerImpl implements LoginServer {

    private static final Logger log = LoggerFactory.getLogger(LoginServerImpl.class);

    @Override
    public int login(LoginRequest request) {

        String error = null;
        String username = request.getLoginName();
        String password = request.getPwd();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        if (request.getIsRememberMe() != null && request.getIsRememberMe() == 1) {
            token.setRememberMe(true);
        }
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            error = "用户名/密码错误";
        } catch (IncorrectCredentialsException e) {
            error = "用户名/密码错误";
        } catch (AuthenticationException e) {
            //其他错误，比如锁定，如果想单独处理请单独catch处理
            error = "其他错误：" + e.getMessage();
        }

        if(error != null) {//出错了，返回登录页面
            throw new RuntimeException(error);
        }

        return 1;
    }

    @Override
    public int logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return 1;
    }
}
