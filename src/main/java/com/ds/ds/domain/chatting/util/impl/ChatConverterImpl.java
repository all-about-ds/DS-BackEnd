package com.ds.ds.domain.chatting.util.impl;

import com.ds.ds.domain.chatting.domain.entity.ChatMessage;
import com.ds.ds.domain.chatting.domain.entity.ChatRoom;
import com.ds.ds.domain.chatting.presentation.data.dto.ChatMessageDto;
import com.ds.ds.domain.chatting.presentation.data.request.ChatRequest;
import com.ds.ds.domain.chatting.presentation.data.response.ChatResponse;
import com.ds.ds.domain.chatting.util.ChatConverter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class ChatConverterImpl implements ChatConverter {
    @Override
    public ChatMessage toEntity(ChatMessageDto chatMessageDto) {
        ChatRoom chatRoom = new ChatRoom();
        return ChatMessage.builder()
                .type(chatMessageDto.getType())
                .chatRoom(chatRoom)
                .sender(chatMessageDto.getSender())
                .message(chatMessageDto.getMessage())
                .timestamp(chatMessageDto.getTimestamp())
                .build();
    }
    @Override
    public ChatMessageDto toDto(ChatMessage chatMessage) {
        return ChatMessageDto.builder()
                .type(chatMessage.getType())
                .sender(chatMessage.getSender())
                .message(chatMessage.getMessage())
                .roomId(chatMessage.getChatRoom().getId())
                .timestamp(chatMessage.getTimestamp())
                .build();
    }
    @Override
    public List<ChatMessageDto> toChatMessageDtoList(List<ChatMessage> chatMessages) {
        return chatMessages.stream()
                .map(chatMessage -> ChatMessageDto.builder()
                        .type(chatMessage.getType())
                        .roomId(chatMessage.getChatRoom().getId())
                        .sender(chatMessage.getSender())
                        .message(chatMessage.getMessage())
                        .timestamp(chatMessage.getTimestamp())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public ChatMessageDto toDto(ChatRequest chatRequest) {
        return ChatMessageDto.builder()
                .type(chatRequest.getType())
                .sender(chatRequest.getSender())
                .message(chatRequest.getMessage())
                .roomId(chatRequest.getRoomId())
                .timestamp(LocalDateTime.now())
                .build();
    }

    @Override
    public ChatResponse toResponse(ChatMessageDto chatMessageDto) {
        return ChatResponse.builder()
                .type(chatMessageDto.getType())
                .sender(chatMessageDto.getSender())
                .message(chatMessageDto.getMessage())



    }
}

