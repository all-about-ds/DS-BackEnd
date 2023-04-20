package com.ds.ds.domain.chatting.domain.repository;

import com.ds.ds.domain.chatting.domain.entity.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoom,String> {
    Optional<ChatRoom> findById(String roomId);
    ChatRoom getChatRoomById(String roomId);

}