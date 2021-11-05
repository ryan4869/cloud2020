package com.atguigu.springcloud.controller;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

import static com.atguigu.springcloud.config.RabbitMQConfig.RABBITMQ_DEMO_TOPIC;

@Component
@RabbitListener(queues = {RABBITMQ_DEMO_TOPIC})
public class RabbitMQController {

    @RabbitHandler
    public void process(@RequestParam Map map){
        System.out.println("消费者RabbitDemoConsumer从RabbitMQ服务消费消息：" + map.toString());
    }
}
