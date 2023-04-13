package com.ds.ds.domain.chatting.service;

import com.ds.ds.domain.chatting.presentation.data.dto.ChatMessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedisMessagePublisher {
    private final RedisTemplate<String, Object> redisTemplate;
    public void publish(ChatMessageDto chatMessage) {
        redisTemplate.convertAndSend("/sub/chat/room/" + chatMessage.getRoomId(),chatMessage);
    }
}
