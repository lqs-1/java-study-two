package com.publisher.mqpublisher.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMQ的配置,绑定交换机和队列,消息发布方
 */
@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE_NAME = "lqs_exchange";
    public static final String QUEUE_NAME = "lqs_queue";

    // 交换机
    @Bean("bootExchange")
    public Exchange bootExchange(){
        return ExchangeBuilder.topicExchange(EXCHANGE_NAME).build();
    }

    // 队列
    @Bean("bootQueue")
    public Queue bootQueue(){
        return QueueBuilder.durable(QUEUE_NAME).build();
    }

    // 交换机和队列绑定关系，Binding
    /**
     * 1、知道哪个队列
     * 2、知道哪个交换机
     * 3、routing key:满足这个规则才可以上传成功
     */
    @Bean
    public Binding bindQueueExchange(@Qualifier("bootQueue") Queue queue, @Qualifier("bootExchange") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("boot.#").noargs(); // 有参数就用add
    }
}
