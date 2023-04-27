package com.ds.ds.domain.chatting.presentation.data.response;


import com.ds.ds.domain.chatting.domain.entity.ChatMessage;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
@Builder
public class ChatResponse {
    private final String sender;
    private final String message;
    private final String roomId;
    private final ChatMessage.MessageType type;
    private final LocalDateTime timestamp;
}
