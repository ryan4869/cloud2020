package com.atguigu.springcloud.shiro.realm.service;

import com.atguigu.springcloud.shiro.realm.entity.User;
import com.atguigu.springcloud.shiro.realm.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(User user) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername,user.getUsername()).eq(User::getPassword,user.getPassword());
        User one = userMapper.selectOne(queryWrapper);
        return one;
    }
}
