package com.atguigu.springcloud.shiro.realm.mapper;

import com.atguigu.springcloud.shiro.realm.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper extends BaseMapper<User> {
}
