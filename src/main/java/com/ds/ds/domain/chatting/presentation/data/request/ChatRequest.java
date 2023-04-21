package com.ds.ds.domain.chatting.presentation.data.request;

import com.ds.ds.domain.chatting.domain.entity.ChatMessage;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@RequiredArgsConstructor
public class ChatRequest {
    private String sender;
    private String message;
    private String roomId;
    private ChatMessage.MessageType type;
}
