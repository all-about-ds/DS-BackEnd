package com.ds.ds.domain.chatting.config;

import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

public class SpringConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws-stomp") // 연결된 엔드포인트
                .withSockJS();
    }
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //메세지를 구독하는 요청 url -> 매세지 받을 때
         registry.enableSimpleBroker("sub");

         //메세지를 발생하는 요청 url -> 매세지 보낼때
        registry.setApplicationDestinationPrefixes("/pub");
    }
}
