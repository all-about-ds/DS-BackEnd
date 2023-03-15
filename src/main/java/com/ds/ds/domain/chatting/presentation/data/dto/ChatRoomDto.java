package com.ds.ds.domain.chatting.presentation.data.dto;

import lombok.*;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Builder
public class ChatRoomDto {
    private String roomId;
    private String name;
    private Set<WebSocketSession> socketSessions = new HashSet<>();
    // WebSocketSession 은 Spring 에서 Websocket Connection 이 맺어진 세션

    public static ChatRoomDto create(String name) {
        ChatRoomDto room = new ChatRoomDto();
        room.setRoomId(UUID.randomUUID().toString());
        room.setName(name);
        return room;
    }

}
