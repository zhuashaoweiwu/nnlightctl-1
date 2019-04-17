package com.nnlightctl.server.impl;

import com.nnlight.common.ReflectCopyUtil;
import com.nnlightctl.dao.RighterMapper;
import com.nnlightctl.dao.UserMapper;
import com.nnlightctl.jdbcdao.LoginDao;
import com.nnlightctl.po.Righter;
import com.nnlightctl.po.RighterExample;
import com.nnlightctl.po.User;
import com.nnlightctl.po.UserExample;
import com.nnlightctl.request.LoginRequest;
import com.nnlightctl.server.LoginServer;
import com.nnlightctl.server.UserServer;
import com.nnlightctl.vo.MenuView;
import com.nnlightctl.vo.UserView;
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
import java.util.Date;
import java.util.List;

@Service
public class LoginServerImpl implements LoginServer {

    private static final Logger log = LoggerFactory.getLogger(LoginServerImpl.class);

    @Autowired
    private LoginDao loginDao;

    @Autowired
    private RighterMapper righterMapper;

    @Autowired
    private UserServer userServer;

    @Autowired
    private UserMapper userMapper;

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
            error = "未注册账户";
        } catch (IncorrectCredentialsException e) {
            error = "密码错误";
        } catch (AuthenticationException e) {
            //其他错误，比如锁定，如果想单独处理请单独catch处理
            error = "该登录用户已锁定，请联系管理员解锁";
        }

        if(error != null) {//出错了
            throw new RuntimeException(error);
        }

        //记录登录时间
        User user = new User();
        user.setGmtUpdated(new Date());
        user.setLoginTime(new Date());
        UserExample userExample = new UserExample();
        userExample.createCriteria().andLoginNameEqualTo(username);
        userMapper.updateByExampleSelective(user, userExample);

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

    @Override
    public List<MenuView> getStaticMenu() {
        List<Righter> allRighter = righterMapper.selectByExample(new RighterExample());
        List<MenuView> menuViews = new ArrayList<>(8);

        for (Righter righter : allRighter) {
            //判断是否为一级菜单
            if (righter.getRighterLevel() == 0) {
                menuViews.add(getMenuView(righter, allRighter));
            }
        }

        return menuViews;
    }

    @Override
    public List<MenuView> getMenuByUserId(Long userId) {
        List<Righter> righterList = loginDao.getRightersByUserId(userId);
        List<MenuView> menuViews = new ArrayList<>(8);

        for (Righter righter : righterList) {
            //判断是否为一级菜单
            if (righter.getRighterLevel() == 0) {
                menuViews.add(getMenuView(righter, righterList));
            }
        }

        return menuViews;
    }

    private MenuView getMenuView(Righter righter, List<Righter> righterList) {
        MenuView menuView = new MenuView();

        menuView.setId(righter.getId());
        menuView.setName(righter.getRighterName());
        menuView.setUrl(righter.getUrl());

        List<MenuView> menuViews = new ArrayList<>(8);

        for (Righter righter1 : righterList) {
            if (righter1.getParentRighterId() != null && righter1.getParentRighterId().equals(righter.getId())) {
                menuViews.add(getMenuView(righter1, righterList));
            }
        }

        menuView.setSubMenuViewList(menuViews);
        return menuView;
    }

    @Override
    public UserView getLoginUser() {
        Object loginObject = SecurityUtils.getSubject().getPrincipal();
        String loginName = loginObject instanceof User ? ((User)loginObject).getLoginName() : (String)loginObject;
        User user = userServer.getUserByLoginName(loginName);

        UserView userView = new UserView();
        ReflectCopyUtil.beanSameFieldCopy(user, userView);

        return userView;
    }
}
