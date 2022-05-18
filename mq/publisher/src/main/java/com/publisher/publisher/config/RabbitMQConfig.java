package com.publisher.publisher.config;

import com.common.mqcommon.constant.Constant;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 进行交换机与队列的绑定
 */
@Configuration
public class RabbitMQConfig {

    // 创建交换机
    @Bean(Constant.EXCHANGE_NAME)
    public Exchange exchange(){
        return ExchangeBuilder.topicExchange(Constant.EXCHANGE_NAME).build();
    }

    // 创建队列
    @Bean(Constant.QUEUE_NAME)
    public Queue queue(){
        return QueueBuilder.durable(Constant.QUEUE_NAME).build();
    }

    // 队列绑定到交换机
    @Bean
    public Binding binding(@Qualifier(Constant.QUEUE_NAME) Queue queue, @Qualifier(Constant.EXCHANGE_NAME) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(Constant.ROUTER_KEY).noargs();
    }
}
