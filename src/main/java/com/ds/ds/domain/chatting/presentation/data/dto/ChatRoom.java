package com.ds.ds.domain.chatting.presentation.data.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
public class ChatRoom {
    private String roomId;
    private String roomName;
    private Long userCount;

    private final HashMap<String,String> userList = new HashMap<String,String>();
    private Set<WebSocketSession> sessions = new HashSet<>();

    public static ChatRoom create(String roomName){
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.roomId = UUID.randomUUID().toString();
        chatRoom.roomName =roomName;

        return chatRoom;
    }
}
