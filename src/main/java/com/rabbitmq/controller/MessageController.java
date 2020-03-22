package com.rabbitmq.controller;

import com.rabbitmq.model.Request;
import com.rabbitmq.model.Response;
import com.rabbitmq.service.MessageSender;
import lombok.SneakyThrows;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

  @Autowired
  private MessageSender messageSender;

  @SneakyThrows
  @PostMapping("/send")
  @ResponseBody
  public Response sendMessage(@RequestBody Request request) {
    messageSender.sendMessage(new Message(request.getMessage().getBytes(), new MessageProperties()));
    return Response.builder().sentMessage("message sent").build();
  }
}
