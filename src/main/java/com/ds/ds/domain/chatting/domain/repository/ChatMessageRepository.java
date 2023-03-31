package com.ds.ds.domain.chatting.domain.repository;

import com.ds.ds.domain.chatting.domain.entity.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
    List<ChatMessage> getChatMessageByRoomId(String roomid);
}
