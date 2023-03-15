package com.ds.ds.domain.chatting.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@Entity
public class ChatRoom implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chatroom_id")
    private String id;

    private static final long serialVersionUID = 6494678977089006639L;

    private String name;

    private UserIdDto customer;

    private UserIdDto store;

    @OneToMany(mappedBy = "chatRoom", cascade = CascadeType.ALL)
    private List<ChatMessage> chatMessages = new ArrayList<>();

    public static ChatRoom create(String name,UserIdDto customer,UserIdDto store) {
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.id = UUID.randomUUID().toString();
        chatRoom.name = name;
        chatRoom.customer=customer;
        chatRoom.store=store;
        return chatRoom;
    }

    public void addChatMessages(ChatMessage chatMessage) {
        this.chatMessages.add(chatMessage);
    }
}
