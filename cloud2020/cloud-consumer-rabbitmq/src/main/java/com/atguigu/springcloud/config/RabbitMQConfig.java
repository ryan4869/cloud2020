package com.atguigu.springcloud.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String RABBITMQ_DEMO_TOPIC = "rabbitmqDemoTopic";

    public static final String RABBITMQ_DEMO_DIRECT_EXCHANGE = "rabbitmqDemoDirectExchange";

    public static final String RABBITMQ_DEMO_DIRECT_ROUTING = "rabbitmqDemoDirectRouting";

}
