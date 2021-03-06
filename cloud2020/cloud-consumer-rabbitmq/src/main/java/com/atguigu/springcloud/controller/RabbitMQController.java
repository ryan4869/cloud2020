package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


@Component
//使用queuesToDeclare属性，如果不存在则会创建队列
@RabbitListener(queuesToDeclare = @Queue(RabbitMQConfig.RABBITMQ_DEMO_TOPIC))
public class RabbitMQController {

    @RabbitHandler
    public void process(@RequestParam Map map){
        System.out.println("消费者RabbitDemoConsumer从RabbitMQ服务消费消息：" + map.toString());
    }
}
