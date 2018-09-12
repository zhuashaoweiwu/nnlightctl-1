package com.nnlightctl.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.crypto.hash.Sha256Hash;

public class CustomerCredentMatcher extends SimpleCredentialsMatcher {
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {

        UsernamePasswordToken usertoken = (UsernamePasswordToken) token;

        return equals(getCredentials(info), new Sha256Hash(String.valueOf(usertoken.getPassword()), usertoken.getUsername()));
    }
}
