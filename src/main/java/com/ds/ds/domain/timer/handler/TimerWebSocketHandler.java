package com.ds.ds.domain.timer.handler;

import com.ds.ds.domain.timer.domain.repository.TimerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
@RequiredArgsConstructor
public class TimerWebSocketHandler extends TextWebSocketHandler {
    private final TimerRepository timerRepository;
}
