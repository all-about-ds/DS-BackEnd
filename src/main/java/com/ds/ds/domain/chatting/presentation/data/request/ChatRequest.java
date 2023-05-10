package com.ds.ds.domain.chatting.presentation.data.request;

import com.ds.ds.domain.chatting.presentation.data.type.MessageType;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@RequiredArgsConstructor
public class ChatRequest {
    private final String roomId;
    private final MessageType type;
    private final LocalDateTime timestamp;
}