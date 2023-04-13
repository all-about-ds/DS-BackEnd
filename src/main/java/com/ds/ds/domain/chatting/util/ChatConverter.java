package com.ds.ds.domain.chatting.util;

import com.ds.ds.domain.chatting.domain.entity.ChatMessage;
import com.ds.ds.domain.chatting.presentation.data.dto.ChatMessageDto;
import com.ds.ds.domain.chatting.presentation.data.request.ChatRequest;

import java.util.List;

public interface ChatConverter {
    ChatMessage toEntity(ChatMessageDto chatMessageDto);
    ChatMessageDto toDto(ChatMessage chatMessage);
    List<ChatMessageDto>  toChatMessageDtoList(List<ChatMessage> chatMessages);

    ChatMessageDto toDto(ChatRequest chatRequest);
    ChatRequest toRequest(ChatMessageDto chatMessageDto);
}
