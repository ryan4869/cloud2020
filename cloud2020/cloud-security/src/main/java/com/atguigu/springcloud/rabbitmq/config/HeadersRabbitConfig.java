package com.atguigu.springcloud.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class HeadersRabbitConfig implements BeanPostProcessor {
    @Autowired
    private RabbitAdmin rabbitAdmin;

    @Bean
    public Queue headersQueueA(){
        return new Queue(RabbitMQConfig.HEADERS_EXCHANGE_QUEUE_A,true,false,false);
    }

    @Bean
    public Queue headersQueueB(){
        return new Queue(RabbitMQConfig.HEADERS_EXCHANGE_QUEUE_B,true,false,false);
    }

    @Bean
    public HeadersExchange rabbitmqDemoHeadersExchange(){
        return new HeadersExchange(RabbitMQConfig.HEADERS_EXCHANGE_DEMO_NAME,true,false);
    }

    @Bean
    public Binding bindHeadersA(){
        Map<String,Object> map = new HashMap<>();
        map.put("key_one","java");
        map.put("key_two","rabbit");
        //全匹配
        return BindingBuilder.bind(headersQueueA()).to(rabbitmqDemoHeadersExchange()).whereAll(map).match();
    }

    @Bean
    public Binding bindHeadersB(){
        Map<String,Object> map = new HashMap<>();
        map.put("headers_A", "coke");
        map.put("headers_B", "sky");
        //部分匹配
        return BindingBuilder.bind(headersQueueB()).to(rabbitmqDemoHeadersExchange()).whereAny(map).match();
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException{
        rabbitAdmin.declareQueue(headersQueueA());
        rabbitAdmin.declareQueue(headersQueueB());
        rabbitAdmin.declareExchange(rabbitmqDemoHeadersExchange());
        return null;
    }

}
