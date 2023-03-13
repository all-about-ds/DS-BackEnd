package com.ds.ds.domain.chatting.config.receiver;

import com.ds.ds.domain.chatting.config.EventPayload;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class Receiver {
    public void receive(EventPayload eventPayload) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(eventPayload));
    }
}
