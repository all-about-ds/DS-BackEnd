package com.ds.ds.domain.chatting.config.redis;

import com.ds.ds.domain.chatting.service.RedisMessagePublisher;
import com.ds.ds.domain.chatting.service.RedisMessageSubscriber;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

@Configuration
public class RedisMessageConfig {
    @Bean
    RedisMessageListenerContainer redisContainer(RedisConnectionFactory connectionFactory) {
        final RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        return container;
    }
    @Bean
    MessageListenerAdapter messageListenerAdapter(RedisMessageSubscriber redisMessageSubscriber) {
        return new MessageListenerAdapter(redisMessageSubscriber);
    }
    @Bean
    RedisMessageSubscriber redisMessageSubscriber() {
        return new RedisMessageSubscriber();
    }
    @Bean
    RedisMessagePublisher redisMessagePublisher(RedisTemplate<String, Object> redisTemplate, ChannelTopic topic) {
        return new RedisMessagePublisher(redisTemplate, topic);
    }
    @Bean
    ChannelTopic topic() {
        return new ChannelTopic("messageQueue");
    }
}
