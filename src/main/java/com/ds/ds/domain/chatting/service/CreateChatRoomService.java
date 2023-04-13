package com.ds.ds.domain.chatting.service;

import com.ds.ds.domain.chatting.domain.entity.ChatRoom;
import com.ds.ds.domain.chatting.presentation.data.dto.ChatDto;

public interface CreateChatRoomService {
   ChatRoom createChatRoom(ChatDto chatDto);
}
