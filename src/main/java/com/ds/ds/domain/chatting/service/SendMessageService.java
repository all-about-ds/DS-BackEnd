package com.ds.ds.domain.chatting.service;

import com.ds.ds.domain.chatting.domain.entity.ChatMessage;

import java.util.List;

public interface SendMessageService {
     void sendMessage(ChatMessage message);
     List<ChatMessage> getChatHistory(String roomId, Long startIndex, Long endIndex);
}
