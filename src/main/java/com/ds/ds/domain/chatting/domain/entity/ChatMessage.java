package com.ds.ds.domain.chatting.domain.entity;

import com.amazonaws.services.kms.model.MessageType;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MessageType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chat_room_id")
    private ChatRoom chatRoom;
    private String sender;
    private String message;
    private LocalDateTime timestamp;

    public String getRoomId() {
        return chatRoom.getId();
    }
    @Builder
    public ChatMessage(ChatRoom chatRoom, String sender, String message, LocalDateTime timestamp) {
        this.chatRoom = chatRoom;
        this.sender = sender;
        this.message = message;
        this.timestamp = timestamp;
    }
}