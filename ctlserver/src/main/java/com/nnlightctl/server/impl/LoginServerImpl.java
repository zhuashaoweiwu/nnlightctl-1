package com.nnlightctl.server.impl;

import com.nnlightctl.jdbcdao.LoginDao;
import com.nnlightctl.po.Righter;
import com.nnlightctl.po.User;
import com.nnlightctl.request.LoginRequest;
import com.nnlightctl.server.LoginServer;
import com.nnlightctl.vo.MenuView;
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

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginServerImpl implements LoginServer {

    private static final Logger log = LoggerFactory.getLogger(LoginServerImpl.class);

    @Autowired
    private LoginDao loginDao;

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

    @Override
    public List<MenuView> listMenu() {
        Object loginObject = SecurityUtils.getSubject().getPrincipal();
        String loginName = loginObject instanceof User ? ((User)loginObject).getLoginName() : (String)loginObject;
        List<Righter> righters = loginDao.getRightersByLoginName(loginName);
        List<MenuView> menuViews = new ArrayList<>(8);

        for (Righter righter : righters) {
            //判断是否为一级菜单
            if (righter.getRighterLevel() == 0) {
                menuViews.add(getMenuView(righter, righters));
            }
        }

        return menuViews;
    }

    private MenuView getMenuView(Righter righter, List<Righter> righterList) {
        MenuView menuView = new MenuView();

        menuView.setName(righter.getRighterName());
        menuView.setUrl(righter.getUrl());

        List<MenuView> menuViews = new ArrayList<>(8);

        for (Righter righter1 : righterList) {
            if (righter1.getParentRighterId().equals(righter.getId())) {
                menuViews.add(getMenuView(righter1, righterList));
            }
        }

        menuView.setSubMenuViewList(menuViews);
        return menuView;
    }
}
