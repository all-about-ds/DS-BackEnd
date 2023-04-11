package com.ds.ds.domain.chatting.domain.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
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
        ChatMessage message = new ChatMessage();
        message.setType(MessageType.ENTER);
        message.setSender(sender);
        message.setRoomId(roomId);
        message.setTimestamp(LocalDateTime.now());
        return message;
    }

    public static ChatMessage quitMessage(String sender, String roomId) {
        ChatMessage message = new ChatMessage();
        message.setType(MessageType.QUIT);
        message.setSender(sender);
        message.setRoomId(roomId);
        message.setTimestamp(LocalDateTime.now());
        return message;
    }

    public static ChatMessage talkMessage(String sender, String message, String roomId) {
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setType(MessageType.TALK);
        chatMessage.setSender(sender);
        chatMessage.setMessage(message);
        chatMessage.setRoomId(roomId);
        chatMessage.setTimestamp(LocalDateTime.now());
        return chatMessage;
    }
}