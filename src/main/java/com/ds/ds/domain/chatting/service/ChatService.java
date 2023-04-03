package com.ds.ds.domain.chatting.service;

import com.ds.ds.domain.chatting.domain.entity.ChatRoom;
import com.ds.ds.domain.chatting.domain.repository.ChatMessageRepository;
import com.ds.ds.domain.chatting.domain.repository.ChatRoomRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.*;


@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class ChatService {
    public static final String ENTER_INFO = "ENTER_ENFO";
    //Redis
    private static final String CHAT_ROOMS = "CHAT_ROOM";
    //채팅방에 발행되는 메시지를 처리할 listner
    private final RedisMessageListenerContainer redisMessageListenerContainer;
    //구독 처리 서비스
    private final RedisSubscriber redisSubscriber;
    private final RedisTemplate<String, Object> redisTemplate;
    private final ChatRoomRepository chatRoomRepository;
    private final ChatMessageRepository chatMessageRepository;
   // private final UserRepository userRepository;
    private HashOperations<String, String, ChatRoom> opsHashChatRoom;
    private Map<String, ChannelTopic> topics;
    private HashOperations<String, String, String> hashOpsEnterInfo;
    private final ObjectMapper objectMapper;
    private Map<String, ChatRoom> chatRooms;

    @PostConstruct
    private void init() {
        opsHashChatRoom = redisTemplate.opsForHash();
        hashOpsEnterInfo = redisTemplate.opsForHash();

        topics = new HashMap<>();
    }
    public <T> void sendMessage(WebSocketSession session, T message) {
        try {
            session.sendMessage(new TextMessage(objectMapper.writeValueAsString(message)));
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }
}
