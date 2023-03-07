package com.ds.ds.domain.chatting.presentation.data.dto;

import lombok.Data;

import java.util.HashMap;
import java.util.UUID;

@Data
public class ChatRoom {
    private String roomId;
    private String roomName;
    private Long userCount;

    private HashMap<String,String> userList = new HashMap<String,String>();

    public ChatRoom create(String roomName){
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.roomId = UUID.randomUUID().toString();
        chatRoom.roomName =roomName;

        return chatRoom;
    }
}
