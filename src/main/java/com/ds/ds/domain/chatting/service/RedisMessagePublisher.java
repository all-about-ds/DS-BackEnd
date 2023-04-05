package com.ds.ds.domain.chatting.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

@Service
public class RedisMessagePublisher {
    private final RedisTemplate<String, Object> redisTemplate;
    private final ChannelTopic topic;

    public RedisMessagePublisher(RedisTemplate<String,Object> redisTemplate,ChannelTopic topic){
        this.redisTemplate = redisTemplate;
        this.topic = topic;
    }
    public void publish(String message) {
        redisTemplate.convertAndSend(topic.getTopic(),message);
    }
}
