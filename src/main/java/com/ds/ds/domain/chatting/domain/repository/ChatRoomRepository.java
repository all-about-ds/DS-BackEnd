package com.ds.ds.domain.chatting.domain.repository;

import com.ds.ds.domain.chatting.domain.entity.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomRepository extends JpaRepository<ChatRoom,String> {
}