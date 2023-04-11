package com.ds.ds.domain.chatting.service;

import com.ds.ds.domain.chatting.domain.entity.ChatMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RedisMessageSubscriber implements MessageListener {
    private final RedisTemplate<String, Object> redisTemplate;
    private final ObjectMapper objectMapper;
    private final SendMessageService sendMessageService;
    @Override
    public void onMessage(Message message, byte[] pattern) {
        try {
            ChatMessage chatMessage = null;
            try {
                chatMessage = objectMapper.readValue(message.getBody(), ChatMessage.class);
            } catch (java.io.IOException e) {
                throw new RuntimeException(e);
            }
            sendMessageService.sendMessage(chatMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
