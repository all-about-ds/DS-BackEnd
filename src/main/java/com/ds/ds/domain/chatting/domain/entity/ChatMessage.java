package com.ds.ds.domain.chatting.domain.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private MessageType type;
    private String sender;
    private String message;
    private String roomId;

    public static ChatMessage createChatMessage(String roomId ,String sender, String message, MessageType type) {
        ChatMessage chatMessage = ChatMessage.builder()
                .roomId(roomId)
                .sender(sender)
                .message(message)
                .type(type)
                .build();
        return chatMessage;
    }
    public void setSender(String sender) {
        this.sender=sender;
    }
    public void setMessage(String message) {
        this.message=message;
    }
    public enum MessageType {
      ENTER,QUIT,TALK
    }

}