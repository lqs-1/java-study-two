package com.publisher.publisher.mq;

import com.common.mqcommon.constant.Constant;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class RabbitMqPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void publisherOne(Map<String, Object> params){
        rabbitTemplate.convertAndSend(Constant.EXCHANGE_NAME, "rabbit.test", params);
    }
}
