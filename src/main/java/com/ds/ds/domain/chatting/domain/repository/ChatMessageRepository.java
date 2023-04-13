package com.ds.ds.domain.chatting.domain.repository;

import com.ds.ds.domain.chatting.domain.entity.ChatMessage;
import com.ds.ds.domain.chatting.domain.entity.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
    List<ChatMessage> findByChatRoom(ChatRoom chatRoom);
    List<ChatMessage> findByChatRoomAndTimestampBetween(ChatRoom chatRoom, Instant startTime, Instant endTime);
    ChatMessage save(ChatMessage chatMessage);


}
