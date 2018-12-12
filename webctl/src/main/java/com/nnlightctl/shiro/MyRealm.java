package com.nnlightctl.shiro;

import com.nnlightctl.po.User;
import com.nnlightctl.server.UserServer;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.HashSet;

public class MyRealm extends AuthorizingRealm {

    private static final Logger log = LoggerFactory.getLogger(MyRealm.class);

    @Autowired
    private UserServer userServer;

    @Autowired
    private SessionDAO sessionDAO;

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        log.info("获取授权信息");
        String loginName = (String) principals.getPrimaryPrincipal();
        User loginUser = userServer.getUserByLoginName(loginName);
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setStringPermissions(new HashSet<String>(50));
        return authorizationInfo;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws
            AuthenticationException {

        UsernamePasswordToken upToken = (UsernamePasswordToken) token;

        String loginName = upToken.getUsername();

        //避免重复登录
//        Collection<Session> sessions = sessionDAO.getActiveSessions();
//        for (Session session : sessions) {
//            if (loginName.equals(String.valueOf(session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY)))) {
//                session.setTimeout(0);
//                break;
//            }
//        }

        User user = userServer.getUserByLoginName(loginName);

        if (user == null) {
            throw new UnknownAccountException();
        } else if (user.getUserState() != 1) {
            throw new AuthenticationException();
        } else {
            AuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getLoginPwd(), getName());
            return info;
        }
    }
}
