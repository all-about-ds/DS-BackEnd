package com.ds.ds.domain.chatting.service.impl;

import com.ds.ds.domain.chatting.domain.entity.ChatRoom;
import com.ds.ds.domain.chatting.presentation.data.dto.ChatDto;
import com.ds.ds.domain.chatting.service.CreateChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateChatRoomServiceImpl implements CreateChatRoomService {
    private final RedisTemplate<String,Object> redisTemplate;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ChatRoom createChatRoom(ChatDto chatDto) {
        String randomId = UUID.randomUUID().toString();
        ChatRoom chatRoom = new ChatRoom(randomId, chatDto);

        HashOperations<String, String, ChatRoom> hashOperations = redisTemplate.opsForHash();
        hashOperations.put("chatRooms", randomId, chatRoom);

        return chatRoom;
    }
}
