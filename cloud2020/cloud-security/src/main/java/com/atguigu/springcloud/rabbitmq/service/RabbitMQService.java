package com.atguigu.springcloud.rabbitmq.service;

public interface RabbitMQService {

    String sendMsg(String msg);

    String sendMsgByFanoutExchange(String msg);
}
