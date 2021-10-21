package com.atguigu.springcloud.shiro.realm.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class SecurityUser implements Serializable {

    private String id;

    private String username;

    private String password;
}
