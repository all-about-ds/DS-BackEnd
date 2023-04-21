package com.ds.ds.domain.chatting.presentation.data.response;


import com.ds.ds.domain.chatting.domain.entity.ChatMessage;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class ChatResponse {
    private String sender;
    private String message;
    private String roomId;
    private ChatMessage.MessageType type;
}
