package com.atguigu.springcloud.shiro.realm.controller;

import com.atguigu.springcloud.shiro.realm.entity.ResponseData;
import com.atguigu.springcloud.shiro.realm.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @PostMapping(value = "/login")
    public ResponseData login(@RequestBody User user){



        return ResponseData.builder().success().build();
    }

}
