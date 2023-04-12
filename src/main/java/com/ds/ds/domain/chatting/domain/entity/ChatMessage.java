package com.ds.ds.domain.chatting.domain.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChatMessage {
    private MessageType type;
    private String sender;
    private String message;
    private String roomId;
    private LocalDateTime timestamp;

    public enum MessageType {
        ENTER, TALK, QUIT
    }

    public static ChatMessage enterMessage(String sender, String roomId) {
        return ChatMessage.builder()
                .type(MessageType.ENTER)
                .sender(sender)
                .roomId(roomId)
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static ChatMessage quitMessage(String sender, String roomId) {
      return ChatMessage.builder()
              .type(MessageType.QUIT)
              .sender(sender)
              .roomId(roomId)
              .timestamp(LocalDateTime.now())
              .build();

    }

    public static ChatMessage talkMessage(String sender, String message, String roomId) {
        return ChatMessage.builder()
                .type(MessageType.TALK)
                .sender(sender)
                .message(message)
                .roomId(roomId)
                .timestamp(LocalDateTime.now())
                .build();
    }
}