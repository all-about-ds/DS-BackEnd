package com.ds.ds.domain.chatting.util;

import com.ds.ds.domain.chatting.domain.entity.ChatMessage;
import com.ds.ds.domain.chatting.presentation.data.dto.ChatDto;
import com.ds.ds.domain.chatting.presentation.data.dto.ChatMessageDto;
import com.ds.ds.domain.chatting.presentation.data.request.ChatRequest;
import com.ds.ds.domain.chatting.presentation.data.request.CreateChatRequest;
import com.ds.ds.domain.chatting.presentation.data.response.ChatResponse;

import java.util.List;

public interface ChatConverter {
    ChatMessage toEntity(ChatMessageDto chatMessageDto);
    ChatMessageDto toDto(ChatMessage chatMessage);
    List<ChatMessageDto>  toChatMessageDtoList(List<ChatMessage> chatMessages);

    ChatMessageDto toDto(ChatRequest chatRequest);
    ChatResponse toResponse(ChatMessageDto chatMessageDto);

    ChatDto toDto(CreateChatRequest createChatRequest);
}
