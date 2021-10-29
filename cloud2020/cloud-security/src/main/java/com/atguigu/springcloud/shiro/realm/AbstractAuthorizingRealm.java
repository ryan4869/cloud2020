package com.atguigu.springcloud.shiro.realm;

import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public abstract class AbstractAuthorizingRealm extends AuthorizingRealm {

    protected abstract AuthorizationInfo doAuthorization(PrincipalCollection principals);
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return doAuthorization(principalCollection);
    }
}
