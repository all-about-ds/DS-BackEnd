package com.ds.ds.domain.chatting.domain.repository;

import com.ds.ds.domain.chatting.presentation.data.dto.ChatRoom;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class ChatRoomRepository {

    private Map<String, ChatRoom> chatRoomMap;

    @PostConstruct
    private void init(){
        chatRoomMap = new LinkedHashMap<>();
    }
    public List<ChatRoom> findAllRooms(){
        List<ChatRoom> result = new ArrayList<>(chatRoomMap.values());
        Collections.reverse(result);

        return result;
    }
    public ChatRoom findRoomById(String id){
        return chatRoomMap.get(id);
    }
    public ChatRoom createChatRoomDto(String name) {
        ChatRoom room = ChatRoom.create(name);
        chatRoomMap.put(room.getRoomId(),room);

        return room;
    }
}
