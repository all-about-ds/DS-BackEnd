package com.ds.ds.domain.chat.service;

import com.ds.ds.domain.chat.presentation.dto.ChatRoomDto;
import com.ds.ds.domain.chat.presentation.dto.ChatRoomMap;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class MsgChatService {
    public ChatRoomDto createChatRoom(String roomName, String roomPwd, boolean secretChk, int maxUserCnt){
        ChatRoomDto room = ChatRoomDto.builder()
                .roomId(UUID.randomUUID().toString())
                .roomName(roomName)
                .roomPwd(roomPwd)
                .secretChk(secretChk)
                .userCount(0)
                .maxUserCount(maxUserCnt)
                .build();
        //room.setUserList(new HashMap<String, String>());
        room.setChatType(ChatRoomDto.ChatType.MSG);
        ChatRoomMap.getInstance().getChatRooms().put(room.getRoomId(), room);

        return room;
    }
}
