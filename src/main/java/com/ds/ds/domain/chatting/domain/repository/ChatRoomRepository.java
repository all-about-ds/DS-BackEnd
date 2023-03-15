package com.ds.ds.domain.chatting.domain.repository;

import com.ds.ds.domain.chatting.domain.entity.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoom, String> {
    List<ChatRoom> findChatRoomByCustomer(UserIdDto cutomer);
    List<ChatRoom> findChatRoomsByStore(UserIdDto store);

}

