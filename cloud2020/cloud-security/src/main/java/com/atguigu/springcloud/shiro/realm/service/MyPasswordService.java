package com.atguigu.springcloud.shiro.realm.service;

import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authc.credential.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import sun.security.util.Password;

public class MyPasswordService implements PasswordService {

    @Autowired
    private DefaultPasswordService defaultPasswordService;

    @Override
    public String encryptPassword(Object o) throws IllegalArgumentException {
        return defaultPasswordService.encryptPassword(o);
    }

    @Override
    public boolean passwordsMatch(Object o, String s) {
        return defaultPasswordService.passwordsMatch(o,s);
    }
}
