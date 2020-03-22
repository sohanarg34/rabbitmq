package com.rabbitmq.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import java.nio.charset.StandardCharsets;

@Component
public class MessageListener {

    @RabbitListener(queues = "#{queue}")
    public void processMessage(Message message) {
        System.out.println("Received message: " + new String(message.getBody(), StandardCharsets.UTF_8));
    }
}
