package com.ds.ds.domain.timer.config;

import com.ds.ds.domain.timer.handler.TimerWebSocketHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
@RequiredArgsConstructor
public class TimerSocketConfig implements WebSocketConfigurer {
    private final TimerWebSocketHandler timerWebSocketHandler;
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(timerWebSocketHandler, "/timer")
                .setAllowedOrigins("*");
    }
}
