package com.consumer.consumer.listener;

import com.common.mqcommon.constant.Constant;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class MqListener {

    @RabbitListener(queues = Constant.QUEUE_NAME)
    public void mq(Map<String, Object> params){
        System.out.println(params);
    }

}
