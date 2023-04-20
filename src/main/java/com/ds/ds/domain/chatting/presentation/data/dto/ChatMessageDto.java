package com.ds.ds.domain.chatting.presentation.data.dto;

import com.ds.ds.domain.chatting.domain.entity.ChatMessage;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChatMessageDto {
    private ChatMessage.MessageType type;
    private String sender;
    private String message;
    private String roomId;
    private LocalDateTime timestamp;

    public static ChatMessageDto enterMessage(String sender, String roomId) {
        return ChatMessageDto.builder()
                .type(ChatMessage.MessageType.ENTER)
                .sender(sender)
                .roomId(roomId)
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static ChatMessageDto quitMessage(String sender, String roomId) {
      return ChatMessageDto.builder()
              .type(ChatMessage.MessageType.QUIT)
              .sender(sender)
              .roomId(roomId)
              .timestamp(LocalDateTime.now())
              .build();

    }

    public static ChatMessageDto talkMessage(String sender, String message, String roomId) {
        return ChatMessageDto.builder()
                .type(ChatMessage.MessageType.TALK)
                .sender(sender)
                .message(message)
                .roomId(roomId)
                .timestamp(LocalDateTime.now())
                .build();
    }
}