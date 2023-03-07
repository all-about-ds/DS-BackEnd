package com.ds.ds.domain.chat.service;

import com.ds.ds.domain.chat.presentation.dto.ChatRoomDto;
import com.ds.ds.domain.chat.presentation.dto.ChatRoomMap;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Getter
@Setter
@RequiredArgsConstructor
@Slf4j
public class ChatService {
    private final MsgChatService msgChatServce;
    private final RtcChatService rtcChatService;
    //전체 방 조회
    public List<ChatRoomDto> findAllRoom(){
        List<ChatRoomDto> chatRooms = new ArrayList<>(ChatRoomMap.getInstance().getChatRooms().values());
        Collections.reverse(chatRooms);

        return chatRooms;
    }

    public ChatRoomDto findRoomById(String roomId){
        return ChatRoomMap.getInstance().getChatRooms().get(roomId);
    }

    public ChatRoomDto createChatRoom(String roomName, String roomPwd, boolean secretChk, int maxUserCnt, String chatType) {
        ChatRoomDto room;

        if (chatType.equals("msgChat")) {
            room = msgChatServce.createChatRoom(roomName, roomPwd, secretChk, maxUserCnt);
        } else {
            room = rtcChatService.createChatRoom(roomName, roomPwd, secretChk, maxUserCnt);
        }
        return room;
    }
    //채팅방 비밀번호 조회
    public boolean confiemPwd(String roomId, String roomPwd) {
        return roomPwd.equals(ChatRoomMap.getInstance().getChatRooms().get(roomId).getRoomPwd());
    }
    //방인원 +1
    public void plusUserCnt(String roomId){
        log.info("cht{}",ChatRoomMap.getInstance().getChatRooms().get(roomId).getUserCount());
        ChatRoomDto room = ChatRoomMap.getInstance().getChatRooms().get(roomId);
        room.setUserCount(room.getUserCount()+1);
    }

}
