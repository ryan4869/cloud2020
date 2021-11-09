package com.atguigu.springcloud.rabbitmq.service;

import java.util.Map;

public interface RabbitMQService {

    String sendMsg(String msg);

    String sendMsgByFanoutExchange(String msg);

    String sendMsgByHeadersExchange(String msg, Map<String,Object> map);
}
