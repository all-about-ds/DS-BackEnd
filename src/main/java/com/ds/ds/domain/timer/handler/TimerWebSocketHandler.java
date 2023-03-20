package com.ds.ds.domain.timer.handler;

import com.ds.ds.domain.group.domain.entity.Group;
import com.ds.ds.domain.group.domain.repository.GroupRepository;
import com.ds.ds.domain.group.exception.GroupNotFoundException;
import com.ds.ds.domain.timer.domain.entity.Timer;
import com.ds.ds.domain.timer.domain.repository.TimerRepository;
import com.ds.ds.domain.user.domain.entity.User;
import com.ds.ds.domain.user.util.UserUtil;
import com.ds.ds.global.error.ErrorCode;
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

@Component
@RequiredArgsConstructor
public class TimerWebSocketHandler extends TextWebSocketHandler {
    private final TimerRepository timerRepository;
    private final GroupRepository groupRepository;
    private final UserUtil userUtil;
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        sendMessage(session, "Connected to the server!");
    }

    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        Long groupId = Long.valueOf(message.getPayload());
        User user = userUtil.currentUser();

        // 지정된 시간마다 데이터를 조회하여 전송
        scheduler.scheduleAtFixedRate(() -> {
            Group group = groupRepository.findById(groupId).orElseThrow(()-> new GroupNotFoundException(ErrorCode.GROUP_NOT_FOUND));
            List<Timer> timerList = timerRepository.findAllByGroup(group);


            if (myEntity != null) {

                sendMessage(session, information);
            }
        }, 0, 5, TimeUnit.SECONDS);
    }

    private void sendMessage(WebSocketSession session, String message) throws IOException {
        TextMessage textMessage = new TextMessage(message);
        session.sendMessage(textMessage);
    }
}
