package com.ds.ds.domain.chatting.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.awt.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private TrayIcon.MessageType type;
    private String sender;
    private String message;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chatroom_id")
    private ChatRoom chatRoom;

    public static ChatMessage createChatMessage(ChatRoom chatRoom, String sender, String message,MessageType type) {
        ChatMessage chatMessage= ChatMessage.builder()
                .chatRoom(chatRoom)
                .sender(sender)
                .message(message)
                .type(type)
                .build();
        return chatMessage;
    }

    public void setSender(String sender){
        this.sender=sender;
    }

    public void setMessage(String message){
        this.message=message;
    }

    // 메시지 타입 : 입장, 퇴장, 채팅
    public enum MessageType {
        ENTER, QUIT, TALK
    }
}
