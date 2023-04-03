package com.ds.ds.domain.chatting.service;

import com.ds.ds.domain.chatting.domain.entity.ChatRoom;
import com.ds.ds.domain.user.domain.entity.User;

public interface CreateChatRoomService {
   ChatRoom createChatRoom(User sender, String other);
}
