package com.rabbitmq.service;

import com.rabbitmq.model.MessageConfiguration;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private MessageConfiguration configuration;

    public void sendMessage(Message message) {
        rabbitTemplate.convertAndSend(configuration.getQueue(), message);
    }
}
