package com.atguigu.springcloud.shiro.realm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "Users")
public class Users implements Serializable {

    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @TableField("username")
    private String username;

    @TableField("password")
    private String password;

    @TableField("password_salt")
    private String passwordSalt;
}
