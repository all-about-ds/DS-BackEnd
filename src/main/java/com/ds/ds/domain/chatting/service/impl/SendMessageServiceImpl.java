package com.ds.ds.domain.chatting.service.impl;

import com.ds.ds.domain.chatting.domain.entity.ChatMessage;
import com.ds.ds.domain.chatting.domain.entity.ChatRoom;
import com.ds.ds.domain.chatting.domain.repository.ChatMessageRepository;
import com.ds.ds.domain.chatting.domain.repository.ChatRoomRepository;
import com.ds.ds.domain.chatting.presentation.data.dto.ChatMessageDto;
import com.ds.ds.domain.chatting.presentation.data.request.ChatRequest;
import com.ds.ds.domain.chatting.service.SendMessageService;
import com.ds.ds.domain.chatting.util.ChatConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class SendMessageServiceImpl implements SendMessageService {

    private final RedisTemplate<String, Object> redisTemplate;
    private final ChatConverter chatConverter;
    private final ChatRoomRepository chatRoomRepository;
    private final ChatMessageRepository chatMessageRepository;

    @Override
    public ChatMessageDto sendMessage(String roomId, ChatRequest chatRequest) {
        ChatRoom chatRoom = chatRoomRepository.findById(roomId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid roomId: " + roomId));
        ChatMessage chatMessage = chatConverter.toEntity(chatConverter.toDto(chatRequest));
        chatMessage.setChatRoom(chatRoom);

        // ChatMessage를 데이터베이스에 저장
        chatMessageRepository.save(chatMessage);

        // Redis 채팅방 구독자들에게 메시지를 발행
        redisTemplate.convertAndSend("/sub/chat/room/" + chatRoom.getId(), chatConverter.toDto(chatMessage));

        // 채팅방의 채팅 내역 저장
        redisTemplate.opsForList().rightPush("chat_history_" + chatRoom.getId(), chatConverter.toDto(chatMessage));

        return chatConverter.toDto(chatMessage);
    }


    @Override
    public List<ChatMessageDto> getChatHistory(String roomId, Long startIndex, Long endIndex) {
        ChatRoom chatRoom = chatRoomRepository.findById(roomId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid roomId: " + roomId));
        List<ChatMessage> chatHistory = chatMessageRepository.findByChatRoomAndTimestampBetween(
                chatRoom, Instant.ofEpochMilli(startIndex), Instant.ofEpochMilli(endIndex));
        return chatHistory.stream()
                .map(chatConverter::toDto)
                .collect(Collectors.toList());
    }



}
