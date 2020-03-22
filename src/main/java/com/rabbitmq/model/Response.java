package com.rabbitmq.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {

    private String sentMessage;
}
