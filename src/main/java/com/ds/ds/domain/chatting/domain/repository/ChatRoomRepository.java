package com.ds.ds.domain.chatting.domain.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@RequiredArgsConstructor
@Service
public class ChatRoomRepository extends JpaRepository<ChatRoom,String> {
    List<ChatRoom> findChatRoomByCustomer(UserIdDto customer);
}