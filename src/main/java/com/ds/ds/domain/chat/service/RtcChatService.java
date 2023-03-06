package com.ds.ds.domain.chat.service;

import com.ds.ds.domain.chat.presentation.dto.ChatRoomDto;
import com.ds.ds.domain.chat.presentation.dto.KurentoRoomDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kurento.client.KurentoClient;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class RtcChatService {
    private final KurentoClient kurento;

    public KurentoRoomDto createChatRoom(String roomName, String roomPwd, boolean secretChk, int maxUserCht){

        KurentoRoomDto room = new KurentoRoomDto();
        String roomId = UUID.randomUUID().toString();
        room.setRoomInfo(roomId, roomName, secretChk, 0, maxUserCht, ChatRoomDto.ChatType.RTC, kurento);

    }
}
