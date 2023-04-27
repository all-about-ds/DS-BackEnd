package com.ds.ds.domain.chatting.presentation.data.request;

import com.amazonaws.services.kms.model.MessageType;
import com.ds.ds.domain.chatting.domain.entity.ChatMessage;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Getter
@Builder
@RequiredArgsConstructor
public class ChatRequest {
    private final String sender;
    private final String message;
    private final String roomId;
    private final ChatMessage.MessageType type;
    private final LocalDateTime timestamp;
}