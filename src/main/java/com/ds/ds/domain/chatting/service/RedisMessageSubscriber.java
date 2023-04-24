package com.ds.ds.domain.chatting.service;

import com.ds.ds.domain.chatting.domain.entity.ChatMessage;
import com.ds.ds.domain.chatting.domain.entity.ChatRoom;
import com.ds.ds.domain.chatting.domain.repository.ChatMessageRepository;
import com.ds.ds.domain.chatting.domain.repository.ChatRoomRepository;
import com.ds.ds.domain.chatting.presentation.data.dto.ChatMessageDto;
import com.ds.ds.domain.chatting.presentation.data.request.ChatRequest;
import com.ds.ds.domain.chatting.util.ChatConverter;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedisMessageSubscriber implements MessageListener {
    private final RedisTemplate<String, Object> redisTemplate;
    private final ObjectMapper objectMapper;
    private final SendMessageService sendMessageService;
    private final ChatConverter chatConverter;
    private final ChatRoomRepository chatRoomRepository;
    private final ChatMessageRepository chatMessageRepository;

    @SneakyThrows
    @Override
    public void onMessage(Message message, byte[] pattern) {
        try {
            ChatMessageDto chatMessageDto = objectMapper.readValue(message.getBody(), ChatMessageDto.class);
            ChatMessage chatMessage = chatConverter.toEntity(chatMessageDto);
            ChatRoom chatRoom = chatRoomRepository.findById(chatMessage.getRoomId())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid roomId: " + chatMessageDto.getRoomId()));
            chatMessage.setChatRoom(chatRoom);

            // ChatMessage를 데이터베이스에 저장
            chatMessageRepository.save(chatMessage);

            sendMessageService.sendMessage(chatMessageDto.getRoomId(), chatRequest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}



