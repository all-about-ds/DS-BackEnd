package com.ds.ds.domain.timer.handler;

import com.ds.ds.domain.timer.presentation.data.dto.TimerDto;
import com.ds.ds.domain.timer.presentation.data.response.TimerResponse;
import com.ds.ds.domain.timer.service.FindTimerService;
import com.ds.ds.domain.timer.util.TimerConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TimerWebSocketHandler extends TextWebSocketHandler {
    private final FindTimerService findTimerService;
    private final TimerConverter timerConverter;
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        sendMessage(session, "Connected to the server!");
    }

    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        Long groupId = Long.valueOf(message.getPayload());

        // 지정된 시간마다 데이터를 조회하여 전송
        scheduler.scheduleAtFixedRate(() -> {
            TimerDto dto = findTimerService.findTimer(groupId);
            List<TimerResponse.MemberTimerResponse> memberTimerList = dto.getMemberTimerList().stream()
                    .map(it -> timerConverter.toResponse(it))
                    .collect(Collectors.toList());
            TimerResponse response = timerConverter.toResponse(dto, memberTimerList);

            try {
                sendMessage(session, response.toString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }, 0, 30, TimeUnit.SECONDS);
    }

    private void sendMessage(WebSocketSession session, String message) throws IOException {
        TextMessage textMessage = new TextMessage(message);
        session.sendMessage(textMessage);
    }
}
