package com.ds.ds.domain.chatting.presentation.data.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class ChatRoom {
    private String roomId;
    private String roomName;
    private Long userCount;

    private final HashMap<String,String> userList = new HashMap<String,String>();

    public static ChatRoom create(String roomName){
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.roomId = UUID.randomUUID().toString();
        chatRoom.roomName =roomName;

        return chatRoom;
    }
}
