package com.ds.ds.domain.chatting.presentation.data.request;

import com.ds.ds.domain.chatting.domain.entity.ChatMessage;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class ChatRequest {
    private final String sender;
    private final String message;
    private final String roomId;
    private final ChatMessage.MessageType type;
    private final LocalDateTime timestamp;

}
