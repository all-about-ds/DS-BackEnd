package com.ds.ds.domain.chatting.service;

import com.ds.ds.domain.chatting.domain.entity.ChatMessage;
import com.ds.ds.domain.chatting.presentation.data.dto.ChatMessageDto;
import com.ds.ds.domain.chatting.presentation.data.request.ChatRequest;

import javax.annotation.Resource;
import java.util.List;

@Resource
public interface SendMessageService {
     ChatMessageDto sendMessage(String roomId, ChatRequest chatRequest);
     List<ChatMessageDto> getChatHistory(String roomId, Long startIndex, Long endIndex);
}
