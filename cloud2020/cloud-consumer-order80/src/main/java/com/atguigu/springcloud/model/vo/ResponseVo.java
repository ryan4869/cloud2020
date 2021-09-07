package com.atguigu.springcloud.model.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseVo implements Serializable {

    private String phone;

    private Integer id;
}
