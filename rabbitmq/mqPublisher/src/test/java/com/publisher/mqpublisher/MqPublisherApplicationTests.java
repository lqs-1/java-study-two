package com.publisher.mqpublisher;

import com.publisher.mqpublisher.config.RabbitMQConfig;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class MqPublisherApplicationTests {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void testSendMessage2SimpleQueue() {
        String exChangeName = RabbitMQConfig.EXCHANGE_NAME;
        String message = "hello, spring amqp!";
        rabbitTemplate.convertAndSend(exChangeName, "boot.haha", message);
        System.out.println("ok");
    }
}
