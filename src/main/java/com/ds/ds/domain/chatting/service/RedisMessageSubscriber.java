package com.ds.ds.domain.chatting.service;

import com.ds.ds.domain.chatting.domain.entity.ChatMessage;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RedisMessageSubscriber implements MessageListener {
    private final List<Message> messageList = new ArrayList<>();

    public List<Message> getMessageList() {
        return messageList;
    }
    @Override
    public void onMessage(Message message, byte[] bytes) {
        messageList.add(message);
    }
}
