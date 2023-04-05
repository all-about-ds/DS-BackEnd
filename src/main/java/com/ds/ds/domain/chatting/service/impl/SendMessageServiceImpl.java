package com.ds.ds.domain.chatting.service.impl;

import com.ds.ds.domain.chatting.domain.entity.ChatMessage;
import com.ds.ds.domain.chatting.service.SendMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor

public class SendMessageServiceImpl implements SendMessageService {

    private final RedisTemplate<String, Object> redisTemplate;

    @Override
    public void sendMessage(ChatMessage message) {
        redisTemplate.convertAndSend("chat",message);
        redisTemplate.opsForList().rightPush("chat_history_" + message.getRoomId(), message);
    }

    @Override
    public List<ChatMessage> getChatHistory(String roomId, Long startIndex, Long endIndex) {
        List<Object> chatHistory = redisTemplate.opsForList().range("chat_history_"+ roomId, startIndex, endIndex);
        if (chatHistory == null){
            return Collections.emptyList();
        }
        List<ChatMessage> result = new ArrayList<>();

        for (Object obj : chatHistory) {
            result.add((ChatMessage) obj);
        }
        return result;
    }
}
