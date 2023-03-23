package com.ds.ds.domain.chatting.service.impl;

import com.ds.ds.domain.chatting.presentation.data.dto.ChatRoom;
import com.ds.ds.domain.chatting.service.CreateChatRoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class CreateChatRoomServiceImpl implements CreateChatRoomService {
    private Map<String, ChatRoom> chatRooms;

    @Override
    public ChatRoom createChatRoom(String name) {
        String randomId = UUID.randomUUID().toString();
        ChatRoom chatRoom = new ChatRoom(randomId, name);

        chatRooms.put(randomId, chatRoom);
        return chatRoom;
    }

}
